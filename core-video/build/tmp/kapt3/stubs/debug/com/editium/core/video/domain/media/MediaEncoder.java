package com.editium.core.video.domain.media;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u001bR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/editium/core/video/domain/media/MediaEncoder;", "", "width", "", "height", "bitRate", "frameRate", "iFrameIntervalSec", "(IIIII)V", "codec", "Landroid/media/MediaCodec;", "<set-?>", "Landroid/view/Surface;", "inputSurface", "getInputSurface", "()Landroid/view/Surface;", "dequeueOutput", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "timeoutUs", "", "getOutputBuffer", "Ljava/nio/ByteBuffer;", "index", "getOutputFormat", "Landroid/media/MediaFormat;", "init", "", "mime", "", "release", "releaseOutputBuffer", "signalEndOfInput", "core-video_debug"})
public final class MediaEncoder {
    private final int width = 0;
    private final int height = 0;
    private final int bitRate = 0;
    private final int frameRate = 0;
    private final int iFrameIntervalSec = 0;
    @org.jetbrains.annotations.Nullable()
    private android.media.MediaCodec codec;
    @org.jetbrains.annotations.Nullable()
    private android.view.Surface inputSurface;
    
    public MediaEncoder(int width, int height, int bitRate, int frameRate, int iFrameIntervalSec) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.Surface getInputSurface() {
        return null;
    }
    
    public final void init(@org.jetbrains.annotations.NotNull()
    java.lang.String mime) {
    }
    
    public final int dequeueOutput(@org.jetbrains.annotations.NotNull()
    android.media.MediaCodec.BufferInfo bufferInfo, long timeoutUs) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.media.MediaFormat getOutputFormat() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.nio.ByteBuffer getOutputBuffer(int index) {
        return null;
    }
    
    public final void releaseOutputBuffer(int index) {
    }
    
    public final void signalEndOfInput() {
    }
    
    public final void release() {
    }
}