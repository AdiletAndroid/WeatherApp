package com.example.weatherapp.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rawgapp.utils.extensions.replaceFragment
import com.example.weatherapp.R
import com.example.weatherapp.weather.weather.WeatherFragment

class RootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)
        replaceFragment(WeatherFragment.create())
    }
}