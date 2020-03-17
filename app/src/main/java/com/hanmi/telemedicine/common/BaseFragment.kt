package com.hanmi.telemedicine.common

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

abstract class BaseFragment : Fragment() {

    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext = this!!.activity!!
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        beforeView()
//        return super.onCreateView(inflater, container, savedInstanceState)
        return initView()

    }

    protected abstract fun beforeView()

    protected abstract fun initView(): View?


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        setWidgets()
        initData()
    }

    protected open fun setWidgets() {


    }

    protected open fun initData() {

    }

}