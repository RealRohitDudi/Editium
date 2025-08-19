package com.editium.core.video.domain.media;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/editium/core/video/domain/media/MediaMuxerFacade;", "", "outputPath", "", "format", "", "(Ljava/lang/String;I)V", "audioTrackIndex", "muxer", "Landroid/media/MediaMuxer;", "started", "", "videoTrackIndex", "addAudioTrack", "Landroid/media/MediaFormat;", "addVideoTrack", "release", "", "start", "writeAudioSample", "buffer", "Ljava/nio/ByteBuffer;", "info", "Landroid/media/MediaCodec$BufferInfo;", "writeVideoSample", "core-video_debug"})
public final class MediaMuxerFacade {
    @org.jetbrains.annotations.NotNull()
    private final android.media.MediaMuxer muxer = null;
    private int videoTrackIndex = -1;
    private int audioTrackIndex = -1;
    private boolean started = false;
    
    public MediaMuxerFacade(@org.jetbrains.annotations.NotNull()
    java.lang.String outputPath, int format) {
        super();
    }
    
    public final int addVideoTrack(@org.jetbrains.annotations.NotNull()
    android.media.MediaFormat format) {
        return 0;
    }
    
    public final int addAudioTrack(@org.jetbrains.annotations.NotNull()
    android.media.MediaFormat format) {
        return 0;
    }
    
    public final void start() {
    }
    
    public final void writeVideoSample(@org.jetbrains.annotations.NotNull()
    java.nio.ByteBuffer buffer, @org.jetbrains.annotations.NotNull()
    android.media.MediaCodec.BufferInfo info) {
    }
    
    public final void writeAudioSample(@org.jetbrains.annotations.NotNull()
    java.nio.ByteBuffer buffer, @org.jetbrains.annotations.NotNull()
    android.media.MediaCodec.BufferInfo info) {
    }
    
    public final void release() {
    }
}