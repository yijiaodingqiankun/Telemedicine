package com.hanmi.telemedicine.utils

import android.content.Context
import com.qmuiteam.qmui.util.QMUIDisplayHelper

object DisplayHelper {


    fun dp2px(context: Context?, dp: Int): Int {
        if (context==null)return dp
        return QMUIDisplayHelper.dp2px(context, dp)
    }

    /**
     * 获取状态栏高度
     */
    fun getStatusBarHeight(context: Context):Float{

        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
       return context.resources.getDimension(resourceId)
    }


}