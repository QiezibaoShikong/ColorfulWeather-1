package com.weather.sweet.xww.colorfulweather.event;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/4/30
 * @time : 下午2:46
 */
public class RefreshWeatherDataEvent {
    private String weatherData;

    public RefreshWeatherDataEvent(String weatherData) {
        this.weatherData = weatherData;
    }

    public String getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(String weatherData) {
        this.weatherData = weatherData;
    }
}
