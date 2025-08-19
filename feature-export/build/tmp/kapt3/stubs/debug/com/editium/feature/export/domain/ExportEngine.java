package com.editium.feature.export.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J>\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/editium/feature/export/domain/ExportEngine;", "", "videoProcessor", "Lcom/editium/core/video/domain/engine/VideoProcessor;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/editium/core/video/domain/engine/VideoProcessor;Lkotlinx/coroutines/CoroutineScope;)V", "exportMp4", "", "inputPath", "", "outputPath", "width", "", "height", "bitrate", "fps", "(Ljava/lang/String;Ljava/lang/String;IIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "feature-export_debug"})
public final class ExportEngine {
    @org.jetbrains.annotations.NotNull()
    private final com.editium.core.video.domain.engine.VideoProcessor videoProcessor = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    
    public ExportEngine(@org.jetbrains.annotations.NotNull()
    com.editium.core.video.domain.engine.VideoProcessor videoProcessor, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object exportMp4(@org.jetbrains.annotations.NotNull()
    java.lang.String inputPath, @org.jetbrains.annotations.NotNull()
    java.lang.String outputPath, int width, int height, int bitrate, int fps, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}