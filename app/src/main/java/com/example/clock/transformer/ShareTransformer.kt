package com.example.clock.transformer

import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.clock.R

class ShareTransformer : ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val textView = page.findViewById<TextView>(R.id.name)
        textView.text = position.toString()
    }
}