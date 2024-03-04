package com.example.weatherapp.weather.api

import com.example.weatherapp.weather.api.model.CityWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather?appid=61d4217a1cf164674df0b8e4dfd8f078&units=metric")
    suspend fun getWeather(
        @Query("q") cityName: String
    ): CityWeather
}