package com.weather.sweet.xww.colorfulweather.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.weather.sweet.xww.applibaray.utils.statusbar.StatusBarUtil;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/4/9
 * @time : 21:30
 */
public final class OccupyView {

    /**
     * 透明化了状态栏，所以要添加一个 view
     * 来填充到状态栏上，否则内容将会偏移到
     * 状态栏中，显得难看。
     */
    public static View getOccupyStatusbarView(Context context) {
        final int statusBarHeight = StatusBarUtil.getStatusBarHeight(context);
        //添加一个 view 填充到状态栏中，用于偏移
        final View view = new View(context);
        final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(1, statusBarHeight);
        view.setLayoutParams(layoutParams);
        return view;
    }
}
