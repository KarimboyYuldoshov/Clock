package com.example.clock

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clock.adapter.PageAdapter
import com.example.clock.model.PageModel
import com.example.clock.transformer.ShareTransformer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var list: ArrayList<PageModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
        val adapter = PageAdapter(list!!, supportFragmentManager)
        val transformer = ShareTransformer()
        view_pager.adapter = adapter
        view_pager.setPageTransformer(true, transformer)
        view_pager.offscreenPageLimit=4
    }

    private fun loadData() {
        list = ArrayList()
        list!!.add(
            PageModel(
                Color.rgb(56, 65, 130),
                R.drawable.ic_accessibility_black_24dp,
                "Support and Accessibility"
            )
        )
        list!!.add(
            PageModel(
                Color.rgb(76, 203, 166),
                R.drawable.ic_account_circle_black_24dp,
                "GitHub Account"
            )
        )
        list!!.add(
            PageModel(
                Color.rgb(248, 164, 29),
                R.drawable.ic_archive_black_24dp,
                "Security and Archive Info"
            )
        )
        list!!.add(
            PageModel(
                Color.rgb(248, 251, 50),
                R.drawable.ic_add_location_black_24dp,
                "Multi Locations"
            )
        )
        list!!.add(
            PageModel(
                Color.rgb(143, 135, 210),
                R.drawable.ic_brightness_2_black_24dp,
                "Day and Night Mode"
            )
        )
    }
}
