package com.editium.core.video.domain.cache;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/editium/core/video/domain/cache/VideoCache;", "", "()V", "frameCache", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "clear", "", "getFrame", "ptsUs", "putFrame", "bitmap", "core-video_debug"})
public final class VideoCache {
    @org.jetbrains.annotations.NotNull()
    private final android.util.LruCache<java.lang.Long, android.graphics.Bitmap> frameCache = null;
    
    public VideoCache() {
        super();
    }
    
    public final void putFrame(long ptsUs, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getFrame(long ptsUs) {
        return null;
    }
    
    public final void clear() {
    }
}