package com.editium.core.data.domain.cache

import android.content.Context
import android.graphics.Bitmap
import android.util.LruCache
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.File
import java.util.concurrent.ConcurrentHashMap

class CacheManager(
    private val context: Context
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val memoryClassMb: Int by lazy {
        // Approx: allocate up to 1/6th of app memory class to frame cache
        (Runtime.getRuntime().maxMemory() / (1024 * 1024)).toInt()
    }

    private val bitmapPool = object : LruCache<Int, Bitmap>(16) {
        override fun sizeOf(key: Int, value: Bitmap): Int = value.byteCount / 1024
    }

    private val frameCache = object : LruCache<Long, Bitmap>((memoryClassMb / 6) * 1024) {
        override fun sizeOf(key: Long, value: Bitmap): Int = value.byteCount / 1024
        override fun entryRemoved(evicted: Boolean, key: Long, oldValue: Bitmap, newValue: Bitmap?) {
            if (evicted) recycleBitmap(oldValue)
        }
    }

    private val diskDir: File by lazy { File(context.cacheDir, "video_frames").apply { mkdirs() } }
    private val inflight = ConcurrentHashMap<Long, Unit>()

    fun putFrame(ptsUs: Long, bmp: Bitmap) {
        frameCache.put(ptsUs, bmp)
        scope.launch { writeCompressed(ptsUs, bmp) }
    }

    fun getFrame(ptsUs: Long): Bitmap? = frameCache.get(ptsUs) ?: readCompressed(ptsUs)

    fun obtainBitmap(width: Int, height: Int): Bitmap {
        val key = width shl 16 or height
        return bitmapPool.remove(key) ?: Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    }

    fun recycleBitmap(bitmap: Bitmap) {
        val key = bitmap.width shl 16 or bitmap.height
        bitmapPool.put(key, bitmap)
    }

    private fun writeCompressed(ptsUs: Long, bmp: Bitmap) {
        kotlin.runCatching {
            val file = File(diskDir, "$ptsUs.webp")
            file.outputStream().use { os ->
                bmp.compress(Bitmap.CompressFormat.WEBP_LOSSY, 80, os)
            }
        }
    }

    private fun readCompressed(ptsUs: Long): Bitmap? {
        val file = File(diskDir, "$ptsUs.webp")
        if (!file.exists()) return null
        return kotlin.runCatching { android.graphics.BitmapFactory.decodeFile(file.absolutePath) }.getOrNull()
    }
}
