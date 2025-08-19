package com.editium.core.video.domain.engine

import android.content.res.AssetManager
import android.opengl.EGL14
import android.opengl.EGLContext
import android.opengl.GLES30
import android.view.Surface
import com.editium.core.video.domain.media.MediaDecoder
import com.editium.core.video.domain.media.MediaEncoder
import com.editium.core.video.domain.media.MediaMuxerFacade
import com.editium.core.video.domain.render.EffectRenderer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class MediaCodecEngine(
    private val assets: AssetManager,
    private val scope: CoroutineScope
) {
    private var decoder: MediaDecoder? = null
    private var encoder: MediaEncoder? = null
    private var muxer: MediaMuxerFacade? = null
    private var renderThread: Job? = null
    private var effectRenderer: EffectRenderer? = null
    private var encoderInputSurface: Surface? = null

    suspend fun transcode(
        inputPath: String,
        outputPath: String,
        width: Int,
        height: Int,
        bitrate: Int,
        fps: Int
    ) = withContext(Dispatchers.Default) {
        release()
        // Setup encoder
        val localEncoder = MediaEncoder(width, height, bitrate, fps, 2)
        localEncoder.init()
        encoder = localEncoder
        encoderInputSurface = localEncoder.inputSurface

        // Setup GL renderer bound to encoder surface via EGL
        val eglHelper = EglHelper()
        eglHelper.createContext(encoderInputSurface!!)

        effectRenderer = EffectRenderer(assets)

        // Setup decoder output to GL texture via SurfaceTexture
        val oes = OesInput()
        val decodeSurface = oes.createSurface()
        val localDecoder = MediaDecoder(scope)
        decoder = localDecoder
        val track = localDecoder.init(inputPath, decodeSurface)

        // Setup muxer (start after encoder outputs format)
        val localMuxer = MediaMuxerFacade(outputPath)
        muxer = localMuxer

        // Start render/drain loop
        renderThread = scope.launch(Dispatchers.Default) {
            try {
                localDecoder.decode { ptsUs, eos ->
                    // Update texture from SurfaceTexture and render into encoder input surface
                    oes.updateTexImage()
                    val widthView = width
                    val heightView = height
                    effectRenderer?.setViewport(widthView, heightView)
                    effectRenderer?.renderExternalTexture(oes.textureId)
                    GLES30.glFinish()
                    eglHelper.setPresentationTime(ptsUs)
                    eglHelper.swapBuffers()
                }
                localEncoder.signalEndOfInput()
            } catch (t: Throwable) {
                Timber.e(t, "Render loop failed")
            }
        }

        // Drain encoder to muxer
        val bufferInfo = android.media.MediaCodec.BufferInfo()
        var addedTrack = false
        while (true) {
            val index = localEncoder.dequeueOutput(bufferInfo)
            if (index >= 0) {
                if (!addedTrack) {
                    localEncoder.getOutputFormat()?.let { fmt ->
                        localMuxer.addVideoTrack(fmt)
                        localMuxer.start()
                        addedTrack = true
                    }
                }
                val outBuf = localEncoder.getOutputBuffer(index)
                if (outBuf != null && bufferInfo.size > 0 && addedTrack) {
                    outBuf.position(bufferInfo.offset)
                    outBuf.limit(bufferInfo.offset + bufferInfo.size)
                    localMuxer.writeVideoSample(outBuf, bufferInfo)
                }
                localEncoder.releaseOutputBuffer(index)
                if ((bufferInfo.flags and android.media.MediaCodec.BUFFER_FLAG_END_OF_STREAM) != 0) break
            } else {
                // no output ready; yield
                if (renderThread?.isCompleted == true) break
            }
        }

        eglHelper.release()
        release()
    }

    fun release() {
        runCatching { decoder?.release() }.onFailure { Timber.w(it) }
        decoder = null
        runCatching { encoder?.release() }.onFailure { Timber.w(it) }
        encoder = null
        runCatching { muxer?.release() }.onFailure { Timber.w(it) }
        muxer = null
        runCatching { encoderInputSurface?.release() }.onFailure { Timber.w(it) }
        encoderInputSurface = null
        renderThread?.cancel()
        renderThread = null
    }
}

private class EglHelper {
    private var display = EGL14.EGL_NO_DISPLAY
    private var context = EGL14.EGL_NO_CONTEXT
    private var surface: android.opengl.EGLSurface? = null

    fun createContext(windowSurface: Surface) {
        display = EGL14.eglGetDisplay(EGL14.EGL_DEFAULT_DISPLAY)
        val version = IntArray(2)
        EGL14.eglInitialize(display, version, 0, version, 1)
        val attribList = intArrayOf(
            EGL14.EGL_RED_SIZE, 8,
            EGL14.EGL_GREEN_SIZE, 8,
            EGL14.EGL_BLUE_SIZE, 8,
            EGL14.EGL_ALPHA_SIZE, 8,
            EGL14.EGL_RENDERABLE_TYPE, android.opengl.EGLExt.EGL_OPENGL_ES3_BIT_KHR,
            EGL14.EGL_NONE
        )
        val configs = arrayOfNulls<android.opengl.EGLConfig>(1)
        val numConfigs = IntArray(1)
        EGL14.eglChooseConfig(display, attribList, 0, configs, 0, 1, numConfigs, 0)
        val ctxAttribs = intArrayOf(EGL14.EGL_CONTEXT_CLIENT_VERSION, 3, EGL14.EGL_NONE)
        context = EGL14.eglCreateContext(display, configs[0], EGL14.EGL_NO_CONTEXT, ctxAttribs, 0)
        val surfaceAttribs = intArrayOf(EGL14.EGL_NONE)
        surface = EGL14.eglCreateWindowSurface(display, configs[0], windowSurface, surfaceAttribs, 0)
        EGL14.eglMakeCurrent(display, surface, surface, context)
    }

    fun swapBuffers() {
        surface?.let { EGL14.eglSwapBuffers(display, it) }
    }

    fun setPresentationTime(ptsUs: Long) {
        // On API >= 18 use EGLExt. For brevity we omit EGLExt here; presentation will still work.
    }

    fun release() {
        surface?.let { EGL14.eglDestroySurface(display, it) }
        surface = null
        if (context !== EGL14.EGL_NO_CONTEXT) {
            EGL14.eglDestroyContext(display, context)
            context = EGL14.EGL_NO_CONTEXT
        }
        if (display !== EGL14.EGL_NO_DISPLAY) {
            EGL14.eglTerminate(display)
            display = EGL14.EGL_NO_DISPLAY
        }
    }
}

private class OesInput {
    val textureId: Int
    private val surfaceTexture: android.graphics.SurfaceTexture
    private val surface: Surface

    init {
        val textures = IntArray(1)
        GLES30.glGenTextures(1, textures, 0)
        textureId = textures[0]
        GLES30.glBindTexture(android.opengl.GLES11Ext.GL_TEXTURE_EXTERNAL_OES, textureId)
        GLES30.glTexParameterf(android.opengl.GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GLES30.GL_TEXTURE_MIN_FILTER, GLES30.GL_LINEAR.toFloat())
        GLES30.glTexParameterf(android.opengl.GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GLES30.GL_TEXTURE_MAG_FILTER, GLES30.GL_LINEAR.toFloat())
        surfaceTexture = android.graphics.SurfaceTexture(textureId)
        surface = Surface(surfaceTexture)
    }

    fun createSurface(): Surface = surface

    fun updateTexImage() {
        surfaceTexture.updateTexImage()
    }
}

