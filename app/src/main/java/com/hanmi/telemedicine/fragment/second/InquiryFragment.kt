package com.hanmi.telemedicine.fragment.second

import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanmi.telemedicine.adapter.InquirysAdapter
import com.hanmi.telemedicine.common.BaseFragment
import com.hanmi.telemedicine.databinding.InquiryLayoutBinding

class InquiryFragment : BaseFragment() {

    lateinit var inquiryBinding: InquiryLayoutBinding

    lateinit var inquirysAdapter: InquirysAdapter

    override fun beforeView() {
        inquiryBinding = InquiryLayoutBinding.inflate(layoutInflater)
    }

    override fun initView(): View? {
//        val textView = TextView(mContext).apply {
//            text = "问诊"
//            textSize = 35f
//            gravity = Gravity.CENTER
//        }
//        return textView
        return inquiryBinding.root
    }

    override fun setWidgets() {
        inquiryBinding.inquiryRecyclerview.layoutManager = LinearLayoutManager(mContext)
        inquirysAdapter = InquirysAdapter()
        inquiryBinding.inquiryRecyclerview.adapter = inquirysAdapter
        inquirysAdapter.setOnItemClickListener { adapter, view, position ->
            Toast.makeText(mContext, "Not open", Toast.LENGTH_SHORT).show()
        }
    }


    override fun initData() {
        val testData1 = TestData(
            "",
            "의사",
            "주치의사",
            "호흡과",
            "전문영역：만성기침,기관지천식,저항폐, 폐심증,폐전증,흉막질환...",
            "303",
            "1213",
            1
        )
        val testData2 = TestData(
            "",
            "주치",
            "주흡사",
            "호흡과",
            "전문영역：만성기침,기관지천식,저항폐, 폐심증,폐전증,흉막질환...",
            "303",
            "1213",
            2
        )
        val testData3 = TestData(
            "",
            "의사",
            "주영사",
            "호흡과",
            "전문영역：만성기침,기관지천식,저항폐, 폐심증,폐전증,흉막질환...",
            "303",
            "1213",
            3
        )
        val testData4 = TestData(
            "",
            "흡과",
            "치의사",
            "지천",
            "전문영역：만성기침,기관지천식,저항폐, 폐심증,폐전증,흉막질환...",
            "303",
            "1213",
            4
        )
        val testData5 =
            TestData("", "문영", "영역", "영역", "전문영역：만성기침,기관지천식,저항폐, 폐심증,폐전증,흉막질환...", "303", "1213", 5)
        val arrayList = ArrayList<TestData>().apply {
            add(testData1)
            add(testData2)
            add(testData3)
            add(testData4)
            add(testData5)
        }

        inquirysAdapter.setNewData(arrayList as List<Any>?)

    }


    companion object {
        @JvmStatic
        fun newInstance() = InquiryFragment()
//        fun newInstance(mFlag: Int? = 0, sizeNum: Int = 0) = HomeNewsFragment(mFlag, sizeNum)
    }
}

data class TestData(
    val pic: String, val name: String, val line2_tv1: String, val line2_tv2: String,
    val desc: String, val likeNum: String, val inquiryNum: String, val id: Int
)