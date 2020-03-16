package com.hanmi.telemedicine.activity

import android.app.Activity
import android.content.Intent
import android.view.View
import com.hanmi.telemedicine.common.BaseActivity
import com.hanmi.telemedicine.R
import com.hanmi.telemedicine.databinding.ActivityOxygenSaturationBinding
import com.jaygoo.widget.OnRangeChangedListener
import com.jaygoo.widget.RangeSeekBar

class OxygenSaturationActivity : BaseActivity() {

    private lateinit var binding: ActivityOxygenSaturationBinding

    override fun setLayout() {
        binding = ActivityOxygenSaturationBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_oxygen_saturation)
        setContentView(binding.root)
        //
        binding.oxygenTopbar.addLeftBackImageButton().apply {
            setImageResource(R.drawable.back_dark)
            setOnClickListener { finish() }
        }
        binding.oxygenTopbar.addRightTextButton("完成", View.generateViewId()).apply {
            setOnClickListener {
                val i = Intent()
                i.putExtra("oxygen_saturation", binding.oxygenVal.text.toString())
                setResult(Activity.RESULT_OK, i)
                finish()
            }
        }
        //
        binding.seekBar.setOnRangeChangedListener(object : OnRangeChangedListener {
            override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {
            }

            override fun onRangeChanged(
                view: RangeSeekBar?,
                leftValue: Float,
                rightValue: Float,
                isFromUser: Boolean
            ) {
                binding.oxygenVal.text = String.format("%.1f", leftValue)
            }

            override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {
            }

        })
    }






}
