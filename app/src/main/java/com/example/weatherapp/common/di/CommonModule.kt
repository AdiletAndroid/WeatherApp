package com.example.rawgapp.common.di

import com.example.weatherapp.weather.api.WeatherApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.openweathermap.org/"

object CommonModule : InjectionModule {

    override fun create() = module {
        single {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(WeatherApi::class.java)
        }
        single {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .build()
        }
    }
}