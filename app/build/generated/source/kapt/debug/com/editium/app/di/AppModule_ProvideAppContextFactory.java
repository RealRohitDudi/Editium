package com.editium.app.di;

import android.content.Context;
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
public final class AppModule_ProvideAppContextFactory implements Factory<Context> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideAppContextFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public Context get() {
    return provideAppContext(contextProvider.get());
  }

  public static AppModule_ProvideAppContextFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideAppContextFactory(contextProvider);
  }

  public static Context provideAppContext(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAppContext(context));
  }
}
