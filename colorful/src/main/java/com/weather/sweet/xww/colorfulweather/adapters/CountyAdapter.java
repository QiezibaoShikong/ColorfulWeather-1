package com.weather.sweet.xww.colorfulweather.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weather.sweet.xww.colorfulweather.R;
import com.weather.sweet.xww.colorfulweather.entity.CountyEntity;

import java.util.List;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/4/20
 * @time : 下午10:17
 */
public class CountyAdapter extends BaseQuickAdapter<CountyEntity,BaseViewHolder> {

    public CountyAdapter(int layoutResId, @Nullable List<CountyEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CountyEntity item) {
        final AppCompatTextView tvProvinceName = helper.getView(R.id.tv_city_search_name);

        tvProvinceName.setText(item.getCountyName());
    }
}
