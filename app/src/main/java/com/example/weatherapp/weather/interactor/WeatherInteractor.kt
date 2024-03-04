package com.example.weatherapp.weather.interactor

import com.example.weatherapp.weather.model.WeatherModel
import com.example.weatherapp.weather.repository.WeatherRepository

class WeatherInteractor(
    private val repo: WeatherRepository
) {
    suspend fun getWeather(): WeatherModel {
        return repo.getWeather()
    }
}