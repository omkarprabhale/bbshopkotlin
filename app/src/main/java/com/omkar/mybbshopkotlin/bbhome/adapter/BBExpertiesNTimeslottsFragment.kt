package com.omkar.mybbshopkotlin.bbhome.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.omkar.mybbshopkotlin.R
import com.omkar.mybbshopkotlin.bbhome.adapter.adapter.BBTimeSlottsAdapter
import kotlinx.android.synthetic.main.bbtimeslottsfragment.*
import java.lang.Exception
import kotlinx.android.synthetic.main.activity_main.*

class BBExpertiesNTimeslottsFragment: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        try {
            val view = inflater.inflate(R.layout.bbtimeslottsfragment, container, false)

            var listSlotts = mutableListOf<String>()
            listSlotts.add("Morning")
            listSlotts.add("Afternoon")
            listSlotts.add("Evening")
            listSlotts.add("Night")
            val layoutManager = LinearLayoutManager(activity)
            val rcvTimeslott :RecyclerView = view.findViewById(R.id.rcvTimeslott)
            rcvTimeslott.layoutManager = layoutManager
            rcvTimeslott.adapter = BBTimeSlottsAdapter(listSlotts, context)

            rcvTimeslott.addItemDecoration(DividerItemDecoration(activity!!, layoutManager.orientation))
            return view
        } catch (e: Exception) {
            Log.e("Exception_in_timeslots", e.message)
        }


     return inflater.inflate(R.layout.bbtimeslottsfragment, container, false)
    }
}

