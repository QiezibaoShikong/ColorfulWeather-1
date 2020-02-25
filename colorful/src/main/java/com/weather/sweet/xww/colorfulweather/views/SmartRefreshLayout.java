package com.weather.sweet.xww.colorfulweather.views;

import android.content.Context;
import android.util.AttributeSet;

import skin.support.widget.SkinCompatBackgroundHelper;
import skin.support.widget.SkinCompatSupportable;
import skin.support.widget.SkinCompatView;

/**
 * @author xww
 * @desciption :
 * @date 2020/2/23
 * @time 22:04
 */
public class SmartRefreshLayout extends com.scwang.smartrefresh.layout.SmartRefreshLayout implements SkinCompatSupportable {

    private SkinCompatBackgroundHelper mSkinCompatBackgroundHelper;

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public SmartRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mSkinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
    }

    @Override
    public void setBackgroundResource(int resid) {
        super.setBackgroundResource(resid);
        if (mSkinCompatBackgroundHelper != null) {
            mSkinCompatBackgroundHelper.onSetBackgroundResource(resid);
        }
    }

    @Override
    public void applySkin() {
        if (mSkinCompatBackgroundHelper != null) {
            mSkinCompatBackgroundHelper.applySkin();
        }
    }
}
