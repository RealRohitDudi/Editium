package com.editium.core.video.domain.thumbnail

import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ThumbnailEngine {
    suspend fun extractFrame(path: String, timeUs: Long, width: Int, height: Int): Bitmap? = withContext(Dispatchers.IO) {
        val retriever = MediaMetadataRetriever()
        runCatching {
            retriever.setDataSource(path)
            val bmp = retriever.getFrameAtTime(timeUs, MediaMetadataRetriever.OPTION_CLOSEST_SYNC)
            bmp?.let { Bitmap.createScaledBitmap(it, width, height, true) }
        }.onFailure { }.also { retriever.release() }.getOrNull()
    }
}

