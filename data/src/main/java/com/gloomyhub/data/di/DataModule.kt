package com.gloomyhub.data.di

import com.gloomyhub.data.client.WebClient
import org.koin.dsl.module
import kotlin.time.ExperimentalTime

@ExperimentalTime
val dataModule = module {
    factory { WebClient() }
}