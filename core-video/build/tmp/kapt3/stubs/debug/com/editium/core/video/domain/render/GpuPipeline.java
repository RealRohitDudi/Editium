package com.editium.core.video.domain.render;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/editium/core/video/domain/render/GpuPipeline;", "", "shader", "Lcom/editium/core/video/domain/render/ShaderProgram;", "(Lcom/editium/core/video/domain/render/ShaderProgram;)V", "mvpMatrix", "", "vertexBufferId", "", "vertexData", "drawOesTexture", "", "oesTextureId", "core-video_debug"})
public final class GpuPipeline {
    @org.jetbrains.annotations.NotNull()
    private final com.editium.core.video.domain.render.ShaderProgram shader = null;
    @org.jetbrains.annotations.NotNull()
    private final float[] vertexData = {-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F};
    @org.jetbrains.annotations.NotNull()
    private final float[] mvpMatrix = null;
    private int vertexBufferId = 0;
    
    public GpuPipeline(@org.jetbrains.annotations.NotNull()
    com.editium.core.video.domain.render.ShaderProgram shader) {
        super();
    }
    
    public final void drawOesTexture(int oesTextureId) {
    }
}