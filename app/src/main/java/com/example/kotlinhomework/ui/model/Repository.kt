package com.example.kotlinhomework.ui.model

interface Repository {
fun getWeatherFromServer () : Weather
fun getWeatherFromLocalRussian () : List <Weather>
fun getWeatherFromLocalWorld () : List <Weather>

}