package com.example.weatherapp

import android.app.Application
import com.example.rawgapp.common.di.CommonModule
import com.example.weatherapp.weather.di.WeatherModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupTimber()
    }

    private fun setupKoin() {
        stopKoin()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    CommonModule.create(),
                    WeatherModule.create()
                )
            )
        }
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}