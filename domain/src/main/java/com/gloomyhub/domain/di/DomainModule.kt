package com.gloomyhub.domain.di

import com.gloomyhub.domain.horror_search.HorrorSearchApi
import com.gloomyhub.domain.horror_search.HorrorSearchApiImpl
import com.gloomyhub.domain.horror_search.HorrorSearchRepo
import com.gloomyhub.domain.horror_search.HorrorSearchRepoImpl

import org.koin.dsl.module
import kotlin.time.ExperimentalTime

@ExperimentalTime
val domainModule = module {
    factory<HorrorSearchApi> { HorrorSearchApiImpl(get()) }
    factory<HorrorSearchRepo> { HorrorSearchRepoImpl(get()) }
}