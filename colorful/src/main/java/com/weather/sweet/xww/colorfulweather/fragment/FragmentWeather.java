package com.weather.sweet.xww.colorfulweather.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.weather.sweet.xww.applibaray.app.AppConfiguration;
import com.weather.sweet.xww.colorfulweather.R;
import com.weather.sweet.xww.colorfulweather.adapter.DailyAdapter;
import com.weather.sweet.xww.colorfulweather.base.BaseFragment;
import com.weather.sweet.xww.colorfulweather.entity.DailyEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 功能：app主界面：碎片一
 * 显示现在的天气情况以及预报
 *
 * @author : xww
 * @created at : 19-3-25
 * @time : 下午08:12
 */
public class FragmentWeather extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.imgv_drawer_menu_icon)
    AppCompatImageView ivDrawerMenu;//开启抽屉的按钮
    @BindView(R.id.linear_header)
    LinearLayoutCompat linearLayoutHeader;//用于添加状态栏占位视图的父容器
    @BindView(R.id.tv_now_weather)
    AppCompatTextView tvNowWeather;//天气
    @BindView(R.id.tv_now_temperature)
    AppCompatTextView tvNowTemperature;//温度
    @BindView(R.id.sweet_swipeRefresh)
    SwipeRefreshLayout mSwipeRefresh;//下拉刷新
    @BindView(R.id.tv_location)
    AppCompatTextView tvLocation;//位置
    @BindView(R.id.tv_daily_card_title)
    AppCompatTextView tvDailyCardTitle;//周预报标题
    @BindView(R.id.tv_hourly_card_title)
    AppCompatTextView tvHourlyCardTitle;//时预报标题
    @BindView(R.id.recycler_daily_forecast)
    RecyclerView recyclerDailyForecast;//未来几天预报

    private DailyAdapter mDailyAdapter;

    // 侧拉按钮监听
    private OnDrawerMenuToggleListener onDrawerMenuToggleListener;

    public void setOnDrawerMenuToggleListener(OnDrawerMenuToggleListener onDrawerMenuToggleListener) {
        this.onDrawerMenuToggleListener = onDrawerMenuToggleListener;
    }

    @Override
    protected View setContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    protected void setupView() {
        initView();
        initRefreshLayout();
        initRecyclerView();
    }

    @Override
    protected void setupData(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    private void initView() {
        //添加到最顶部
        linearLayoutHeader.addView(getOccupyStatusbarView(), 0);
        /**
         * 设置字体
         */
        tvNowWeather.setTypeface(mTypeface);
        tvLocation.setTypeface(mTypeface);
        tvDailyCardTitle.setTypeface(mTypeface);
        tvHourlyCardTitle.setTypeface(mTypeface);

        /**
         * drawer 监听事件，回调给 activity
         */
        ivDrawerMenu.setOnClickListener(v -> {
            if (onDrawerMenuToggleListener != null) {
                onDrawerMenuToggleListener.onClick(v);
            }
        });
    }

    private void initRefreshLayout() {
        mSwipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorDarkSkyBule),
                getResources().getColor(R.color.colorGrassGreen));
        mSwipeRefresh.setOnRefreshListener(this);
    }

    private void initRecyclerView() {
        final List<DailyEntity> dailyEntities = new ArrayList<>();
        dailyEntities.add(new DailyEntity("今天","101","12","18"));
        dailyEntities.add(new DailyEntity("04/02","101","15","19"));
        dailyEntities.add(new DailyEntity("04/03","101","20","27"));
        dailyEntities.add(new DailyEntity("04/04","101","11","17"));
        dailyEntities.add(new DailyEntity("04/05","101","14","21"));
        dailyEntities.add(new DailyEntity("04/06","101","17","25"));
        dailyEntities.add(new DailyEntity("04/07","101","19","26"));
        mDailyAdapter = new DailyAdapter(R.layout.recy_daily_forecast_item, dailyEntities);
        final LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerDailyForecast.setLayoutManager(manager);
        recyclerDailyForecast.setAdapter(mDailyAdapter);
    }

    @Override
    public void onRefresh() {
        AppConfiguration.getInstance().getHandler().postDelayed(() -> {
            if (mSwipeRefresh.isRefreshing()) {
                mSwipeRefresh.setRefreshing(false);
                Toast.makeText(mContext, "更新成功", Toast.LENGTH_SHORT).show();
            }
        }, 2000);
    }
}
