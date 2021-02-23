package com.basscolor.myapplication.ui.main

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.basscolor.myapplication.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.pager_fragment.view.*


class SlidePagerAdaptorController(context: Context, attrs: AttributeSet) :
    FrameLayout(context, attrs) {

    fun setAdaptor(adapter: SlidePagerAdaptor) {
        val page = LayoutInflater.from(context).inflate(R.layout.pager_fragment, this)
        page.viewPager.adapter = adapter
        settingIndicator()
    }

    private fun settingIndicator() {
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        TabLayoutMediator(indicator, viewPager) { _, _ -> }.attach()
    }

}

class SlidePagerAdaptor(fragment: Fragment, private val listener: ViewListener) :
    FragmentStateAdapter(fragment) {

    var count = 1

    override fun getItemCount(): Int {
        return count
    }

    override fun createFragment(position: Int): Fragment {
        return listener.setViewForPosition(position)
    }

}

interface ViewListener {

    fun setViewForPosition(position: Int): Fragment
}