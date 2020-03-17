package com.hanmi.telemedicine.fragment

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.updateLayoutParams
import com.hanmi.telemedicine.adapter.MedicalAdapter
import com.hanmi.telemedicine.common.BaseFragment
import com.hanmi.telemedicine.databinding.Medical02LayoutBinding
import com.hanmi.telemedicine.utils.DisplayHelper

class MedicalFragment : BaseFragment() {

    lateinit var medicalBinding: Medical02LayoutBinding

    override fun beforeView() {
        // load binding
        medicalBinding = Medical02LayoutBinding.inflate(layoutInflater)
    }

    override fun initView(): View? {
//        val textView = TextView(mContext).apply {
//            text = ""
//            textSize = 35f
//            gravity = Gravity.CENTER
//        }
//        return textView
        return medicalBinding.root
    }

    //    supportFragmentManager
    override fun setWidgets() {
        val supportFragmentManager = activity?.supportFragmentManager
        if (supportFragmentManager != null) {
            val medicalAdapter = MedicalAdapter(supportFragmentManager)
            medicalBinding.medicalViewpager.adapter = medicalAdapter
            medicalBinding.medicalTabLayout.setupWithViewPager(medicalBinding.medicalViewpager)
            setMarginOfTabItem()
        }
    }

    /**
     * 设置TabLayout 的Tab之间的间距，要在TabLayout添加完Tab调用
     */
    private fun setMarginOfTabItem() {
        val tabSpace = DisplayHelper.dp2px(mContext, 15)
        val tabs = medicalBinding.medicalTabLayout.getChildAt(0) as ViewGroup
        for (i in 0 until medicalBinding.medicalTabLayout.tabCount - 1) {
            val tab = tabs.getChildAt(i)
            tab.updateLayoutParams<LinearLayout.LayoutParams> {
                rightMargin = tabSpace
            }
        }
    }

}