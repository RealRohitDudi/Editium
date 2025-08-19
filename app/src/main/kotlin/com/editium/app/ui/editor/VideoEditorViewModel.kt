package com.editium.app.ui.editor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.editium.core.video.domain.engine.VideoProcessor
import com.editium.feature.timeline.domain.PlaybackEngine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoEditorViewModel @Inject constructor(
    private val videoProcessor: VideoProcessor
) : ViewModel() {
    private val playback = PlaybackEngine(viewModelScope, { positionUs ->
        _playhead.value = positionUs
    })

    private val _playhead = MutableStateFlow(0L)
    val playhead = _playhead.asStateFlow()

    fun play() { playback.play() }
    fun pause() { playback.pause() }
    fun seekToUs(us: Long) { viewModelScope.launch { playback.seekTo(us) } }
}

