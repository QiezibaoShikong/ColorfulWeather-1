package com.weather.sweet.xww.colorfulweather.entity;

import org.litepal.crud.LitePalSupport;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/4/20
 * @time : 下午8:15
 */
public class CityEntity extends LitePalSupport {

    private int cityId;
    private String cityName;
    private int provinceId;

    public CityEntity(int cityId, String cityName, int provinceId) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
