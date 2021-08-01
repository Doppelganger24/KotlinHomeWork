package com.example.kotlinhomework.viewmodel

import RepositoryImpl
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinhomework.ui.model.Repository
import java.lang.Thread.sleep

class MainViewModel (private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
                     private val repository: Repository = RepositoryImpl()) : ViewModel() {

    fun getData(): LiveData<AppState> {
        getDataFromLocalSource()
        return liveDataToObserve
    }
    fun getWeather()=getDataFromLocalSource()

     private fun getDataFromLocalSource() {
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(repository.getWeatherFromLocal()))
        }.start()
    }

}