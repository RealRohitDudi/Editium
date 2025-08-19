package com.editium.core.video.domain.engine

import android.content.Context
import android.content.res.AssetManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VideoProcessor @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    suspend fun transcodeToMp4(
        inputPath: String,
        outputPath: String,
        width: Int,
        height: Int,
        bitrate: Int = 12_000_000,
        fps: Int = 30
    ) = withContext(Dispatchers.Default) {
        val engine = MediaCodecEngine(context.assets, scope)
        try {
            engine.transcode(inputPath, outputPath, width, height, bitrate, fps)
        } catch (t: Throwable) {
            Timber.e(t, "Transcode failed")
            throw t
        } finally {
            engine.release()
        }
    }
}
