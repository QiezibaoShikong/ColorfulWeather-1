package com.weather.sweet.xww.colorfulweather.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weather.sweet.xww.colorfulweather.R;
import com.weather.sweet.xww.colorfulweather.entity.DailyEntity;

import java.util.List;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/3/31
 * @time : 20:27
 */
public class DailyAdapter extends BaseQuickAdapter<DailyEntity, BaseViewHolder> {

    public DailyAdapter(int layoutResId, @Nullable List<DailyEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DailyEntity item) {
        final AppCompatTextView tvDailyTime = helper.getView(R.id.tv_daily_time);
        final AppCompatImageView imgvDailyWeatherIcon = helper.getView(R.id.imgv_daily_weather_icon);
        final AppCompatTextView tvDailyTemperature = helper.getView(R.id.tv_daily_temperature);

        tvDailyTime.setText(item.getTime());
        imgvDailyWeatherIcon.setBackgroundResource(R.drawable.ic_101);
        final StringBuilder temps = new StringBuilder(item.getMinTemp() + "°~" + item.getMaxTemp() + "°");
        tvDailyTemperature.setText(temps);
    }
}
