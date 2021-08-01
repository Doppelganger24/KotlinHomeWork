package com.example.kotlinhomework.ui.model

class Weather(val city: City = getDefaultCity(), val temperature: Int = 22, val feelsLike: Int = 24)

fun getDefaultCity() = City("Новосибирск", 55.0, 83.0)

data class City(val city: String, val lat: Double, val long: Double)

