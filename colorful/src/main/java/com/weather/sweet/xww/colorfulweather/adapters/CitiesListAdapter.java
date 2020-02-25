package com.weather.sweet.xww.colorfulweather.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weather.sweet.xww.applibaray.app.AppConfiguration;
import com.weather.sweet.xww.colorfulweather.R;
import com.weather.sweet.xww.colorfulweather.entity.CitiesListEntity;
import com.weather.sweet.xww.colorfulweather.utils.Icon;

import java.util.List;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/4/5
 * @time : 21:01
 */
public class CitiesListAdapter extends BaseQuickAdapter<CitiesListEntity, BaseViewHolder> {

    private Typeface mTypeface;

    public CitiesListAdapter(int layoutResId, @Nullable List<CitiesListEntity> data) {
        super(layoutResId, data);
        mTypeface = Typeface.createFromAsset(AppConfiguration.getInstance().getAppContext().getAssets(),
                "fangzhengkaiti.ttf");
    }

    @Override
    protected void convert(BaseViewHolder helper, CitiesListEntity item) {
        final AppCompatTextView cityName = helper.getView(R.id.tv_city_name);
        final AppCompatTextView temperature = helper.getView(R.id.tv_city_temperature);
        final AppCompatTextView weather = helper.getView(R.id.tv_city_weather);
        final AppCompatImageView icon = helper.getView(R.id.tv_city_weather_icon);

        cityName.setText(item.getCityName());
        cityName.setTypeface(mTypeface);
        temperature.setText(item.getTemperature());
        weather.setText(item.getWeather());
        weather.setTypeface(mTypeface);
        icon.setImageDrawable(Icon.getIcon(mContext, item.getCondCode()));
        helper.addOnClickListener(R.id.content_item_city_card);
        helper.addOnClickListener(R.id.imgv_city_list_delete);
    }
}
