package com.editium.feature.timeline.domain

import com.editium.feature.timeline.domain.model.Timeline
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class TimelineManager {
    private val mutex = Mutex()
    private var timeline = Timeline(emptyList())

    suspend fun setTimeline(newTimeline: Timeline) = mutex.withLock { timeline = newTimeline }

    suspend fun getTimeline(): Timeline = mutex.withLock { timeline }

    suspend fun addClip(trackIndex: Int, clip: Timeline.Clip) = mutex.withLock {
        val tracks = timeline.tracks.toMutableList()
        if (trackIndex < tracks.size) {
            val track = tracks[trackIndex]
            val updatedTrack = track.copy(clips = track.clips + clip)
            tracks[trackIndex] = updatedTrack
            timeline = timeline.copy(tracks = tracks)
        }
    }
}

