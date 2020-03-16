package com.hanmi.telemedicine.activity

import android.app.Activity
import android.content.Intent
import android.view.View
import com.hanmi.telemedicine.common.BaseActivity
import com.hanmi.telemedicine.R
import com.hanmi.telemedicine.databinding.ActivityBreathRateBinding
import com.lsp.RulerView

class BreathRateActivity : BaseActivity() {


    private lateinit var binding: ActivityBreathRateBinding


    override fun setLayout() {
        binding = ActivityBreathRateBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_breath_rate)
        setContentView(binding.root)

        //
        binding.breathTopbar.addLeftBackImageButton().apply {
            setImageResource(R.drawable.back_dark)
            setOnClickListener {
                finish()
            }
        }

        binding.breathTopbar.addRightTextButton("完成", View.generateViewId()).apply {
            setOnClickListener {
                val i = Intent()
                i.putExtra("breath_rate", binding.heartRate.text.toString())
                setResult(Activity.RESULT_OK, i)
                finish()
            }
        }
        //

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



