package com.editium.core.video.domain.media

import android.media.MediaCodec
import android.media.MediaCodecInfo
import android.media.MediaFormat
import android.view.Surface
import timber.log.Timber

class MediaEncoder(
    private val width: Int,
    private val height: Int,
    private val bitRate: Int,
    private val frameRate: Int,
    private val iFrameIntervalSec: Int
) {
    private var codec: MediaCodec? = null
    var inputSurface: Surface? = null
        private set

    fun init(mime: String = MediaFormat.MIMETYPE_VIDEO_AVC) {
        val format = MediaFormat.createVideoFormat(mime, width, height)
        format.setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface)
        format.setInteger(MediaFormat.KEY_BIT_RATE, bitRate)
        format.setInteger(MediaFormat.KEY_FRAME_RATE, frameRate)
        format.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, iFrameIntervalSec)
        // Rate control: use CBR for predictable thermals
        format.setInteger(MediaFormat.KEY_BITRATE_MODE, MediaCodecInfo.EncoderCapabilities.BITRATE_MODE_CBR)

        val localCodec = MediaCodec.createEncoderByType(mime)
        localCodec.configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE)
        inputSurface = localCodec.createInputSurface()
        localCodec.start()
        codec = localCodec
    }

    fun dequeueOutput(bufferInfo: MediaCodec.BufferInfo, timeoutUs: Long = 10_000): Int {
        return codec?.dequeueOutputBuffer(bufferInfo, timeoutUs) ?: -1
    }

    fun getOutputFormat(): MediaFormat? = codec?.outputFormat

    fun getOutputBuffer(index: Int) = codec?.getOutputBuffer(index)

    fun releaseOutputBuffer(index: Int) {
        try { codec?.releaseOutputBuffer(index, false) } catch (t: Throwable) { Timber.w(t) }
    }

    fun signalEndOfInput() {
        try { codec?.signalEndOfInputStream() } catch (t: Throwable) { Timber.w(t) }
    }

    fun release() {
        runCatching { codec?.stop() }.onFailure { Timber.w(it) }
        runCatching { codec?.release() }.onFailure { Timber.w(it) }
        inputSurface?.release()
        inputSurface = null
        codec = null
    }
}
