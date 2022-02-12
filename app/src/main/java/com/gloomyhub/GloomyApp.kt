package com.gloomyhub

import android.app.Application
import org.koin.android.ext.koin.androidContext
import kotlin.time.ExperimentalTime

@ExperimentalTime
class GloomyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        com.gloomyhub.di.initKoin() {
            androidContext(this@GloomyApp)
        }
    }
}