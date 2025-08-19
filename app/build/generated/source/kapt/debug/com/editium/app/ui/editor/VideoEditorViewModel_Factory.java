package com.editium.app.ui.editor;

import com.editium.core.video.domain.engine.VideoProcessor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class VideoEditorViewModel_Factory implements Factory<VideoEditorViewModel> {
  private final Provider<VideoProcessor> videoProcessorProvider;

  public VideoEditorViewModel_Factory(Provider<VideoProcessor> videoProcessorProvider) {
    this.videoProcessorProvider = videoProcessorProvider;
  }

  @Override
  public VideoEditorViewModel get() {
    return newInstance(videoProcessorProvider.get());
  }

  public static VideoEditorViewModel_Factory create(
      Provider<VideoProcessor> videoProcessorProvider) {
    return new VideoEditorViewModel_Factory(videoProcessorProvider);
  }

  public static VideoEditorViewModel newInstance(VideoProcessor videoProcessor) {
    return new VideoEditorViewModel(videoProcessor);
  }
}
