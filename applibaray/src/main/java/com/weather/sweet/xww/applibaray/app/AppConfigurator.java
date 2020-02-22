package com.weather.sweet.xww.applibaray.app;

import android.content.Context;
import android.os.Handler;

import com.weather.sweet.xww.applibaray.utils.log.LogUtil;

import java.util.HashMap;

/**
 * 功能：app全局参数文件配置
 *
 * @author : xww
 * @created at : 19-3-17
 * @time : 下午8:45
 */
public final class AppConfigurator {

    //保存全局配置文件
    private static final HashMap<Object, Object> APP_CONFIGS = new HashMap<>();
    //全局的 HANDLER
    private static final Handler HANDLER = new Handler();

    private AppConfigurator() {
        APP_CONFIGS.put(ConfigKeys.Handler.name(), HANDLER);
    }

    private final static class Holder {
        private static final AppConfigurator configurator = new AppConfigurator();
    }

    public static AppConfigurator getConfiguration() {
        return Holder.configurator;
    }

    /**
     * 获得整个 app 需要的参数文件
     */
    public final HashMap<Object, Object> getAppConfigs() {
        return APP_CONFIGS;
    }

    public final AppConfigurator init(Context context) {
        APP_CONFIGS.put(ConfigKeys.App_Context.name(), context.getApplicationContext());
        return this;
    }

    public final AppConfigurator withApiHost(String apiHost) {
        APP_CONFIGS.put(ConfigKeys.Api_Host.name(), apiHost);
        return this;
    }

    public final AppConfigurator withBingApi(String bingApi) {
        APP_CONFIGS.put(ConfigKeys.Bing_Api.name(), bingApi);
        return this;
    }

    public final AppConfigurator withProvinceApi(String provinceApi) {
        APP_CONFIGS.put(ConfigKeys.Province_Api.name(), provinceApi);
        return this;
    }

    public final AppConfigurator withApiKey(String apiKey) {
        APP_CONFIGS.put(ConfigKeys.Api_Key.name(), apiKey);
        return this;
    }

    /**
     * 在该方法中配置 app 需要的第三方库依赖
     */
    public final void configure() {
        //logger 工具
        LogUtil.init(LogUtil.DEBUG);
    }
}
