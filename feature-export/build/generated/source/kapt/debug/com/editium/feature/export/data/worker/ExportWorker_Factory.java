package com.editium.feature.export.data.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.editium.feature.export.domain.ExportEngine;
import dagger.internal.DaggerGenerated;
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
public final class ExportWorker_Factory {
  private final Provider<ExportEngine> exportEngineProvider;

  public ExportWorker_Factory(Provider<ExportEngine> exportEngineProvider) {
    this.exportEngineProvider = exportEngineProvider;
  }

  public ExportWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, exportEngineProvider.get());
  }

  public static ExportWorker_Factory create(Provider<ExportEngine> exportEngineProvider) {
    return new ExportWorker_Factory(exportEngineProvider);
  }

  public static ExportWorker newInstance(Context context, WorkerParameters params,
      ExportEngine exportEngine) {
    return new ExportWorker(context, params, exportEngine);
  }
}
