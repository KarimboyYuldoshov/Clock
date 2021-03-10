package com.example.clock.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clock.R
import com.example.clock.Utils.TimeFormat
import kotlinx.android.synthetic.main.item_list.view.*

class LapAdapter(var list: ArrayList<Int>) : RecyclerView.Adapter<LapAdapter.Holder>() {

    var format = TimeFormat()
    var a=0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        var holder = Holder(view = view)
        return holder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(list[position], position)
    }

    inner class Holder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(item: Int, position: Int) {
            view.number.text = format.numberFormatString(position+1)
            view.stopwatch_value.text = format.formatString(item)
            view.unit_value.text = format.formatString(item - a)
            a=item
        }
    }
}