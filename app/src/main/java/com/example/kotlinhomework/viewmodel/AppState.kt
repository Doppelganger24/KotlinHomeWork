package com.example.kotlinhomework.viewmodel

import com.example.kotlinhomework.ui.model.Weather


sealed class AppState {
    data class Success(val dataWeather: List<Weather>):AppState()
    data class Error( val error:Throwable):AppState()
    object Loading: AppState()
}
