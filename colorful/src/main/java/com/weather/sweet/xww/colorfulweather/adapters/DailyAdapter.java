package com.weather.sweet.xww.colorfulweather.adapters;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weather.sweet.xww.applibaray.app.AppConfiguration;
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

    private Typeface mTypeface;

    public DailyAdapter(int layoutResId, @Nullable List<DailyEntity> data) {
        super(layoutResId, data);
        mTypeface = Typeface.createFromAsset(AppConfiguration.getInstance().getAppContext().getAssets(),
                "fangzhengkaiti.ttf");
    }

    @Override
    protected void convert(BaseViewHolder helper, DailyEntity item) {
        final AppCompatTextView date = helper.getView(R.id.tv_daily_date);
//        final AppCompatTextView week = helper.getView(R.id.tv_daily_week);
        final AppCompatTextView weather = helper.getView(R.id.tv_daily_weather);
        final ImageView icon = helper.getView(R.id.imgv_daily_icon);
        final AppCompatTextView tempRange = helper.getView(R.id.tv_daily_temp_range);

        date.setText(item.getDate());
//        week.setText(item.getWeek());
        weather.setText(item.getWeather());
        weather.setTypeface(mTypeface);
        icon.setImageDrawable(Icon.getIcon(mContext, item.getCondCode()));
//        Drawable drawableUp = DrawableCompat.wrap(Icon.getIcon(mContext, item.getCondCode()));
//        DrawableCompat.setTint(drawableUp, R.color.colorPrimary);
//        icon.setImageDrawable(drawableUp);
        tempRange.setText(item.getTempRange());
    }

}
