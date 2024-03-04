package com.example.weatherapp.weather.model

import com.example.weatherapp.weather.api.model.CityWeather

object WeatherDataConverter {

    fun fromNetwork(response: CityWeather): WeatherModel {
        return WeatherModel(
            coord = response.coord,
            weather = response.weather,
            base = response.base,
            main = response.main,
            visibility = response.visibility,
            wind = response.wind,
            clouds = response.clouds,
            dt = response.dt,
            sys = response.sys!!,
            timezone = response.timezone,
            id = response.id,
            name = response.name,
            cod = response.cod
        )
    }
}








