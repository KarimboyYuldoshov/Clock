package com.example.clock.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clock.R
import com.example.clock.model.PageModel
import kotlinx.android.synthetic.main.ui_layout.view.*

class ExamFragment(var item: PageModel) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.ui_layout, container, false)
        view.layout.setBackgroundColor(item.color)
        if (item.text=="Day and Night Mode"){
            view.icon_view.rotation=30f
        }
        view.icon_view.setImageResource(item.icon)
        view.name.text = item.text
        return view
    }
}