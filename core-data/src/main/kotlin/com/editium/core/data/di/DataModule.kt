package com.editium.core.data.di

import android.content.Context
import com.editium.core.data.domain.cache.CacheManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideCacheManager(@ApplicationContext context: Context): CacheManager = CacheManager(context)
}
