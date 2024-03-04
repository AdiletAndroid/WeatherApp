package com.example.weatherapp.weather.weather

import com.example.rawgapp.common.mvp.MvpPresenter
import com.example.rawgapp.common.mvp.MvpView
import com.example.weatherapp.weather.model.WeatherModel

interface WeatherContract {

    interface View : MvpView {
        fun showCityWeather (data: WeatherModel)
        fun showError (message: String)
        fun showLoading(isLoading:Boolean)
    }

    interface Presenter : MvpPresenter<View> {
        fun getCityWeather(cityName:String)
    }
}