package com.weather.sweet.xww.colorfulweather.adapters;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weather.sweet.xww.applibaray.app.AppConfiguration;
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
        final ImageView icon = helper.getView(R.id.imgv_hourly_weather_icon);
        final AppCompatTextView temperature = helper.getView(R.id.tv_hourly_temperature);

        time.setText(item.getTime());
        icon.setImageDrawable(Icon.getIcon(mContext, item.getCondCode()));
//        Drawable drawableUp = DrawableCompat.wrap(Icon.getIcon(mContext, item.getCondCode()));
//        DrawableCompat.setTint(drawableUp, R.color.colorAccent);
//        icon.setImageDrawable(drawableUp);
        temperature.setText(item.getTemperature());
    }
}
