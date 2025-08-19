package com.editium.core.video.domain.proxy

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

class ProxyGenerator(
    private val context: Context
) {
    suspend fun generateProxy(inputPath: String, targetLongEdge: Int = 720): File = withContext(Dispatchers.IO) {
        val out = File(context.cacheDir, "proxy_${System.currentTimeMillis()}.mp4")
        // Placeholder: In production, use FFmpeg or MediaCodec scaling pipeline
        out
    }
}

