package com.editium.core.video.di

import android.content.Context
import com.editium.core.video.domain.engine.VideoProcessor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VideoModule {
    @Provides
    @Singleton
    fun provideVideoProcessor(@ApplicationContext context: Context): VideoProcessor = VideoProcessor(context)
}
