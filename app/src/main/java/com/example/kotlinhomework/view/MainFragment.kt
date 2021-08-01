package com.example.kotlinhomework.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinhomework.databinding.MainFragmentBinding
import com.example.kotlinhomework.viewmodel.AppState
import com.example.kotlinhomework.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getWeather()

    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> 1;
            is AppState.Success -> {
                binding.loadingLayout.visibility = View.GONE
                Snackbar.make(binding.mainView, "Success", Snackbar.LENGTH_LONG).show()
                setData(appState)
            }
            AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setData(appState: AppState.Success) {
        binding.cityCoordinates.text =
            "${appState.dataWeather.city.lat} ${appState.dataWeather.city.long}"
        binding.cityName.text = appState.dataWeather.city.city
        binding.feelsLikeValue.text = appState.dataWeather.temperature.toString()
        binding.temperatureValue.text = appState.dataWeather.feelsLike.toString()
    }
}





