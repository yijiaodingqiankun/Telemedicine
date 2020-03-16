package com.hanmi.telemedicine.activity

import android.app.Activity
import android.content.Intent
import android.view.View
import com.hanmi.telemedicine.common.BaseActivity
import com.hanmi.telemedicine.R
import com.hanmi.telemedicine.databinding.ActivityTempDetailBinding
import com.jaygoo.widget.OnRangeChangedListener
import com.jaygoo.widget.RangeSeekBar

class TempDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityTempDetailBinding

    override fun setLayout() {
        binding = ActivityTempDetailBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_temp_detail)
        setContentView(binding.root)

        binding.topbar.addLeftBackImageButton().apply {
            setImageResource(R.drawable.back_dark)
            setOnClickListener { finish() }
        }

        binding.topbar.addRightTextButton("完成", View.generateViewId()).apply {
            setOnClickListener {
                val i = Intent()
                i.putExtra("temperature", binding.temperature.text.toString())
                setResult(Activity.RESULT_OK, i)
                finish()
            }

            binding.seekBar.setOnRangeChangedListener(object : OnRangeChangedListener {
                override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {
                }

                override fun onRangeChanged(
                    view: RangeSeekBar?,
                    leftValue: Float,
                    rightValue: Float,
                    isFromUser: Boolean
                ) {
                    binding.temperature.text = String.format("%.1f", leftValue)
                }

                override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {
                }

            })


        }
    }

}
