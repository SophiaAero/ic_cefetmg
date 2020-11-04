package com.sophiamoraes.agora_vai.qrcode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.sophiamoraes.agora_vai.PowerPlugDataRepository
import com.sophiamoraes.agora_vai.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class QRCodeEntryFragment : Fragment() {
//classe que cria e infla a UI da tela de entrada com o qrcode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_q_r_code_entry, container, false)
        val qrcodeEditText : EditText = view.findViewById(R.id.qrcode)
        val entrybutton : Button = view.findViewById(R.id.entrybutton)
        entrybutton.setOnClickListener {
            val qrcode : String = qrcodeEditText.text.toString()
            if(qrcode.length < 5){
                Toast.makeText(requireContext(),"Código invalido", Toast.LENGTH_SHORT).show()
            }else{
                showCurrentPowerPlugFragment(qrcode)
            }
        }
        return view
    }
    fun showCurrentPowerPlugFragment(qrcode: String){
        val action = QRCodeEntryFragmentDirections.actionQRCodeEntryFragmentToPowerPlugDetailsFragment()
        findNavController().navigate(action)
    }


}