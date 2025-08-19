package com.editium.core.video.domain.render;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/editium/core/video/domain/render/EffectRenderer;", "", "assets", "Landroid/content/res/AssetManager;", "(Landroid/content/res/AssetManager;)V", "currentHeight", "", "currentWidth", "fragSrc", "", "pipeline", "Lcom/editium/core/video/domain/render/GpuPipeline;", "program", "Lcom/editium/core/video/domain/render/ShaderProgram;", "vertexSrc", "renderExternalTexture", "", "oesTexId", "setViewport", "width", "height", "core-video_debug"})
public final class EffectRenderer {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String vertexSrc = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String fragSrc = null;
    @org.jetbrains.annotations.NotNull()
    private final com.editium.core.video.domain.render.ShaderProgram program = null;
    @org.jetbrains.annotations.NotNull()
    private final com.editium.core.video.domain.render.GpuPipeline pipeline = null;
    private int currentWidth = 1;
    private int currentHeight = 1;
    
    public EffectRenderer(@org.jetbrains.annotations.NotNull()
    android.content.res.AssetManager assets) {
        super();
    }
    
    public final void renderExternalTexture(int oesTexId) {
    }
    
    public final void setViewport(int width, int height) {
    }
}