package com.hanmi.telemedicine.common

import android.content.pm.ActivityInfo
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qmuiteam.qmui.util.QMUIStatusBarHelper

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTopUI()
        beforeLayout()
        setLayout()
        initTools()
        initWidgets()
        initData()
    }


    // 重写getResources 方法用于解决app中字体随系统字体大小改变而改变
    override fun getResources(): Resources {
        var res = super.getResources()
        val config = res.configuration
        config.fontScale = 1F
        val defaultFontScaleConfigurationContext = createConfigurationContext(config)
        res = defaultFontScaleConfigurationContext.resources
        return res
    }

    private fun initTopUI() {
        QMUIStatusBarHelper.translucent(this)
        QMUIStatusBarHelper.setStatusBarLightMode(this)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    protected open fun beforeLayout() {

    }

    protected abstract fun setLayout()

    protected open fun initTools() {
    }

    protected open fun initWidgets() {
    }

    protected open fun initData() {
    }

}