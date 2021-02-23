package com.basscolor.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.basscolor.myapplication.R
import kotlinx.android.synthetic.main.slide_page.view.*

class SlidePageFragment(private val text: String, private val resourceID: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.slide_page, container, false)
        view.page_text.text = text
        view.imageView.setImageResource(resourceID)

        return view
    }


}