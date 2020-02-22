package com.weather.sweet.xww.colorfulweather.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weather.sweet.xww.colorfulweather.R;
import com.weather.sweet.xww.colorfulweather.entity.DailyEntity;
import com.weather.sweet.xww.colorfulweather.utils.Icon;

import java.util.List;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/4/5
 * @time : 21:01
 */
public class DailyAdapter extends BaseQuickAdapter<DailyEntity, BaseViewHolder> {

    public DailyAdapter(int layoutResId, @Nullable List<DailyEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DailyEntity item) {
        final AppCompatTextView date = helper.getView(R.id.tv_daily_date);
//        final AppCompatTextView week = helper.getView(R.id.tv_daily_week);
        final AppCompatTextView weather = helper.getView(R.id.tv_daily_weather);
        final AppCompatImageView icon = helper.getView(R.id.imgv_daily_icon);
        final AppCompatTextView tempRange = helper.getView(R.id.tv_daily_temp_range);

        date.setText(item.getDate());
//        week.setText(item.getWeek());
        weather.setText(item.getWeather());
        icon.setImageDrawable(Icon.getIcon(mContext, item.getCondCode()));
        tempRange.setText(item.getTempRange());
    }

}
