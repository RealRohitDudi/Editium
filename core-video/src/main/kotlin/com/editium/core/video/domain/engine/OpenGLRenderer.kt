package com.editium.core.video.domain.engine

import android.content.res.AssetManager
import android.view.Surface
import com.editium.core.video.domain.render.EffectRenderer

class OpenGLRenderer(
    assets: AssetManager
) {
    private val effectRenderer = EffectRenderer(assets)

    fun onSurfaceChanged(width: Int, height: Int) {
        effectRenderer.setViewport(width, height)
    }
}

