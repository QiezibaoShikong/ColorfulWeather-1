package com.weather.sweet.xww.colorfulweather.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.sweet.xww.applibaray.utils.statusbar.StatusBarUtil;
import com.weather.sweet.xww.colorfulweather.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 功能：app主界面：碎片一
 * 显示现在的天气情况
 *
 * @author : xww
 * @created at : 19-3-25
 * @time : 下午08:12
 */
public class FragmentNowWeather extends Fragment {

    private Context mContext;
    private Unbinder unbinder;
    @BindView(R.id.imgv_drawer_menu_icon)
    AppCompatImageView ivDrawerMenu;
    @BindView(R.id.linear_header)
    LinearLayoutCompat linearLayoutHeader;
    @BindView(R.id.tv_now_weather)
    AppCompatTextView tvNowWeather;
    @BindView(R.id.tv_now_temperature)
    AppCompatTextView tvNowTemperature;

    @BindView(R.id.tv_location)
    AppCompatTextView tvLocation;
    @BindView(R.id.tv_card_now)
    AppCompatTextView tvCardNow;
    @BindView(R.id.tv_card_forecast)
    AppCompatTextView tvCardForecast;


    // 侧拉按钮监听
    private OnDrawerMenuToggleListener onDrawerMenuToggleListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_now_weather, container, false);
        unbinder = ButterKnife.bind(this, view);
        mContext = getContext();
        initView();
        return view;
    }

    private void initView() {
        final int statusBarHeight = StatusBarUtil.getStatusBarHeight(mContext);
        //添加一个 view 填充到状态栏中，用于偏移
        final View view = new View(mContext);
        final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(1, statusBarHeight);
        view.setLayoutParams(layoutParams);
        //添加到最顶部
        linearLayoutHeader.addView(view, 0);
        /**
         * drawer 监听事件，回调给 activity
         */
        ivDrawerMenu.setOnClickListener(v -> {
            if (onDrawerMenuToggleListener != null) {
                onDrawerMenuToggleListener.onClick(v);
            }
        });

        initTypeface();
    }

    private void initTypeface() {
        final Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "maobixingshu.ttf");
        tvNowWeather.setTypeface(typeface);
        tvLocation.setTypeface(typeface);
        tvCardNow.setTypeface(typeface);
        tvCardForecast.setTypeface(typeface);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    public void setOnDrawerMenuToggleListener(OnDrawerMenuToggleListener onDrawerMenuToggleListener) {
        this.onDrawerMenuToggleListener = onDrawerMenuToggleListener;
    }
}
