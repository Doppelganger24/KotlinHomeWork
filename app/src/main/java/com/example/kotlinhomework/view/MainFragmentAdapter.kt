package com.example.kotlinhomework.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinhomework.R
import com.example.kotlinhomework.ui.model.Weather

class MainFragmentAdapter constructor (var onItemClickListener: OnItemClickListener?)  : RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {

    fun setWeather (list: List <Weather>) {
        weatherData = list
        notifyDataSetChanged()
    }

    private var weatherData: List<Weather> = listOf()

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun init(weather: Weather) {
            itemView.findViewById<TextView>(R.id.mainFragmentRecyclerItemTextView).text =
                weather.city.name
            itemView.setOnClickListener {onItemClickListener?.onItemViewClick(weather)}
        }
    }

    fun removeListener(){
        onItemClickListener = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_main_recycler_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.init(weatherData[position])
    }

    override fun getItemCount(): Int {
        return weatherData.size
    }
}