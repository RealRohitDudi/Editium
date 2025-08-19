package com.editium.core.video.di;

import android.content.Context;
import com.editium.core.video.domain.engine.VideoProcessor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class VideoModule_ProvideVideoProcessorFactory implements Factory<VideoProcessor> {
  private final Provider<Context> contextProvider;

  public VideoModule_ProvideVideoProcessorFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public VideoProcessor get() {
    return provideVideoProcessor(contextProvider.get());
  }

  public static VideoModule_ProvideVideoProcessorFactory create(Provider<Context> contextProvider) {
    return new VideoModule_ProvideVideoProcessorFactory(contextProvider);
  }

  public static VideoProcessor provideVideoProcessor(Context context) {
    return Preconditions.checkNotNullFromProvides(VideoModule.INSTANCE.provideVideoProcessor(context));
  }
}
