package com.weather.sweet.xww.colorfulweather.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.sweet.xww.colorfulweather.R;

/**
 * 功能：app主界面：碎片二
 * 显示未来几天的天气情况
 *
 * @author : xww
 * @created at : 2019/3/25
 * @time : 20:23
 */
public class FragmentForecastWeather extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_sweet_forecast, container,false);
        return view;
    }
}
