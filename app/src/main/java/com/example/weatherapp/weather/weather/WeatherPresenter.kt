package com.example.weatherapp.weather.weather

import com.example.rawgapp.common.mvp.BasePresenter
import com.example.weatherapp.weather.interactor.WeatherInteractor
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.cancellation.CancellationException

class WeatherPresenter(
    private val interactor: WeatherInteractor
) : BasePresenter<WeatherContract.View>(), WeatherContract.Presenter {

    override fun getCityWeather(cityName: String) {
        launch {
            try {
                view?.showLoading(isLoading = true)
                val weather = interactor.getWeather()
                view?.showCityWeather(weather)
            } catch (e: CancellationException) {
                Timber.e(e.message)
            } catch (t: Throwable) {
                Timber.e(t.message)
            } finally {
                view?.showLoading(isLoading = false)
            }
        }
    }
}