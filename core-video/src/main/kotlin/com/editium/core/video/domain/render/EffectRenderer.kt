package com.editium.core.video.domain.render

import android.content.res.AssetManager
import android.opengl.GLES11Ext
import android.opengl.GLES30
import java.nio.charset.Charset

class EffectRenderer(
    assets: AssetManager
) {
    private val vertexSrc = assets.open("shaders/common.vert").use { it.readBytes().toString(Charset.defaultCharset()) }
    private val fragSrc = assets.open("shaders/color_grading.frag").use { it.readBytes().toString(Charset.defaultCharset()) }
    private val program = ShaderProgram(vertexSrc, fragSrc)
    private val pipeline = GpuPipeline(program)

    fun renderExternalTexture(oesTexId: Int) {
        GLES30.glViewport(0, 0, currentWidth, currentHeight)
        GLES30.glClearColor(0f, 0f, 0f, 1f)
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT)
        GLES30.glDisable(GLES30.GL_DEPTH_TEST)
        GLES30.glDisable(GLES30.GL_CULL_FACE)

        GLES30.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, oesTexId)
        pipeline.drawOesTexture(oesTexId)
        GLES30.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 0)
    }

    private var currentWidth: Int = 1
    private var currentHeight: Int = 1
    fun setViewport(width: Int, height: Int) {
        currentWidth = width
        currentHeight = height
    }
}
