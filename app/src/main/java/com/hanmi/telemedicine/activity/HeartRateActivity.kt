package com.hanmi.telemedicine.activity

import android.app.Activity
import android.content.Intent
import android.view.View
import com.hanmi.telemedicine.common.BaseActivity
import com.hanmi.telemedicine.R
import com.hanmi.telemedicine.databinding.ActivityHeartRateBinding
import com.lsp.RulerView

class HeartRateActivity : BaseActivity() {

    private lateinit var binding: ActivityHeartRateBinding

    override fun setLayout() {
        binding = ActivityHeartRateBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_heart_rate)
        setContentView(binding.root)


        //
        binding.heartTopbar.addLeftBackImageButton().apply {
            setImageResource(R.drawable.back_dark)
            setOnClickListener {
                finish()
            }
        }
        //
        binding.heartTopbar.addRightTextButton("完成", View.generateViewId()).apply {
            setOnClickListener {
                val i = Intent()
                i.putExtra("heart_rate", binding.heartRate.text.toString())
                setResult(Activity.RESULT_OK, i)
                finish()
            }
        }

        binding.rulerView.setOnChooseResulterListener(object : RulerView.OnChooseResulterListener {
            override fun onScrollResult(result: String?) {
                val value = result?.toFloatOrNull() ?: 0F
                binding.heartRate.text = value.toInt().toString()
            }

            override fun onEndResult(result: String?) {
            }

        })
    }


}
