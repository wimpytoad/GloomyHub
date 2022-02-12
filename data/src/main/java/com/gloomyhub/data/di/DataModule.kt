package com.gloomyhub.data.di

import com.gloomyhub.data.client.WebClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideHttpClient() : WebClient {
        return WebClient()
    }

}