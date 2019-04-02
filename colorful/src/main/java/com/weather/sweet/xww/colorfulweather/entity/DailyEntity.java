package com.weather.sweet.xww.colorfulweather.entity;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/3/31
 * @time : 20:30
 */
public class DailyEntity {
    private String time;
    private String condCode;
    private String minTemp;
    private String maxTemp;

    public DailyEntity(String time, String condCode, String minTemp, String maxTemp) {
        this.time = time;
        this.condCode = condCode;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
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

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }
}
