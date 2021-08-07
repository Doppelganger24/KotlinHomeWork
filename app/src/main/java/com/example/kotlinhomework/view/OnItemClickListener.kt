package com.example.kotlinhomework.view

import com.example.kotlinhomework.ui.model.Weather

interface OnItemClickListener {
    fun onItemViewClick (weather: Weather)
}