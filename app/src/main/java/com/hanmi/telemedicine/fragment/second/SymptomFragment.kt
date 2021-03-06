package com.hanmi.telemedicine.fragment.second

import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.hanmi.telemedicine.common.BaseFragment

class SymptomFragment : BaseFragment() {


    override fun beforeView() {
    }

    override fun initView(): View? {
        val textView = TextView(mContext).apply {
            text = "症状"
            textSize = 35f
            gravity = Gravity.CENTER
        }
        return textView
    }

    companion object {
        @JvmStatic
        fun newInstance() = SymptomFragment()
//        fun newInstance(mFlag: Int? = 0, sizeNum: Int = 0) = HomeNewsFragment(mFlag, sizeNum)
    }
}