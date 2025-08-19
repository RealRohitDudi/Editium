package com.editium.core.video.domain.media

import android.media.MediaCodec
import android.media.MediaFormat
import android.media.MediaMuxer
import timber.log.Timber
import java.io.File

class MediaMuxerFacade(
    outputPath: String,
    format: Int = MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4
) {
    private val muxer = MediaMuxer(outputPath, format)
    private var videoTrackIndex: Int = -1
    private var audioTrackIndex: Int = -1
    private var started = false

    fun addVideoTrack(format: MediaFormat): Int {
        check(!started) { "Muxer already started" }
        videoTrackIndex = muxer.addTrack(format)
        return videoTrackIndex
    }

    fun addAudioTrack(format: MediaFormat): Int {
        check(!started) { "Muxer already started" }
        audioTrackIndex = muxer.addTrack(format)
        return audioTrackIndex
    }

    fun start() {
        check(!started) { "Muxer already started" }
        muxer.start()
        started = true
    }

    fun writeVideoSample(buffer: java.nio.ByteBuffer, info: MediaCodec.BufferInfo) {
        if (!started || videoTrackIndex < 0) return
        try { muxer.writeSampleData(videoTrackIndex, buffer, info) } catch (t: Throwable) { Timber.w(t) }
    }

    fun writeAudioSample(buffer: java.nio.ByteBuffer, info: MediaCodec.BufferInfo) {
        if (!started || audioTrackIndex < 0) return
        try { muxer.writeSampleData(audioTrackIndex, buffer, info) } catch (t: Throwable) { Timber.w(t) }
    }

    fun release() {
        runCatching { if (started) muxer.stop() }.onFailure { Timber.w(it) }
        runCatching { muxer.release() }.onFailure { Timber.w(it) }
    }
}
