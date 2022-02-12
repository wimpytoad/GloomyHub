package com.gloomyhub.di

import com.gloomyhub.data.di.dataModule
import com.gloomyhub.domain.di.domainModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import kotlin.time.ExperimentalTime

@ExperimentalTime
fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin{
    appDeclaration()
    modules(appModule)
    modules(dataModule)
    modules(domainModule)
}