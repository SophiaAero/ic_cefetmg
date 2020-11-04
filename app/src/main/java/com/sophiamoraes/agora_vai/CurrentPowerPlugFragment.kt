package com.sophiamoraes.agora_vai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_current_power_plug.*
import java.util.*


class PowerPlugDetailsFragment : Fragment() {
    private val powerPlugDataRepository = PowerPlugDataRepository()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_current_power_plug, container, false)
        powerPlugDataRepository.loadPowerPlug()
        val powerspecificationsList : RecyclerView = view.findViewById(R.id.recyclerView)
        powerspecificationsList.layoutManager = LinearLayoutManager(requireContext())
        val powerspecificationsadapter = Power_Specifications_Adapter()
        powerspecificationsList.adapter = powerspecificationsadapter
        val PowerPlugObserver = Observer<List<Power_Specificatios>> { powerItems ->
            powerspecificationsadapter.submitList(powerItems)
        }
        powerPlugDataRepository.plugpower.observe(viewLifecycleOwner ,PowerPlugObserver)
        return view
    }




}


