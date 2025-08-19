package com.editium.core.video.domain.engine;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/editium/core/video/domain/engine/EglHelper;", "", "()V", "context", "Landroid/opengl/EGLContext;", "kotlin.jvm.PlatformType", "display", "Landroid/opengl/EGLDisplay;", "surface", "Landroid/opengl/EGLSurface;", "createContext", "", "windowSurface", "Landroid/view/Surface;", "release", "setPresentationTime", "ptsUs", "", "swapBuffers", "core-video_debug"})
final class EglHelper {
    private android.opengl.EGLDisplay display;
    private android.opengl.EGLContext context;
    @org.jetbrains.annotations.Nullable()
    private android.opengl.EGLSurface surface;
    
    public EglHelper() {
        super();
    }
    
    public final void createContext(@org.jetbrains.annotations.NotNull()
    android.view.Surface windowSurface) {
    }
    
    public final void swapBuffers() {
    }
    
    public final void setPresentationTime(long ptsUs) {
    }
    
    public final void release() {
    }
}