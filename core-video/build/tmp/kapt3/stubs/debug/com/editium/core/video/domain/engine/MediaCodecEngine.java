package com.editium.core.video.domain.engine;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J>\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/editium/core/video/domain/engine/MediaCodecEngine;", "", "assets", "Landroid/content/res/AssetManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/content/res/AssetManager;Lkotlinx/coroutines/CoroutineScope;)V", "decoder", "Lcom/editium/core/video/domain/media/MediaDecoder;", "effectRenderer", "Lcom/editium/core/video/domain/render/EffectRenderer;", "encoder", "Lcom/editium/core/video/domain/media/MediaEncoder;", "encoderInputSurface", "Landroid/view/Surface;", "muxer", "Lcom/editium/core/video/domain/media/MediaMuxerFacade;", "renderThread", "Lkotlinx/coroutines/Job;", "release", "", "transcode", "inputPath", "", "outputPath", "width", "", "height", "bitrate", "fps", "(Ljava/lang/String;Ljava/lang/String;IIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core-video_debug"})
public final class MediaCodecEngine {
    @org.jetbrains.annotations.NotNull()
    private final android.content.res.AssetManager assets = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.Nullable()
    private com.editium.core.video.domain.media.MediaDecoder decoder;
    @org.jetbrains.annotations.Nullable()
    private com.editium.core.video.domain.media.MediaEncoder encoder;
    @org.jetbrains.annotations.Nullable()
    private com.editium.core.video.domain.media.MediaMuxerFacade muxer;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job renderThread;
    @org.jetbrains.annotations.Nullable()
    private com.editium.core.video.domain.render.EffectRenderer effectRenderer;
    @org.jetbrains.annotations.Nullable()
    private android.view.Surface encoderInputSurface;
    
    public MediaCodecEngine(@org.jetbrains.annotations.NotNull()
    android.content.res.AssetManager assets, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object transcode(@org.jetbrains.annotations.NotNull()
    java.lang.String inputPath, @org.jetbrains.annotations.NotNull()
    java.lang.String outputPath, int width, int height, int bitrate, int fps, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void release() {
    }
}