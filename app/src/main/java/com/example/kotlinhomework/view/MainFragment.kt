package com.example.kotlinhomework.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinhomework.R
import com.example.kotlinhomework.databinding.FragmentMainBinding
import com.example.kotlinhomework.viewmodel.AppState
import com.example.kotlinhomework.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    var isRussian: Boolean = true
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getWeatherFromLocalSourceRussia()
        binding.floatingActionButton.setImageResource(R.drawable.ic_russia)
        binding.floatingActionButton.setOnClickListener {
            clickListener()
        }

    }

    private fun clickListener() {
        if (isRussian) {
            viewModel.getWeatherFromLocalSourceWorld()
            binding.floatingActionButton.setImageResource(R.drawable.ic_earth)
        } else {
            viewModel.getWeatherFromLocalSourceRussia()
            binding.floatingActionButton.setImageResource(R.drawable.ic_russia)
        }
        isRussian != isRussian
    }
}

private fun renderData(appState: AppState) {
    when (appState) {
        is AppState.Error -> TODO() //show errors
        is AppState.Success -> {
            binding.mainFragmentLoadingLayout.visibility = View.GONE
        }
        AppState.Loading -> {
            binding.mainFragmentLoadingLayout.visibility = View.VISIBLE
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
    binding.image.setImageResource(R.drawable.sun_lightning)
}






