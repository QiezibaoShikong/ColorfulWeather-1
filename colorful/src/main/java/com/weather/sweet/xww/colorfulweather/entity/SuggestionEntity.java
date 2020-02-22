package com.weather.sweet.xww.colorfulweather.entity;

import android.graphics.drawable.Drawable;

/**
 * 功能：生活指数实体类
 *
 * @author : xww
 * @created at : 2019/4/5
 * @time : 14:51
 */
public class SuggestionEntity {
    private Drawable icon;
    private String sugType;
    private String sugIndex;
    private String sugContent;

    public SuggestionEntity(Drawable icon, String sugType, String sugIndex, String sugContent) {
        this.icon = icon;
        this.sugType = sugType;
        this.sugIndex = sugIndex;
        this.sugContent = sugContent;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getSugType() {
        return sugType;
    }

    public void setSugType(String sugType) {
        this.sugType = sugType;
    }

    public String getSugIndex() {
        return sugIndex;
    }

    public void setSugIndex(String sugIndex) {
        this.sugIndex = sugIndex;
    }

    public String getSugContent() {
        return sugContent;
    }

    public void setSugContent(String sugContent) {
        this.sugContent = sugContent;
    }
}
