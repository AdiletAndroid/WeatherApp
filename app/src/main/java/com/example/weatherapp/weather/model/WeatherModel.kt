package com.example.weatherapp.weather.model

import android.os.Parcelable
import com.example.weatherapp.weather.api.model.Clouds
import com.example.weatherapp.weather.api.model.Coord
import com.example.weatherapp.weather.api.model.Main
import com.example.weatherapp.weather.api.model.Sys
import com.example.weatherapp.weather.api.model.Weather
import com.example.weatherapp.weather.api.model.Wind
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class WeatherModel(
    val coord: @RawValue Coord?,
    val weather: @RawValue List<Weather>?,
    val base: String?,
    val main: @RawValue Main?,
    val visibility: Int?,
    val wind: @RawValue Wind?,
    val clouds: @RawValue Clouds?,
    val dt: Int?,
    val sys: @RawValue Sys,
    val timezone: Int?,
    val id: Int?,
    val name: String?,
    val cod: Int?
) : Parcelable