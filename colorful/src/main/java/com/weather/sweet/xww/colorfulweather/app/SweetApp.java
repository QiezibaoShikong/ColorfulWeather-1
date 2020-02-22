package com.weather.sweet.xww.colorfulweather.app;

import android.app.Application;

import com.weather.sweet.xww.applibaray.app.AppConfiguration;
import com.weather.sweet.xww.applibaray.app.AppConfigurator;

import org.litepal.LitePal;


/**
 * 功能：初始化APP所需的配置信息
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
                .withApiHost("https://free-api.heweather.net/s6/")
                .withApiKey("497889bcc7634681b7bcf6439e059e16")
                .withBingApi("http://guolin.tech/api/bing_pic")
                .withProvinceApi("http://guolin.tech/api/china")
                .configure();

        LitePal.initialize(this);
    }
}
