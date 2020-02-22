package com.weather.sweet.xww.colorfulweather.entity;

import org.litepal.crud.LitePalSupport;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/4/20
 * @time : 下午8:09
 */
public class ProvinceEntity extends LitePalSupport {

    private int provinceId;
    private String provinceName;

    public ProvinceEntity(int provinceId, String provinceName) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
