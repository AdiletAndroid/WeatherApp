package com.example.weatherapp.weather.di

import com.example.rawgapp.common.di.InjectionModule
import com.example.weatherapp.weather.interactor.WeatherInteractor
import com.example.weatherapp.weather.repository.WeatherRemoteRepository
import com.example.weatherapp.weather.repository.WeatherRepository
import com.example.weatherapp.weather.weather.WeatherContract
import com.example.weatherapp.weather.weather.WeatherPresenter
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object WeatherModule : InjectionModule {
    override fun create() = module {
        factoryOf(::WeatherPresenter) bind WeatherContract.Presenter::class
        singleOf(::WeatherRemoteRepository) bind WeatherRepository::class
        factoryOf(::WeatherInteractor)
    }
}