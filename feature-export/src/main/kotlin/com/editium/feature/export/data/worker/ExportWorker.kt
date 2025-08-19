package com.editium.feature.export.data.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.editium.feature.export.domain.ExportEngine
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class ExportWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val exportEngine: ExportEngine
) : CoroutineWorker(context, params) {

    override suspend fun getForegroundInfo(): ForegroundInfo {
        val channelId = "export"
        val manager = androidx.core.app.NotificationManagerCompat.from(applicationContext)
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            val ch = android.app.NotificationChannel(channelId, "Export", android.app.NotificationManager.IMPORTANCE_LOW)
            (applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager)
                .createNotificationChannel(ch)
        }
        val notif = androidx.core.app.NotificationCompat.Builder(applicationContext, channelId)
            .setContentTitle("Exporting video")
            .setSmallIcon(android.R.drawable.stat_sys_upload)
            .setOngoing(true)
            .setProgress(0, 0, true)
            .build()
        return ForegroundInfo(1001, notif)
    }

    override suspend fun doWork(): Result {
        val input = inputData
        val inPath = input.getString("input") ?: return Result.failure()
        val outPath = input.getString("output") ?: return Result.failure()
        val width = input.getInt("width", 1920)
        val height = input.getInt("height", 1080)
        val bitrate = input.getInt("bitrate", 8_000_000)
        val fps = input.getInt("fps", 30)
        return try {
            exportEngine.exportMp4(inPath, outPath, width, height, bitrate, fps)
            Result.success()
        } catch (t: Throwable) {
            Result.retry()
        }
    }
}
