package com.hanmi.telemedicine.activity

import android.app.Activity
import android.content.Intent
import android.view.View
import com.hanmi.telemedicine.common.BaseActivity
import com.hanmi.telemedicine.listener.OnSeekBarChangeListener
import com.hanmi.telemedicine.R
import com.hanmi.telemedicine.databinding.ActivityBloodDetailBinding
import com.jaygoo.widget.RangeSeekBar
import com.qmuiteam.qmui.widget.QMUITopBarLayout

class BloodDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityBloodDetailBinding


    override fun setLayout() {
        binding = ActivityBloodDetailBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_blood_detail)
        setContentView(binding.root)
        //
        //
        val blood_topbar = findViewById<QMUITopBarLayout>(R.id.blood_topbar)
        binding.bloodTopbar.addLeftBackImageButton().apply {
            setImageResource(R.drawable.back_dark)
            setOnClickListener { finish() }
        }
        binding.bloodTopbar.addRightTextButton("完成", View.generateViewId()).apply {
            setOnClickListener {
                val i = Intent()
                i.putExtra("blood_pressure_sys", binding.sys.text.toString())
                i.putExtra("blood_pressure_dia", binding.dia.text.toString())
                setResult(Activity.RESULT_OK, i)
                finish()
            }
        }

        binding.sysSeekBar.setOnRangeChangedListener(object : OnSeekBarChangeListener() {
            override fun onRangeChanged(
                view: RangeSeekBar,
                leftValue: Float,
                rightValue: Float,
                isFromUser: Boolean
            ) {
                binding.sys.text = leftValue.toInt().toString()
            }
        })

        binding.diaSeekBar.setOnRangeChangedListener(object : OnSeekBarChangeListener() {
            override fun onRangeChanged(
                view: RangeSeekBar,
                leftValue: Float,
                rightValue: Float,
                isFromUser: Boolean
            ) {
                binding.dia.text = leftValue.toInt().toString()
            }
        })
    }

}
