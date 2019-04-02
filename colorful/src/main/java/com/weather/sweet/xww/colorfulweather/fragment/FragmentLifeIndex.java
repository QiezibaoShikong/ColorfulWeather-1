package com.weather.sweet.xww.colorfulweather.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.sweet.xww.colorfulweather.R;
import com.weather.sweet.xww.colorfulweather.base.BaseFragment;

import butterknife.BindView;

/**
 * 功能：app主界面：碎片二
 * 显示生活指数等信息
 *
 * @author : xww
 * @created at : 2019/3/25
 * @time : 20:23
 */
public class FragmentLifeIndex extends BaseFragment {

    @BindView(R.id.linear_content)
    LinearLayoutCompat linearContent;
    @BindView(R.id.tv_today_index_title)
    AppCompatTextView tvTodayIndexTitle;

    @Override
    protected View setContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lifeindex, container, false);
    }

    @Override
    protected void setupView() {
        linearContent.addView(getOccupyStatusbarView(), 0);
        tvTodayIndexTitle.setTypeface(mTypeface);
    }

    @Override
    protected void setupData(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}
