package com.editium.app.ui.editor;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/editium/app/ui/editor/VideoEditorViewModel;", "Landroidx/lifecycle/ViewModel;", "videoProcessor", "Lcom/editium/core/video/domain/engine/VideoProcessor;", "(Lcom/editium/core/video/domain/engine/VideoProcessor;)V", "_playhead", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "playback", "Lcom/editium/feature/timeline/domain/PlaybackEngine;", "playhead", "Lkotlinx/coroutines/flow/StateFlow;", "getPlayhead", "()Lkotlinx/coroutines/flow/StateFlow;", "pause", "", "play", "seekToUs", "us", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class VideoEditorViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.editium.core.video.domain.engine.VideoProcessor videoProcessor = null;
    @org.jetbrains.annotations.NotNull()
    private final com.editium.feature.timeline.domain.PlaybackEngine playback = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Long> _playhead = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> playhead = null;
    
    @javax.inject.Inject()
    public VideoEditorViewModel(@org.jetbrains.annotations.NotNull()
    com.editium.core.video.domain.engine.VideoProcessor videoProcessor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getPlayhead() {
        return null;
    }
    
    public final void play() {
    }
    
    public final void pause() {
    }
    
    public final void seekToUs(long us) {
    }
}