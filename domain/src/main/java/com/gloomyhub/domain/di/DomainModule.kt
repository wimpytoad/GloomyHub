package com.gloomyhub.domain.di

import com.gloomyhub.data.client.WebClient
import com.toadfrogsom.gloomyhub.horror_search.HorrorSearchApi
import com.toadfrogsom.gloomyhub.horror_search.HorrorSearchApiImpl
import com.toadfrogsom.gloomyhub.horror_search.HorrorSearchRepo
import com.toadfrogsom.gloomyhub.horror_search.HorrorSearchRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideHorrorSearchApi(webClient: WebClient) : HorrorSearchApi {
        return HorrorSearchApiImpl(webClient)
    }

    @Provides
    @ViewModelScoped
    fun provideHorrorSearchRepo(api: HorrorSearchApi) : HorrorSearchRepo{
       return HorrorSearchRepoImpl(api)
    }
}