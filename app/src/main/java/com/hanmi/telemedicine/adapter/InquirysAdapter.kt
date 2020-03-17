package com.hanmi.telemedicine.adapter

import android.text.TextUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseViewHolder
import com.hanmi.telemedicine.R
import com.hanmi.telemedicine.common.CommonAdapter
import com.hanmi.telemedicine.fragment.second.TestData

class InquirysAdapter : CommonAdapter<Any>(R.layout.adapter_inquirys_item) {


    override fun convert(helper: BaseViewHolder, item: Any?) {
        if (item is TestData) {
            val avatar = helper.getView<ImageView>(R.id.inquirys_item_avatar)
            val name = helper.getView<TextView>(R.id.inquirys_item_name)
            val line2Tv1 = helper.getView<TextView>(R.id.inquirys_item_line2_tv1)
            val line2Tv2 = helper.getView<TextView>(R.id.inquirys_item_line2_tv2)
            val desc = helper.getView<TextView>(R.id.inquirys_item_desc_tv)
            val likeNum = helper.getView<TextView>(R.id.inquirys_item_like_num)
            val inquiryNum = helper.getView<TextView>(R.id.inquirys_item_inquiryNum)
            val btn = helper.getView<Button>(R.id.inquirys_item_btn)
            //


        }
    }

}