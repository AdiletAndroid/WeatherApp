package com.example.weatherapp.weather.repository

import com.example.weatherapp.weather.api.WeatherApi
import com.example.weatherapp.weather.model.WeatherDataConverter
import com.example.weatherapp.weather.model.WeatherModel

class WeatherRemoteRepository(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeather(): WeatherModel {
        val response = api.getWeather("q")
        return WeatherDataConverter.fromNetwork(response)
    }
}