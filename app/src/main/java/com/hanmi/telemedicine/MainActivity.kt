package com.hanmi.telemedicine

import LogUtil
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.util.Log
import android.widget.FrameLayout
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hanmi.telemedicine.activity.*
import com.hanmi.telemedicine.common.BaseActivity
import com.hanmi.telemedicine.common.BaseFragment
import com.hanmi.telemedicine.databinding.ActivityMainBinding
import com.hanmi.telemedicine.databinding.Home01LayoutBinding
import com.hanmi.telemedicine.fragment.DeviceFragment
import com.hanmi.telemedicine.fragment.HomeFragment
import com.hanmi.telemedicine.fragment.MedicalFragment
import com.hanmi.telemedicine.fragment.MineFragment
import com.hanmi.telemedicine.viewmodel.HomeViewModel
import com.hmgmkt.ofmom.constant.KeyConstants
import com.jakewharton.rxbinding3.view.clicks
import com.qmuiteam.qmui.util.QMUIStatusBarHelper


class MainActivity : BaseActivity() {

    val TAG = MainActivity::class.java.simpleName

    private lateinit var binding: Home01LayoutBinding
    private lateinit var model: HomeViewModel
    lateinit var mainBinding: ActivityMainBinding

    private var position: Int = 0
    private var fragm: Fragment? = null

//    private lateinit var fl_main: FrameLayout
//    private lateinit var rg_main: RadioGroup

    lateinit var fragments: ArrayList<BaseFragment>
    override fun beforeLayout() {
        super.beforeLayout()
        //        binding = Home01LayoutBinding.inflate(layoutInflater)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setLayout() {


        setContentView(mainBinding.root)

        // test
//        fl_main = findViewById<FrameLayout>(R.id.fl_main)
//        rg_main = findViewById<RadioGroup>(R.id.rg_main)


//        setContentView(R.layout.home01_layout)
//        setContentView(binding.root)
        //
//        model = ViewModelProvider(this).get(HomeViewModel::class.java)
//
//
//        bindClicks()

        addFragment()
        rgListener()
        mainBinding.rgMain.check(R.id.rt_home)
    }

    private fun rgListener() {
        mainBinding.rgMain.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.rt_home -> {
                        position = 0
                    }
                    R.id.rt_medical -> {
                        position = 1
                    }
                    R.id.rt_device -> {
                        position = 2
                    }
                    R.id.rt_mine -> {
                        position = 3
                    }
                }
                //
                var toFragment = getFragment(position)
                switchFragment(fragm, toFragment)
            }
        })
    }

    private fun switchFragment(fromFragment: Fragment?, toFragment: Fragment?) {
        if (fragm != toFragment) {
            fragm = toFragment

            if (toFragment != null) {
                val fragmentManager = supportFragmentManager
                val beginTransaction = fragmentManager.beginTransaction()
                if (!toFragment.isAdded) {
                    if (fromFragment != null) {
                        beginTransaction.hide(fromFragment)
                    }
                    beginTransaction.add(R.id.fl_main, toFragment).commit()
                } else {
                    if (fromFragment != null) {
                        beginTransaction.hide(fromFragment)
                    }
                    beginTransaction.show(toFragment).commit()
                }

            }
        }

    }

    private fun getFragment(position: Int): Fragment? {
        if (::fragments.isInitialized && fragments.size > 0) {
            return fragments.get(position)
        }
        Log.e("MainActivity", "getFragment error...")
        return null
    }

    private fun addFragment() {
        fragments = ArrayList<BaseFragment>()
        fragments.add(HomeFragment())
        fragments.add(MedicalFragment())
        fragments.add(DeviceFragment())
        fragments.add(MineFragment())
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //
        if (resultCode != Activity.RESULT_OK || data == null) return

        LogUtil.e(TAG, "onActivityResult:  requestCode: ${requestCode}   resultCode: ${resultCode}")
        when (requestCode) {
            KeyConstants.TEMPERATURE -> {
                model.temperature = data.getStringExtra("temperature") ?: ""
                binding.home01Table1Center.text = model.temperature
            }
            KeyConstants.BLOOD_PRESSURE -> {
                model.bloodPressureSys = data.getStringExtra("blood_pressure_sys") ?: ""
                model.bloodPressureDia = data.getStringExtra("blood_pressure_dia") ?: ""
                binding.home01Table2Center.text =
                    model.bloodPressureSys + "/" + model.bloodPressureDia
            }
            KeyConstants.BREATH_RATE -> {
                model.breath_rate = data.getStringExtra("breath_rate") ?: ""
                binding.home01Table3Center.text = model.breath_rate
            }
            KeyConstants.OXYGEN_SATURATION -> {
                model.oxygenSaturation = data.getStringExtra("oxygen_saturation") ?: ""
                binding.home01Table4Center.text = model.oxygenSaturation
            }
            KeyConstants.HEART_RATE -> {
                model.heart_rate = data.getStringExtra("heart_rate") ?: ""
                binding.home01Table6Center.text = model.heart_rate
            }

        }
    }


}
