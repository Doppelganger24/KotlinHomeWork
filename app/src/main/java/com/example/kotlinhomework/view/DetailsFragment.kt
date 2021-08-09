package com.example.kotlinhomework.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlinhomework.R
import com.example.kotlinhomework.databinding.FragmentDetailsBinding
import com.example.kotlinhomework.ui.model.Weather
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_details.view.*

class DetailsFragment : Fragment() {

    companion object {
        val KEY_WEATHER : String = "key"
        fun newInstance (bundle: Bundle) : DetailsFragment {
            val fragment = DetailsFragment ()
            fragment.arguments = bundle
            return fragment
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() :FragmentDetailsBinding {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val weather =  arguments?.getParcelable(KEY_WEATHER) as? Weather
        setData(weather!!)
    }

   private fun setData(weather: Weather ) {
       binding.cityCoordinates.text =
           "${weather.city.lat} ${weather.city.long}"
       binding.cityName.text = weather.city.name
       binding.feelsLikeValue.text = weather.temperature.toString()
       binding.temperatureValue.text = weather.feelsLike.toString()
       binding.image.setImageResource(weather.city.drawable)
   }
}