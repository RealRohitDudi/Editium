package com.editium.core.audio.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/editium/core/audio/di/AudioModule;", "", "()V", "provideAudioEngine", "Lcom/editium/core/audio/domain/engine/AudioEngine;", "core-audio_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AudioModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.editium.core.audio.di.AudioModule INSTANCE = null;
    
    private AudioModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.editium.core.audio.domain.engine.AudioEngine provideAudioEngine() {
        return null;
    }
}