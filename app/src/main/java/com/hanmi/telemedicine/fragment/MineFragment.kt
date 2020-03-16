package com.hanmi.telemedicine.fragment

import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.hanmi.telemedicine.common.BaseFragment

class MineFragment : BaseFragment() {
    override fun beforeView() {
        // load binding
    }

    override fun initView(): View? {
        val textView = TextView(mContext).apply {
            text = ""
            textSize = 35f
            gravity = Gravity.CENTER
        }
        return textView
    }

}