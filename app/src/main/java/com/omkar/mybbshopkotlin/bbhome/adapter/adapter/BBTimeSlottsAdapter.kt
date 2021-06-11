package com.omkar.mybbshopkotlin.bbhome.adapter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.omkar.mybbshopkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class BBTimeSlottsAdapter(slotts:MutableList<String >, context: Context?): RecyclerView.Adapter<BBTimeSlottsAdapter.ViewHolder>() {


    private var slotts:MutableList<String> = slotts
    private var context: Context? = context
    private var inflater :LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.slotadapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return slotts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleText.text =slotts[position]
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

         var titleText: TextView =itemView.findViewById(R.id.slotTv)

    }


}