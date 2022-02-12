package com.gloomyhub.di

import com.gloomyhub.vms.CuratedSectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { CuratedSectionViewModel(get())}
}