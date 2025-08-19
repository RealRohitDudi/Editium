package com.editium.feature.timeline.domain

import android.graphics.Bitmap
import com.editium.core.video.domain.cache.VideoCache

class TrackRenderer(
    private val cache: VideoCache
) {
    fun compositeFrame(ptsUs: Long, base: Bitmap, overlays: List<Bitmap>): Bitmap {
        // Simplified: return base and cache it. Real compositing happens on GPU in core-video
        cache.putFrame(ptsUs, base)
        return base
    }
}

