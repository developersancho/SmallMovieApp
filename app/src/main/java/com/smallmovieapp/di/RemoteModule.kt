package com.smallmovieapp.di

import com.smallmovieapp.data.remote.service.IMovieService
import com.smallmovieapp.data.remote.service.ServiceClient.createWebService
import org.koin.dsl.module.module

val remoteModule = module {
    factory { createWebService<IMovieService>() }
}