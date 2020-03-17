package com.hanmi.telemedicine.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hanmi.telemedicine.fragment.second.InquiryFragment
import com.hanmi.telemedicine.fragment.second.SymptomFragment
import com.hanmi.telemedicine.fragment.second.VideoFragment

class MedicalAdapter : FragmentPagerAdapter {
    private val titles = arrayOf("title1", "title2", "title3")

    private val list = listOf(
        SymptomFragment.newInstance(),
        InquiryFragment.newInstance(),
        VideoFragment.newInstance()
    )

    constructor(fragmentManager: FragmentManager) : super(
        fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

    }


    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }


    override fun getPageTitle(position: Int): CharSequence? {
//        return super.getPageTitle(position)
        return titles[position]
    }


}