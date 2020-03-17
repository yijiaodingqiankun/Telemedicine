package com.hanmi.telemedicine.fragment

import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.hanmi.telemedicine.common.BaseFragment
import com.hanmi.telemedicine.databinding.Mine04LayoutBinding

class MineFragment : BaseFragment() {
    lateinit var binding: Mine04LayoutBinding
    override fun beforeView() {
        binding = Mine04LayoutBinding.inflate(layoutInflater)
    }

    override fun initView(): View? {
//        val textView = TextView(mContext).apply {
//            text = ""
//            textSize = 35f
//            gravity = Gravity.CENTER
//        }
//        return textView
        return binding.root
    }

}