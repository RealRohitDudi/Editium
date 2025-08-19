package com.editium.app.ui.views;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/editium/app/ui/views/TimelineView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "playheadPaint", "Landroid/graphics/Paint;", "value", "", "playheadX", "getPlayheadX", "()F", "setPlayheadX", "(F)V", "textPaint", "trackPaint", "zoom", "getZoom", "setZoom", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "app_debug"})
public final class TimelineView extends android.view.View {
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint trackPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint playheadPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint textPaint = null;
    private float zoom = 1.0F;
    private float playheadX = 0.0F;
    
    @kotlin.jvm.JvmOverloads()
    public TimelineView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public final float getZoom() {
        return 0.0F;
    }
    
    public final void setZoom(float value) {
    }
    
    public final float getPlayheadX() {
        return 0.0F;
    }
    
    public final void setPlayheadX(float value) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public TimelineView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
}