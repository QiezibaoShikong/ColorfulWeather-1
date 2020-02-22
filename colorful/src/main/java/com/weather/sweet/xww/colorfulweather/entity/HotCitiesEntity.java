package com.weather.sweet.xww.colorfulweather.entity;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/4/21
 * @time : 下午3:57
 */
public class HotCitiesEntity {

    private String hotCityName;
    private String hotCityWeatherId;

    public HotCitiesEntity(String hotCityName, String hotCityWeatherId) {
        this.hotCityName = hotCityName;
        this.hotCityWeatherId = hotCityWeatherId;
    }

    public String getHotCityName() {
        return hotCityName;
    }

    public void setHotCityName(String hotCityName) {
        this.hotCityName = hotCityName;
    }

    public String getHotCityWeatherId() {
        return hotCityWeatherId;
    }

    public void setHotCityWeatherId(String hotCityWeatherId) {
        this.hotCityWeatherId = hotCityWeatherId;
    }
}
