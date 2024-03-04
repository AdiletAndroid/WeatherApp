package com.example.weatherapp.weather.weather

import android.annotation.SuppressLint
import androidx.core.view.isVisible
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

    @SuppressLint("SetTextI18n")
    override fun showCityWeather(data: WeatherModel) {
        with(binding) {
            textViewCity.text =
                data.name?.replaceFirstChar { it.uppercase() }
            textViewTemp.text = tempDescription(data)

            textViewClouds.text =
                data.weather?.get(0)?.description.toString()
            Timber.i("______________${textViewTemp.text}")

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
}