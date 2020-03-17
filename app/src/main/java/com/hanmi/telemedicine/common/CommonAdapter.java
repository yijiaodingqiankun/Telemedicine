package com.hanmi.telemedicine.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    public CommonAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);

    }

    public CommonAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public CommonAdapter(@Nullable List<T> data) {
        super(data);
    }

    public CommonAdapter() {
        super(new ArrayList<>(0));
    }

    public void addHeader(Context context, @LayoutRes int layoutRes) {
        View v = LayoutInflater.from(context).inflate(layoutRes, null);
        addHeaderView(v);
    }

    public void addFooter(Context context, @LayoutRes int layoutRes) {
        View v = LayoutInflater.from(context).inflate(layoutRes, null);
        addFooterView(v);
    }

    public void clearAll() {
        getData().clear();
        notifyDataSetChanged();
    }


}
