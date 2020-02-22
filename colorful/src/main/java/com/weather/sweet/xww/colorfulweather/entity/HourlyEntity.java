package com.weather.sweet.xww.colorfulweather.entity;

/**
 * 功能：逐小时预报实体类
 *
 * @author : xww
 * @created at : 2019/3/31
 * @time : 20:30
 */
public class HourlyEntity {
    private String time;
    private String condCode;
    private String temperature;

    public HourlyEntity(String time, String condCode, String temperature) {
        this.time = time;
        this.condCode = condCode;
        this.temperature = temperature;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
}
