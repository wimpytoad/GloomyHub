package com.gloomyhub.di

import com.gloomyhub.vms.CuratedBooksViewModel
import com.gloomyhub.vms.CuratedMoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { CuratedBooksViewModel(get())}
    viewModel { CuratedMoviesViewModel(get())}
}