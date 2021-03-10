package com.example.clock.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.clock.fragment.ExamFragment
import com.example.clock.model.PageModel

class PageAdapter(var list: ArrayList<PageModel>, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return ExamFragment(list[position])
    }

    override fun getCount(): Int {
        return list.size
    }
}