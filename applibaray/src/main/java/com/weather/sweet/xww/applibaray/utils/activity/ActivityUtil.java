package com.weather.sweet.xww.applibaray.utils.activity;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能： activity 工具类
 *
 * @author : xww
 * @created at : 19-3-21
 * @time : 下午8:52
 */
public final class ActivityUtil {

    private static final List<Activity> ACTIVITIES = new ArrayList<>();

    public static void add(Activity activity) {
        ACTIVITIES.add(activity);
    }

    public static void remove(Activity activity) {
        ACTIVITIES.remove(activity);
    }

    public static void finish() {
        for (Activity activity : ACTIVITIES) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        ACTIVITIES.clear();
    }
}
