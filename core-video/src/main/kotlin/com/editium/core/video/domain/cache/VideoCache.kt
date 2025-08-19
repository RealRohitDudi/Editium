package com.editium.core.video.domain.cache

import android.graphics.Bitmap
import android.util.LruCache
import javax.inject.Singleton

@Singleton
class VideoCache {
    private val frameCache = object : LruCache<Long, Bitmap>((Runtime.getRuntime().maxMemory() / (1024 * 1024) / 8).toInt() * 1024) {
        override fun sizeOf(key: Long, value: Bitmap): Int = value.byteCount / 1024
    }

    fun putFrame(ptsUs: Long, bitmap: Bitmap) { frameCache.put(ptsUs, bitmap) }

    fun getFrame(ptsUs: Long): Bitmap? = frameCache.get(ptsUs)

    fun clear() { frameCache.evictAll() }
}

