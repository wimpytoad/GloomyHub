package com.gloomyhub.domain.di

import com.gloomyhub.domain.horror_search.HorrorSearchApi
import com.gloomyhub.domain.horror_search.HorrorSearchApiImpl
import com.gloomyhub.domain.horror_search.HorrorSearchRepo
import com.gloomyhub.domain.horror_search.HorrorSearchRepoImpl
import com.gloomyhub.domain.movie_feed.MovieFeedApi
import com.gloomyhub.domain.movie_feed.MovieFeedApiImpl
import com.gloomyhub.domain.movie_feed.MovieFeedRepo
import com.gloomyhub.domain.movie_feed.MovieFeedRepoImpl

import org.koin.dsl.module
import kotlin.time.ExperimentalTime

@ExperimentalTime
val domainModule = module {
    factory<HorrorSearchApi> { HorrorSearchApiImpl(get()) }
    factory<HorrorSearchRepo> { HorrorSearchRepoImpl(get()) }
    factory<MovieFeedApi> { MovieFeedApiImpl(get()) }
    factory<MovieFeedRepo> { MovieFeedRepoImpl(get()) }
}