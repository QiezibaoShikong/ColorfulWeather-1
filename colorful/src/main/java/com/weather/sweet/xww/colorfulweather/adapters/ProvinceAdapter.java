package com.weather.sweet.xww.colorfulweather.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weather.sweet.xww.colorfulweather.R;
import com.weather.sweet.xww.colorfulweather.entity.ProvinceEntity;

import java.util.List;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/4/20
 * @time : 下午7:54
 */
public class ProvinceAdapter extends BaseQuickAdapter<ProvinceEntity, BaseViewHolder> {

    public ProvinceAdapter(int layoutResId, @Nullable List<ProvinceEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProvinceEntity item) {
        final AppCompatTextView tvProvinceName = helper.getView(R.id.tv_city_search_name);

        tvProvinceName.setText(item.getProvinceName());
    }
}
