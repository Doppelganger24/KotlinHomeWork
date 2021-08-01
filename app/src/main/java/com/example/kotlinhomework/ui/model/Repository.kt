package com.example.kotlinhomework.ui.model

interface Repository {
fun getWeatherFromServer () : Weather
fun getWeatherFromLocal () : Weather

}