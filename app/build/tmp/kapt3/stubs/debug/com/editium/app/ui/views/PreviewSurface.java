package com.editium.app.ui.views;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001$B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010!\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/editium/app/ui/views/PreviewSurface;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "callback", "Lcom/editium/app/ui/views/PreviewSurface$Callback;", "getCallback", "()Lcom/editium/app/ui/views/PreviewSurface$Callback;", "setCallback", "(Lcom/editium/app/ui/views/PreviewSurface$Callback;)V", "lastX", "", "lastY", "scaleFactor", "tapDetector", "Landroid/view/GestureDetector;", "handlePan", "", "event", "Landroid/view/MotionEvent;", "handlePinch", "onSurfaceTextureAvailable", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "onTouchEvent", "Callback", "app_debug"})
public final class PreviewSurface extends android.view.TextureView implements android.view.TextureView.SurfaceTextureListener {
    @org.jetbrains.annotations.Nullable()
    private com.editium.app.ui.views.PreviewSurface.Callback callback;
    private float lastX = 0.0F;
    private float lastY = 0.0F;
    private float scaleFactor = 1.0F;
    @org.jetbrains.annotations.NotNull()
    private final android.view.GestureDetector tapDetector = null;
    
    @kotlin.jvm.JvmOverloads()
    public PreviewSurface(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.editium.app.ui.views.PreviewSurface.Callback getCallback() {
        return null;
    }
    
    public final void setCallback(@org.jetbrains.annotations.Nullable()
    com.editium.app.ui.views.PreviewSurface.Callback p0) {
    }
    
    @java.lang.Override()
    public void onSurfaceTextureAvailable(@org.jetbrains.annotations.NotNull()
    android.graphics.SurfaceTexture surface, int width, int height) {
    }
    
    @java.lang.Override()
    public void onSurfaceTextureSizeChanged(@org.jetbrains.annotations.NotNull()
    android.graphics.SurfaceTexture surface, int width, int height) {
    }
    
    @java.lang.Override()
    public boolean onSurfaceTextureDestroyed(@org.jetbrains.annotations.NotNull()
    android.graphics.SurfaceTexture surface) {
        return false;
    }
    
    @java.lang.Override()
    public void onSurfaceTextureUpdated(@org.jetbrains.annotations.NotNull()
    android.graphics.SurfaceTexture surface) {
    }
    
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    private final void handlePan(android.view.MotionEvent event) {
    }
    
    private final void handlePinch(android.view.MotionEvent event) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public PreviewSurface(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/editium/app/ui/views/PreviewSurface$Callback;", "", "onDoubleTap", "", "onGesture", "deltaX", "", "deltaY", "scale", "onSurfaceDestroyed", "onSurfaceReady", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "app_debug"})
    public static abstract interface Callback {
        
        public abstract void onSurfaceReady(@org.jetbrains.annotations.NotNull()
        android.graphics.SurfaceTexture surfaceTexture);
        
        public abstract void onSurfaceDestroyed();
        
        public abstract void onGesture(float deltaX, float deltaY, float scale);
        
        public abstract void onDoubleTap();
    }
}