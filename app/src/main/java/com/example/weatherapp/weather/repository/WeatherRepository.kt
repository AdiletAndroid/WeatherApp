package com.example.weatherapp.weather.repository

import com.example.weatherapp.weather.model.WeatherModel

interface WeatherRepository {
    suspend fun getWeather(cityName: String): WeatherModel
}