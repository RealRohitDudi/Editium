package com.editium.core.data.domain.cache;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u0010J\u0016\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007J\u0016\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\bJ\u0012\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\bJ\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\bH\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/editium/core/data/domain/cache/CacheManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bitmapPool", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "diskDir", "Ljava/io/File;", "getDiskDir", "()Ljava/io/File;", "diskDir$delegate", "Lkotlin/Lazy;", "frameCache", "", "inflight", "Ljava/util/concurrent/ConcurrentHashMap;", "", "memoryClassMb", "getMemoryClassMb", "()I", "memoryClassMb$delegate", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getFrame", "ptsUs", "obtainBitmap", "width", "height", "putFrame", "bmp", "readCompressed", "recycleBitmap", "bitmap", "writeCompressed", "core-data_debug"})
public final class CacheManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy memoryClassMb$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final android.util.LruCache<java.lang.Integer, android.graphics.Bitmap> bitmapPool = null;
    @org.jetbrains.annotations.NotNull()
    private final android.util.LruCache<java.lang.Long, android.graphics.Bitmap> frameCache = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy diskDir$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentHashMap<java.lang.Long, kotlin.Unit> inflight = null;
    
    public CacheManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final int getMemoryClassMb() {
        return 0;
    }
    
    private final java.io.File getDiskDir() {
        return null;
    }
    
    public final void putFrame(long ptsUs, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bmp) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getFrame(long ptsUs) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap obtainBitmap(int width, int height) {
        return null;
    }
    
    public final void recycleBitmap(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
    }
    
    private final void writeCompressed(long ptsUs, android.graphics.Bitmap bmp) {
    }
    
    private final android.graphics.Bitmap readCompressed(long ptsUs) {
        return null;
    }
}