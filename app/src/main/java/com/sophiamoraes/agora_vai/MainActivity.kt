package com.sophiamoraes.agora_vai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.sophiamoraes.agora_vai.qrcode.QRCodeEntryFragment
import com.sophiamoraes.agora_vai.qrcode.QRCodeEntryFragmentDirections

class MainActivity : AppCompatActivity(){

    private val powerplugRepository = PowerPlugDataRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

//       val navController = findNavController(R.id.nav_host_fragment)


    }




    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}