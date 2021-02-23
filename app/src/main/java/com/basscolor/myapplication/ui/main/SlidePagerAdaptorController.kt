package com.basscolor.myapplication.ui.main

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.basscolor.myapplication.R
import kotlinx.android.synthetic.main.pager_fragment.view.*


class SlidePagerAdaptorController( context: Context, attrs: AttributeSet) : FrameLayout(context,attrs) {


    private var viewListener : ViewListener? = null

    private var view:View? = null

    init {
        val inflater = LayoutInflater.from(context)
        view = inflater.inflate( R.layout.pager_fragment, this)
    }

    fun setViewListener(viewListener: ViewListener) {
        this.viewListener = viewListener
    }

    fun setFragment(fragment : Fragment){
        view?.viewPager?.adapter = SlidePagerAdaptor(fragment)
    }


    inner class SlidePagerAdaptor(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return viewListener?.setViewForPosition(position)!!
        }

    }
}

interface ViewListener {

    fun setViewForPosition(position: Int): Fragment
}