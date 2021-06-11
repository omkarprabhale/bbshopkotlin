package com.omkar.mybbshopkotlin

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.omkar.mybbshopkotlin.bbhome.adapter.BBExpertiesNTimeslottsFragment
import com.omkar.mybbshopkotlin.bbhome.adapter.BBProfileNCartFragment
import com.omkar.mybbshopkotlin.bbhome.adapter.BBServiceFragment
import com.omkar.mybbshopkotlin.core.BBSuperActivity
import java.lang.Exception

class BBHomeActivity : BBSuperActivity() {

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_timeslotts -> {
                    getBBtimeslottFragment()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_experts -> {
                    getBBServiceFragment()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    getBBprofileFragment()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_bbhome)
            openDialog();
        }catch (e:Exception)
        {
            Log.e("oncreate_of_timeslotts",e.message)
        }


    }

    fun getBBServiceFragment() {
        try {
            val manager = supportFragmentManager
            manager.beginTransaction().replace(R.id.fragView, BBServiceFragment()).commit()
        }catch (e:Exception)
        {
            Log.e("excepion_service",e.message)
        }

    }

    fun getBBtimeslottFragment() {
        try {
            val manager = supportFragmentManager
            manager.beginTransaction().replace(R.id.fragView, BBExpertiesNTimeslottsFragment()).commit()
        }catch (e:Exception)
        {
            Log.e("excepion_timeslotts",e.message)
        }
    }

    fun getBBprofileFragment() {
    try{
        val manager = supportFragmentManager
        manager.beginTransaction().replace(R.id.fragView, BBProfileNCartFragment()).commit()
    }catch (e:Exception)
    {
        Log.e("excepion_profile",e.message)
    }
    }
    private fun openDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)

         // set the title of the Alert Dialog
                alertDialogBuilder.setTitle("Please")

         // set dialog message
                alertDialogBuilder
        .setMessage("choose proper time slot,when you want service and get appointment with experts")
        .setCancelable(false)
        .setPositiveButton(("OK")
        ) { dialog, id ->
            // what to do if YES is tapped
            dialog.cancel()
            getBBtimeslottFragment()
        }
                 val alertDialog = alertDialogBuilder.create()

        alertDialog.show()
        }
}
