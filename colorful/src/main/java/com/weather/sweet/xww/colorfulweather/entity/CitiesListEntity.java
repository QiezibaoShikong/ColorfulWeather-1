package com.weather.sweet.xww.colorfulweather.entity;

import org.litepal.crud.LitePalSupport;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/4/9
 * @time : 21:55
 */
public class CitiesListEntity extends LitePalSupport {
    private String cityName;
    private String condCode;
    private String temperature;
    private String weather;
    private String weatherId;

    public CitiesListEntity(String cityName, String condCode, String temperature, String weather, String weatherId) {
        this.cityName = cityName;
        this.condCode = condCode;
        this.temperature = temperature;
        this.weather = weather;
        this.weatherId = weatherId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCondCode() {
        return condCode;
    }

    public void setCondCode(String condCode) {
        this.condCode = condCode;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }
}
