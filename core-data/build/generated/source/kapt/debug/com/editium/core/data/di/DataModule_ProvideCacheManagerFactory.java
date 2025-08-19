package com.editium.core.data.di;

import android.content.Context;
import com.editium.core.data.domain.cache.CacheManager;
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
public final class DataModule_ProvideCacheManagerFactory implements Factory<CacheManager> {
  private final Provider<Context> contextProvider;

  public DataModule_ProvideCacheManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public CacheManager get() {
    return provideCacheManager(contextProvider.get());
  }

  public static DataModule_ProvideCacheManagerFactory create(Provider<Context> contextProvider) {
    return new DataModule_ProvideCacheManagerFactory(contextProvider);
  }

  public static CacheManager provideCacheManager(Context context) {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideCacheManager(context));
  }
}
