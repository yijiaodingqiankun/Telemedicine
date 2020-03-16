package com.hanmi.telemedicine.widgets

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.hanmi.telemedicine.utils.DisplayHelper

class ImmersionStatusBarLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr) {


    init {

        orientation= VERTICAL
        val statusBarHeight = DisplayHelper.getStatusBarHeight(context)

        val statusBar = View(context)
        statusBar.id=View.generateViewId()
        statusBar.setBackgroundColor(Color.TRANSPARENT)

        val layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, statusBarHeight.toInt())

        addView(statusBar,layoutParams)


    }


}