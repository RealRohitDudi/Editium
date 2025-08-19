package com.editium.core.audio.di

import com.editium.core.audio.domain.engine.AudioEngine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AudioModule {
    @Provides
    @Singleton
    fun provideAudioEngine(): AudioEngine = AudioEngine()
}
