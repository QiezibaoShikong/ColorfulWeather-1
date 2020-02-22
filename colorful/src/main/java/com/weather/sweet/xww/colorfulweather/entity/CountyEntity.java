package com.weather.sweet.xww.colorfulweather.entity;

import org.litepal.crud.LitePalSupport;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/4/20
 * @time : 下午8:17
 */
public class CountyEntity extends LitePalSupport {

    private int countyId;
    private String countyName;
    private String weatherId;
    private int cityId;

    public CountyEntity(int countyId, String countyName, String weatherId, int cityId) {
        this.countyId = countyId;
        this.countyName = countyName;
        this.weatherId = weatherId;
        this.cityId = cityId;
    }

    public int getCountyId() {
        return countyId;
    }

    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
