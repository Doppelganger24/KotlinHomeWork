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
       // getDataFromLocalSource()
        return liveDataToObserve
    }
    fun getWeatherFromLocalSourceRussia()=getDataFromLocalSource(true)
    fun getWeatherFromLocalSourceWorld()=getDataFromLocalSource(false)

     private fun getDataFromLocalSource(isRussian : Boolean) {
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(
                if (isRussian) repository.getWeatherFromLocalRussian() else
                    repository.getWeatherFromLocalWorld()))
        }.start()
    }

}