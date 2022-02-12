package com.gloomyhub.domain.di

import com.gloomyhub.data.client.WebClient
import com.gloomyhub.domain.horror_search.HorrorSearchApi
import com.gloomyhub.domain.horror_search.HorrorSearchApiImpl
import com.gloomyhub.domain.horror_search.HorrorSearchRepo
import com.gloomyhub.domain.horror_search.HorrorSearchRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlin.time.ExperimentalTime

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @ExperimentalTime
    @Provides
    fun provideHorrorSearchApi(webClient: WebClient) : HorrorSearchApi {
        return HorrorSearchApiImpl(webClient)
    }

    @Provides
    @ViewModelScoped
    fun provideHorrorSearchRepo(api: HorrorSearchApi) : HorrorSearchRepo {
       return HorrorSearchRepoImpl(api)
    }
}