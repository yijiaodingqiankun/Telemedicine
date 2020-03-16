package com.hanmi.telemedicine.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.hanmi.telemedicine.activity.*
import com.hanmi.telemedicine.common.BaseFragment
import com.hanmi.telemedicine.databinding.Home01LayoutBinding
import com.hanmi.telemedicine.viewmodel.HomeViewModel
import com.hmgmkt.ofmom.constant.KeyConstants
import com.jakewharton.rxbinding3.view.clicks

class HomeFragment : BaseFragment() {

    lateinit var homeBinding: Home01LayoutBinding
    private lateinit var model: HomeViewModel


    override fun beforeView() {
        // load binding
        homeBinding = Home01LayoutBinding.inflate(layoutInflater)
    }

    override fun initView(): View? {
//        val textView = TextView(mContext).apply {
//            text = "HomeFragment"
//            textSize = 35f
//            gravity = Gravity.CENTER
//        }
//        return textView
        return homeBinding.root
    }

    override fun setWidgets() {
        super.setWidgets()
        //
        model = ViewModelProvider(this).get(HomeViewModel::class.java)
        bindClicks()

    }


    override fun initData() {
        super.initData()

    }


    @SuppressLint("CheckResult")
    private fun bindClicks() {
        //1
        homeBinding.home01Table1Cl.clicks().subscribe {
            startActivityForResult(
                Intent(mContext, TempDetailActivity::class.java), KeyConstants.TEMPERATURE
            )
        }
        //2
        homeBinding.home01Table2Cl.clicks().subscribe {
            startActivityForResult(
                Intent(mContext, BloodDetailActivity::class.java), KeyConstants.BLOOD_PRESSURE
            )
        }
        //3 呼吸
        homeBinding.home01Table3Cl.clicks().subscribe {
            startActivityForResult(
                Intent(mContext, BreathRateActivity::class.java), KeyConstants.BREATH_RATE
            )
        }
        //4
        homeBinding.home01Table4Cl.clicks().subscribe {
            startActivityForResult(
                Intent(mContext, OxygenSaturationActivity::class.java),
                KeyConstants.OXYGEN_SATURATION
            )
        }
        //5 水
        homeBinding.home01Table5Cl.clicks().subscribe {
            Toast.makeText(mContext, "Not open", Toast.LENGTH_SHORT).show()
        }
        //6 心率
        homeBinding.home01Table6Cl.clicks().subscribe {
            startActivityForResult(
                Intent(mContext, HeartRateActivity::class.java), KeyConstants.HEART_RATE
            )
        }
        //7 体重
        homeBinding.home01Table7Cl.clicks().subscribe {
            Toast.makeText(mContext, "Not open", Toast.LENGTH_SHORT).show()
        }
        //8 睡眠
        homeBinding.home01Table8Cl.clicks().subscribe {
            Toast.makeText(mContext, "Not open", Toast.LENGTH_SHORT).show()
        }
    }

}