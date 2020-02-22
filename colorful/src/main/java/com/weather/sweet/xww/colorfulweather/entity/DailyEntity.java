package com.weather.sweet.xww.colorfulweather.entity;

/**
 * 功能：未来几天天气预报实体类
 *
 * @author : xww
 * @created at : 2019/4/5
 * @time : 20:57
 */
public class DailyEntity {

    private String condCode;
    private String date;
    private String week;
    private String tempRange;
    private String weather;

    public DailyEntity(String condCode, String date, String week, String tempRange, String weather) {
        this.condCode = condCode;
        this.date = date;
        this.week = week;
        this.tempRange = tempRange;
        this.weather = weather;
    }

    public String getCondCode() {
        return condCode;
    }

    public void setCondCode(String condCode) {
        this.condCode = condCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getTempRange() {
        return tempRange;
    }

    public void setTempRange(String tempRange) {
        this.tempRange = tempRange;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
