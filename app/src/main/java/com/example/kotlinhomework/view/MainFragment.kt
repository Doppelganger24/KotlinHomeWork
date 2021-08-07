package com.example.kotlinhomework.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinhomework.R
import com.example.kotlinhomework.databinding.FragmentMainBinding
import com.example.kotlinhomework.ui.model.Weather
import com.example.kotlinhomework.viewmodel.AppState
import com.example.kotlinhomework.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private val mainFragmentAdapter: MainFragmentAdapter =
        MainFragmentAdapter(object : OnItemClickListener {
            override fun onItemViewClick(weather: Weather) {
                val manager = activity?.supportFragmentManager
                if (manager != null) {
                    val bundle = Bundle()
                    bundle.putParcelable(DetailsFragment.KEY_WEATHER, weather)
                    manager.beginTransaction()
                        .replace(R.id.container, DetailsFragment.newInstance(bundle))
                        .addToBackStack(null)
                        .commit()
                }
            }
        })


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() :FragmentMainBinding {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        mainFragmentAdapter.removeListener()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
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

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> TODO() //show errors
            is AppState.Success -> {
                binding.mainFragmentLoadingLayout.visibility = View.GONE
                binding.mainFragmentRecyclerView.adapter = mainFragmentAdapter
                mainFragmentAdapter.setWeather(appState.dataWeather)
            }
            AppState.Loading -> {
                binding.mainFragmentLoadingLayout.visibility = View.VISIBLE
            }
        }
    }


}








