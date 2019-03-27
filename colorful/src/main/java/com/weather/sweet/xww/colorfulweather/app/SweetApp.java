package com.weather.sweet.xww.colorfulweather.app;

import android.app.Application;

import com.weather.sweet.xww.applibaray.app.AppConfigurator;


/**
 * 功能：
 *
 * @author : xww
 * @created at : 19-3-8
 * @time : 下午08:05
 */
public class SweetApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppConfigurator.getConfiguration()
                .init(this)
                .with("http://127.0.0.1/")
                .configure();

    }
}
