package com.editium.feature.timeline.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.math.max

class PlaybackEngine(
    private val scope: CoroutineScope,
    private val onTick: (positionUs: Long) -> Unit,
    private val fps: Int = 30
) {
    private val mutex = Mutex()
    private var isPlaying = false
    private var job: Job? = null
    private var positionUs: Long = 0L

    suspend fun seekTo(positionUs: Long) = mutex.withLock { this.positionUs = positionUs }

    fun play() {
        if (isPlaying) return
        isPlaying = true
        val frameIntervalMs = max(1L, 1000L / fps)
        job = scope.launch(Dispatchers.Default) {
            while (isActive && isPlaying) {
                val start = System.nanoTime()
                val pos = mutex.withLock { positionUs += frameIntervalMs * 1000L; positionUs }
                onTick(pos)
                val elapsedMs = (System.nanoTime() - start) / 1_000_000
                val sleep = frameIntervalMs - elapsedMs
                if (sleep > 0) delay(sleep)
            }
        }
    }

    fun pause() {
        isPlaying = false
        job?.cancel()
        job = null
    }
}

