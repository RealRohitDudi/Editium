package com.editium.feature.timeline.domain.model

data class Timeline(
    val tracks: List<Track> = emptyList()
) {
    data class Track(
        val id: String = "",
        val name: String = "",
        val clips: List<Clip> = emptyList()
    )
    
    data class Clip(
        val id: String = "",
        val name: String = "",
        val start: Long = 0,
        val duration: Long = 0
    )
}
