package com.weather.sweet.xww.colorfulweather.fragments;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weather.sweet.xww.colorfulweather.R;
import com.weather.sweet.xww.colorfulweather.adapters.SuggestionAdapter;
import com.weather.sweet.xww.colorfulweather.base.BaseFragment;
import com.weather.sweet.xww.colorfulweather.entity.SuggestionEntity;
import com.weather.sweet.xww.colorfulweather.event.RefreshWeatherDataEvent;
import com.weather.sweet.xww.colorfulweather.utils.Icon;
import com.weather.sweet.xww.colorfulweather.utils.OccupyView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 功能：app主界面：碎片二
 * 显示生活指数等信息
 *
 * @author : xww
 * @created at : 2019/3/25
 * @time : 20:23
 */
public class FragmentLifeIndex extends BaseFragment {

    @BindView(R.id.linear_content)
    LinearLayout linearContent;

    @BindView(R.id.tv_today_index_title)
    AppCompatTextView tvTodayIndexTitle;

    @BindView(R.id.tv_life_index_hum_title)
    AppCompatTextView tvIndexHumTitle;//相对湿度标题

    @BindView(R.id.tv_life_index_hum)
    AppCompatTextView tvIndexHum;//相对湿度

    @BindView(R.id.tv_life_index_wind_sc)
    AppCompatTextView tvIndexWindSc;//风力

    @BindView(R.id.tv_life_index_wind_dir)
    AppCompatTextView tvIndexWindDir;//风向标题

    @BindView(R.id.tv_life_index_fl_title)
    AppCompatTextView tvIndexFlTitle;//体感温度标题

    @BindView(R.id.tv_life_index_fl)
    AppCompatTextView tvIndexFl;//体感温度

    @BindView(R.id.tv_life_index_vis_title)
    AppCompatTextView tvIndexVisTitle;//能见度标题

    @BindView(R.id.tv_life_index_vis)
    AppCompatTextView tvIndexVis;//能见度

    @BindView(R.id.recycler_life_index)
    RecyclerView recyclerLifeIndex;

    @Override
    protected View setContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lifeindex, container, false);
    }

    @Override
    protected void setupView() {
        initView();
        initRecyclerView();
    }

    private void initView() {
        linearContent.addView(OccupyView.getOccupyStatusbarView(mContext), 0);
        tvTodayIndexTitle.setTypeface(mTypeface);
        tvIndexWindDir.setTypeface(mTypeface);
        tvIndexHumTitle.setTypeface(mTypeface);
        tvIndexFlTitle.setTypeface(mTypeface);
        tvIndexVisTitle.setTypeface(mTypeface);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    private List<SuggestionEntity> suggestionEntities = new ArrayList<>();
    private SuggestionAdapter suggestionAdapter;

    private void initRecyclerView() {
        suggestionEntities = new ArrayList<>();
        suggestionAdapter = new SuggestionAdapter(R.layout.recy_life_index_cards_item, suggestionEntities);
        recyclerLifeIndex.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerLifeIndex.setAdapter(suggestionAdapter);
    }

    @Override
    protected void setupData(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final String weatherData = mSharedPreferences.getString("weather_data", "null");

        if (!"null".equals(weatherData)) {
            setupWeatherData(weatherData);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setupWeatherData(String weatherData) {
        final JSONObject heWeather6 = (JSONObject) JSONObject.parse(weatherData);
        final JSONObject object = heWeather6.getJSONArray("HeWeather6").getJSONObject(0);

        final JSONObject now = object.getJSONObject("now");

        final String hum = now.getString("hum");
        final String windSc = now.getString("wind_sc");
        final String windDir = now.getString("wind_dir");
        final String vis = now.getString("vis");
        final String fl = now.getString("fl");

        tvIndexHum.setText(hum + "%");
        tvIndexWindSc.setText(windSc + "级");
        tvIndexWindDir.setText(windDir);
        tvIndexVis.setText(vis + "Km");
        tvIndexFl.setText(fl + "°C");

        final JSONArray lifeArray = object.getJSONArray("lifestyle");
        final int len = lifeArray.size();

        suggestionEntities.clear();
        int type;//指数标志
        String indexType = null;//指数类型
        Drawable icon = null;
        String index = "";
        String suggestion = "";

        for (int i = 0; i < len; i++) {
            type = i;

            switch (type) {
                case 0:
                    indexType = "舒适";
                    icon = Icon.getDrawable(mContext, R.drawable.ic_index_comf);
                    break;
                case 1:
                    indexType = "穿衣";
                    icon = Icon.getDrawable(mContext, R.drawable.ic_index_dress);
                    break;
                case 2:
                    indexType = "感冒";
                    icon = Icon.getDrawable(mContext, R.drawable.ic_index_cold_icon);
                    break;
                case 3:
                    indexType = "运动";
                    icon = Icon.getDrawable(mContext, R.drawable.ic_index_sport_icon);
                    break;
                case 4:
                    indexType = "旅游";
                    icon = Icon.getDrawable(mContext, R.drawable.ic_index_travel_icon);
                    break;
                case 5:
                    indexType = "紫外线";
                    icon = Icon.getDrawable(mContext, R.drawable.ic_index_ultraviolet_ray_icon);
                    break;
                case 6:
                    indexType = "洗车";
                    icon = Icon.getDrawable(mContext, R.drawable.ic_index_car_wash_icon);
                    break;
                case 7:
                    indexType = "空气";
                    icon = Icon.getDrawable(mContext, R.drawable.ic_index_air_icon);
                    break;
                default:
                    indexType = "无数据";
                    icon = Icon.getDrawable(mContext, R.drawable.ic_today_index_humidity);
                    break;
            }

            index = lifeArray.getJSONObject(i).getString("brf");
            suggestion = lifeArray.getJSONObject(i).getString("txt");
            suggestionEntities.add(new SuggestionEntity(icon, indexType, index, suggestion));
        }

        if (suggestionEntities.size() > 0) {
            suggestionAdapter.notifyDataSetChanged();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshWeatherData(RefreshWeatherDataEvent refreshEvent) {
        final String weatherData = refreshEvent.getWeatherData();
        setupWeatherData(weatherData);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
