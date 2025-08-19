package com.editium.core.video.domain.media

import android.media.MediaCodec
import android.media.MediaCodecInfo
import android.media.MediaExtractor
import android.media.MediaFormat
import android.view.Surface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.isActive
import kotlinx.coroutines.yield
import timber.log.Timber
import java.nio.ByteBuffer

class MediaDecoder(
    private val scope: CoroutineScope
) {
    data class TrackInfo(
        val format: MediaFormat,
        val index: Int
    )

    private var codec: MediaCodec? = null
    private var extractor: MediaExtractor? = null

    fun init(inputPath: String, outputSurface: Surface): TrackInfo {
        val localExtractor = MediaExtractor()
        localExtractor.setDataSource(inputPath)
        val trackIndex = selectVideoTrack(localExtractor)
        require(trackIndex >= 0) { "No video track found in $inputPath" }
        localExtractor.selectTrack(trackIndex)
        val format = localExtractor.getTrackFormat(trackIndex)

        val mime = format.getString(MediaFormat.KEY_MIME) ?: error("MIME missing")
        val localCodec = MediaCodec.createDecoderByType(mime)
        // Prefer hardware with surface output
        format.setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface)
        localCodec.configure(format, outputSurface, null, 0)
        localCodec.start()

        extractor = localExtractor
        codec = localCodec

        return TrackInfo(format = format, index = trackIndex)
    }

    suspend fun decode(onFrameAvailable: (presentationTimeUs: Long, isEos: Boolean) -> Unit) {
        val localExtractor = extractor ?: return
        val localCodec = codec ?: return
        var sawInputEOS = false
        var sawOutputEOS = false

        while (scope.isActive && !sawOutputEOS) {
            // Feed input
            if (!sawInputEOS) {
                val inputBufferIndex = localCodec.dequeueInputBuffer(10_000)
                if (inputBufferIndex >= 0) {
                    val inputBuffer: ByteBuffer? = localCodec.getInputBuffer(inputBufferIndex)
                    val sampleSize = inputBuffer?.let { localExtractor.readSampleData(it, 0) } ?: -1
                    if (sampleSize < 0) {
                        localCodec.queueInputBuffer(
                            inputBufferIndex,
                            0,
                            0,
                            0,
                            MediaCodec.BUFFER_FLAG_END_OF_STREAM
                        )
                        sawInputEOS = true
                    } else {
                        val presentationTimeUs = localExtractor.sampleTime
                        localCodec.queueInputBuffer(inputBufferIndex, 0, sampleSize, presentationTimeUs, 0)
                        localExtractor.advance()
                    }
                }
            }

            // Drain output
            val bufferInfo = MediaCodec.BufferInfo()
            val outputBufferIndex = localCodec.dequeueOutputBuffer(bufferInfo, 10_000)
            if (outputBufferIndex >= 0) {
                val isEosFlag = bufferInfo.flags and MediaCodec.BUFFER_FLAG_END_OF_STREAM != 0
                try {
                    localCodec.releaseOutputBuffer(outputBufferIndex, true)
                } catch (t: Throwable) {
                    Timber.w(t, "releaseOutputBuffer failed")
                }
                onFrameAvailable(bufferInfo.presentationTimeUs, isEosFlag)
                if (isEosFlag) sawOutputEOS = true
            }

            yield()
        }
    }

    fun seekToUs(positionUs: Long, mode: Int = MediaExtractor.SEEK_TO_PREVIOUS_SYNC) {
        extractor?.seekTo(positionUs, mode)
    }

    fun release() {
        runCatching { codec?.stop() }.onFailure { Timber.w(it) }
        runCatching { codec?.release() }.onFailure { Timber.w(it) }
        codec = null
        runCatching { extractor?.release() }.onFailure { Timber.w(it) }
        extractor = null
    }

    private fun selectVideoTrack(extractor: MediaExtractor): Int {
        for (i in 0 until extractor.trackCount) {
            val format = extractor.getTrackFormat(i)
            val mime = format.getString(MediaFormat.KEY_MIME) ?: continue
            if (mime.startsWith("video/")) return i
        }
        return -1
    }
}
