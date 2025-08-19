package com.editium.core.video.domain.render

import android.opengl.GLES11Ext
import android.opengl.GLES30
import android.opengl.Matrix

class GpuPipeline(
    private val shader: ShaderProgram
) {
    private val vertexData = floatArrayOf(
        -1f, -1f, 0f, 1f,
        1f, -1f, 1f, 1f,
        -1f, 1f, 0f, 0f,
        1f, 1f, 1f, 0f
    )
    private val mvpMatrix = FloatArray(16).apply { Matrix.setIdentityM(this, 0) }

    private var vertexBufferId = 0

    init {
        val buffers = IntArray(1)
        GLES30.glGenBuffers(1, buffers, 0)
        vertexBufferId = buffers[0]
        GLES30.glBindBuffer(GLES30.GL_ARRAY_BUFFER, vertexBufferId)
        val bb = java.nio.ByteBuffer.allocateDirect(vertexData.size * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer()
        bb.put(vertexData).position(0)
        GLES30.glBufferData(GLES30.GL_ARRAY_BUFFER, vertexData.size * 4, bb, GLES30.GL_STATIC_DRAW)
        GLES30.glBindBuffer(GLES30.GL_ARRAY_BUFFER, 0)
    }

    fun drawOesTexture(oesTextureId: Int) {
        shader.use()
        val posLoc = shader.getAttribLocation("aPosition")
        val texLoc = shader.getAttribLocation("aTexCoord")
        val mvpLoc = shader.getUniformLocation("uMVP")
        val samplerLoc = shader.getUniformLocation("uTexture")

        GLES30.glBindBuffer(GLES30.GL_ARRAY_BUFFER, vertexBufferId)
        GLES30.glEnableVertexAttribArray(posLoc)
        GLES30.glVertexAttribPointer(posLoc, 2, GLES30.GL_FLOAT, false, 16, 0)
        GLES30.glEnableVertexAttribArray(texLoc)
        GLES30.glVertexAttribPointer(texLoc, 2, GLES30.GL_FLOAT, false, 16, 8)

        GLES30.glUniformMatrix4fv(mvpLoc, 1, false, mvpMatrix, 0)
        GLES30.glActiveTexture(GLES30.GL_TEXTURE0)
        GLES30.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, oesTextureId)
        GLES30.glUniform1i(samplerLoc, 0)

        GLES30.glDrawArrays(GLES30.GL_TRIANGLE_STRIP, 0, 4)

        GLES30.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 0)
        GLES30.glDisableVertexAttribArray(posLoc)
        GLES30.glDisableVertexAttribArray(texLoc)
        GLES30.glBindBuffer(GLES30.GL_ARRAY_BUFFER, 0)
    }
}
