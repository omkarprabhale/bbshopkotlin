package com.omkar.mybbshopkotlin.core

import android.annotation.SuppressLint
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.omkar.mybbshopkotlin.bbnetwork.BBNetworkReceiver
import com.omkar.mybbshopkotlin.bbnetwork.BBNetworkstate

@SuppressLint("Registered")
open class BBSuperActivity :AppCompatActivity()
{
    @Override
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    @Override
    override fun onResume() {

        super.onResume()
        val filter = IntentFilter()
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(BBNetworkReceiver(), filter)
        if (BBNetworkstate.getConnectivityStatus(applicationContext) === 0) {
            Toast.makeText(
                applicationContext,
                BBNetworkstate.getConnectivityStatusString(applicationContext),
                Toast.LENGTH_LONG
            ).show()

        }

    }



}