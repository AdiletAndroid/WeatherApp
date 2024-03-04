package com.example.weatherapp.weather.weather

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.rawgapp.common.mvp.BaseMvpFragment
import com.example.rawgapp.utils.extensions.viewbinding.viewBinding
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.weather.model.WeatherModel
import org.koin.android.ext.android.inject
import timber.log.Timber


class WeatherFragment :
    BaseMvpFragment<WeatherContract.View, WeatherContract.Presenter>(R.layout.fragment_weather),
    WeatherContract.View {

    companion object {
        fun create() = WeatherFragment()
    }

    override val presenter: WeatherContract.Presenter by inject()
    private val binding: FragmentWeatherBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSearch.setOnClickListener {
            val cityName = binding.editTextCity.text.toString()
            presenter.getCityWeather(cityName)
        }
    }

    override fun showCityWeather(data: WeatherModel) {
        with(binding) {
            textViewCity.text = data.name?.replaceFirstChar { it.uppercase() }
            textViewTemp.text = tempDescription(data)
            textViewClouds.text =
                data.weather?.get(0)?.description.toString()
            data.weather?.get(0)?.icon?.let { iconUrl ->
                Glide.with(this@WeatherFragment)
                    .load("https://openweathermap.org/img/wn/$iconUrl.png")
                    .into(imageViewWeather)
            }
            textViewPressure.text = pressureDescription(data)
        }
    }

    override fun showError(message: String) {
        Timber.e("---ERROR -> $message")
    }

    override fun showLoading(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
    }

    private fun tempDescription(data: WeatherModel): String {
        val tempData = data.main?.temp
        val descriptionOfTemp = getString(R.string.celsius)
        return buildString {
            append(tempData)
                .append(descriptionOfTemp)
        }
    }

    private fun pressureDescription(data: WeatherModel): String {
        val pressureData = data.main?.pressure
        val descriptionOfPressure = getString(R.string.pressure_hpa)
        return buildString {
            append(pressureData)
                .append(descriptionOfPressure)
        }
    }
}