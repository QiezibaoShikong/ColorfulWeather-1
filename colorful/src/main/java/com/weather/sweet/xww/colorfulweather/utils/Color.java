package com.weather.sweet.xww.colorfulweather.utils;

import android.annotation.SuppressLint;
import android.support.annotation.ColorInt;

import com.weather.sweet.xww.applibaray.app.AppConfiguration;
import com.weather.sweet.xww.colorfulweather.R;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/4/5
 * @time : 18:47
 */
public class Color {
    @SuppressLint("ResourceAsColor")
    public final static int defClrGroup_1_Gradient_1 = getColor(R.color.colorAccent);
    @SuppressLint("ResourceAsColor")
    public final static int defClrGroup_1_Gradient_2 = getColor(R.color.colorPrimary);

    @SuppressLint("ResourceType")
    public static int getColor(@ColorInt int res) {
        return AppConfiguration.getInstance().getAppContext().getResources().getColor(res);
    }
}
