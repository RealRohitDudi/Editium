package com.editium.feature.export.domain

import com.editium.core.video.domain.engine.VideoProcessor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExportEngine(
    private val videoProcessor: VideoProcessor,
    private val scope: CoroutineScope
) {
    suspend fun exportMp4(
        inputPath: String,
        outputPath: String,
        width: Int,
        height: Int,
        bitrate: Int,
        fps: Int
    ) = withContext(Dispatchers.Default) {
        videoProcessor.transcodeToMp4(inputPath, outputPath, width, height, bitrate, fps)
    }
}

