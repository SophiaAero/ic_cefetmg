package com.sophiamoraes.agora_vai

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class Power_Specifications_ViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val powerText = view.findViewById<TextView>(R.id.powerplug_value)
    private val descriptionText = view.findViewById<TextView>(R.id.description)
    private val priceText = view.findViewById<TextView>(R.id.pricevalue)
    fun bind(powerSpecificatios: Power_Specificatios){
        powerText.text = powerSpecificatios.powerValue.toString()
        descriptionText.text = powerSpecificatios.description
        priceText.text = powerSpecificatios.priceValue.toString()
    }


}


class Power_Specifications_Adapter() : ListAdapter<Power_Specificatios, Power_Specifications_ViewHolder>(DIFF_CONFIG) {
    companion object{
        val DIFF_CONFIG = object: DiffUtil.ItemCallback<Power_Specificatios>(){
            override fun areItemsTheSame(oldItem: Power_Specificatios, newItem: Power_Specificatios): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Power_Specificatios, newItem: Power_Specificatios): Boolean {
                return oldItem==newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Power_Specifications_ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.power_plug_items, parent, false)
        return Power_Specifications_ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: Power_Specifications_ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}