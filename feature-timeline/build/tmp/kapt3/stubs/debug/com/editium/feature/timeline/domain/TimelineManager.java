package com.editium.feature.timeline.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/editium/feature/timeline/domain/TimelineManager;", "", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "timeline", "Lcom/editium/feature/timeline/domain/model/Timeline;", "addClip", "", "trackIndex", "", "clip", "Lcom/editium/feature/timeline/domain/model/Timeline$Clip;", "(ILcom/editium/feature/timeline/domain/model/Timeline$Clip;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTimeline", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTimeline", "newTimeline", "(Lcom/editium/feature/timeline/domain/model/Timeline;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "feature-timeline_debug"})
public final class TimelineManager {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.sync.Mutex mutex = null;
    @org.jetbrains.annotations.NotNull()
    private com.editium.feature.timeline.domain.model.Timeline timeline;
    
    public TimelineManager() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setTimeline(@org.jetbrains.annotations.NotNull()
    com.editium.feature.timeline.domain.model.Timeline newTimeline, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTimeline(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.editium.feature.timeline.domain.model.Timeline> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addClip(int trackIndex, @org.jetbrains.annotations.NotNull()
    com.editium.feature.timeline.domain.model.Timeline.Clip clip, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}