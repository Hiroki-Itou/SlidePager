package com.basscolor.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.basscolor.myapplication.R
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private val indexItems = listOf(
        R.drawable.call_icon,
        R.drawable.hang_up,
        R.drawable.original_usericon
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val listener = (object : ViewListener {
            override fun setViewForPosition(position: Int): Fragment {
                return SlidePageFragment("ページ$position", indexItems[position])
            }
        })
        val slidePagerAdaptor = SlidePagerAdaptor(this, listener)
        slidePagerAdaptor.count = 3
        adaptor_controller.setAdaptor(slidePagerAdaptor)


    }

}
