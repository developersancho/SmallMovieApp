package com.smallmovieapp.di

import com.smallmovieapp.data.remote.RemoteDataManager
import com.smallmovieapp.data.repository.DataManager
import org.koin.dsl.module.module

val managerModule = module {
    single { RemoteDataManager(get()) }
    single { DataManager(get()) }
}