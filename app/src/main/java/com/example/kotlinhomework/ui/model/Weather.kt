package com.example.kotlinhomework.ui.model

import android.graphics.drawable.AdaptiveIconDrawable
import android.media.Image
import com.example.kotlinhomework.R

class Weather(val city: City = getDefaultCity(), val temperature: Int = 22, val feelsLike: Int = 24)

fun getDefaultCity() = City("Новосибирск", 55.0, 83.0/*drawable = R.drawable.sun_lightning*/)

data class City(val city: String, val lat: Double, val long: Double,/* val drawable: Int*/)

