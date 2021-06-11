package com.omkar.mybbshopkotlin

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.ContactsContract
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.omkar.mybbshopkotlin.core.BBSuperActivity
import kotlinx.android.synthetic.main.activity_bbsettings.*
import java.util.regex.Pattern
import kotlinx.android.synthetic.main.activity_main.*

class BBSettingsActivity : BBSuperActivity() {

    companion object{
        var AppUrl:String? = null

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bbsettings)
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        edtUrl?.setText(preferences.getString("appUrl", "http://192.168.0.152:4000/"))
        AppUrl = edtUrl?.text.toString()
        tvsave.setOnClickListener { onSaveClick() }

    }

    fun onSaveClick(){
        if(edtUrl?.text.toString() != "" && Patterns.WEB_URL.matcher(edtUrl?.text.toString()).matches())
        {
            val preferences = PreferenceManager.getDefaultSharedPreferences(this)
            preferences.edit().putString("appUrl", edtUrl?.text.toString()).apply()
             AppUrl = edtUrl?.text.toString()

            startActivity(Intent(this,BBLoginActivty::class.java))
        }
    }



}
