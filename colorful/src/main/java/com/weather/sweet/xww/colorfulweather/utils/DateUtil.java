package com.weather.sweet.xww.colorfulweather.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xww
 * @desciption :
 * @date 2020/2/21
 * @time 17:54
 */
public class DateUtil {

    public static String getWeek() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("EEEE");
        return df.format(new Date(System.currentTimeMillis()));
    }
}
