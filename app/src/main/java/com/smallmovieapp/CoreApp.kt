package com.smallmovieapp

import android.app.Application
import android.content.Context
import com.smallmovieapp.di.appModule
import org.koin.android.ext.android.startKoin

class CoreApp : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        configureDi()
    }

    private fun configureDi() = startKoin(this, appModule)
}