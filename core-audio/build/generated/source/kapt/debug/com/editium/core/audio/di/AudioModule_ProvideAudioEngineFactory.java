package com.editium.core.audio.di;

import com.editium.core.audio.domain.engine.AudioEngine;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class AudioModule_ProvideAudioEngineFactory implements Factory<AudioEngine> {
  @Override
  public AudioEngine get() {
    return provideAudioEngine();
  }

  public static AudioModule_ProvideAudioEngineFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AudioEngine provideAudioEngine() {
    return Preconditions.checkNotNullFromProvides(AudioModule.INSTANCE.provideAudioEngine());
  }

  private static final class InstanceHolder {
    private static final AudioModule_ProvideAudioEngineFactory INSTANCE = new AudioModule_ProvideAudioEngineFactory();
  }
}
