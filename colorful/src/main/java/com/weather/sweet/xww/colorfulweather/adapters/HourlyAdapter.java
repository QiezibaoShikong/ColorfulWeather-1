package com.weather.sweet.xww.colorfulweather.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weather.sweet.xww.colorfulweather.R;
import com.weather.sweet.xww.colorfulweather.entity.HourlyEntity;
import com.weather.sweet.xww.colorfulweather.utils.Icon;

import java.util.List;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/3/31
 * @time : 20:27
 */
public class HourlyAdapter extends BaseQuickAdapter<HourlyEntity, BaseViewHolder> {

    public HourlyAdapter(int layoutResId, @Nullable List<HourlyEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HourlyEntity item) {
        final AppCompatTextView time = helper.getView(R.id.tv_hourly_time);
        final AppCompatImageView icon = helper.getView(R.id.imgv_hourly_weather_icon);
        final AppCompatTextView temperature = helper.getView(R.id.tv_hourly_temperature);

        time.setText(item.getTime());
        icon.setImageDrawable(Icon.getIcon(mContext, item.getCondCode()));
        temperature.setText(item.getTemperature());
    }
}
