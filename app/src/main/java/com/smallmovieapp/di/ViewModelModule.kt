package com.smallmovieapp.di

import com.smallmovieapp.ui.detail.DetailViewModel
import com.smallmovieapp.ui.main.MainViewModel
import com.smallmovieapp.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}