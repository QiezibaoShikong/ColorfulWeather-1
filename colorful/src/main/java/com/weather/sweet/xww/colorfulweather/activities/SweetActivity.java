package com.weather.sweet.xww.colorfulweather.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.SkinAppCompatDelegateImpl;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.weather.sweet.xww.applibaray.adapt.FragmentPageAdapt;
import com.weather.sweet.xww.applibaray.app.AppConfiguration;
import com.weather.sweet.xww.applibaray.net.rest.RestClient;
import com.weather.sweet.xww.applibaray.utils.log.LogUtil;
import com.weather.sweet.xww.colorfulweather.R;
import com.weather.sweet.xww.colorfulweather.adapters.CitiesListAdapter;
import com.weather.sweet.xww.colorfulweather.base.BaseActivity;
import com.weather.sweet.xww.colorfulweather.entity.CitiesListEntity;
import com.weather.sweet.xww.colorfulweather.event.RefreshWeatherDataEvent;
import com.weather.sweet.xww.colorfulweather.fragments.FragmentLifeIndex;
import com.weather.sweet.xww.colorfulweather.fragments.FragmentWeather;
import com.weather.sweet.xww.colorfulweather.service.AutoUpdateService;
import com.weather.sweet.xww.colorfulweather.utils.OccupyView;

import org.greenrobot.eventbus.EventBus;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 功能：天气app主界面
 *
 * @author : xww
 * @created at : 19-3-8
 * @time : 下午08:12
 */
public class SweetActivity extends BaseActivity {

    @BindView(R.id.sweet_drawer)
    DrawerLayout mDrawerLayout;//侧拉抽屉

    @BindView(R.id.vertical_vpage_sweet)
    ViewPager mViewPager;

    @BindView(R.id.tv_drawer_city_choose)
    AppCompatTextView tvCityChoose;

    @BindView(R.id.tv_data_source_licence)
    AppCompatTextView tvDataSourceLicence;

    @BindView(R.id.linear_drawer_head_bar)
    LinearLayout mLinearDrawerHeaderBar;

    @BindView(R.id.recycler_cities_list)
    RecyclerView mCitiesRecyclerView;

    @BindView(R.id.sweet_swipeRefresh)
    SmartRefreshLayout mSwipeRefresh;//下拉刷新

    @BindView(R.id.drawer_content)
    CoordinatorLayout mDrawer;

    private List<CitiesListEntity> mCitiesListEntities;
    private CitiesListAdapter mCitiesListAdapter;

    private String mWeatherId;

    //启动活动到请求码
    private static final int RESULT_CODE = 3;

    @Override
    protected void setLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_sweet);
    }

    @Override
    protected void setupView() {
        super.setupView();
        initView();
        initDrawerLayout();
        initViewPager();
        initCitiesRecyclerView();
        initRefreshLayout();
    }

    private void initView() {
        mLinearDrawerHeaderBar.addView(OccupyView.getOccupyStatusbarView(mContext), 0);
        mWeatherId = mSharedPreferences.getString("defCityCode", "CN101010100");
        tvCityChoose.setTypeface(mTypeface);
        tvDataSourceLicence.setTypeface(mTypeface);
        tvDataSourceLicence.setOnClickListener(v -> {
            Intent intent = new Intent(SweetActivity.this, MeActivity.class);
            startActivity(intent);
        });

        //设置 Drawer 内容全屏
//        ViewGroup.LayoutParams layoutParams = mDrawer.getLayoutParams();
//        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
//        mDrawer.setLayoutParams(layoutParams);
    }

    private void initDrawerLayout() {
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawer, float slideOffset) {
                if (mDrawerLayout.getTag().equals("left")) {
                    final View content = mDrawerLayout.getChildAt(0);
                    /**
                     * 这里一定要使用 drawer ，而不能使用 mDrawerLayout 的宽度
                     * mDrawerLayout 获取的宽度是占了整个屏幕的宽
                     * drawer 获取的是当前实际的宽度
                     */
                    content.setTranslationX(drawer.getMeasuredWidth() * slideOffset);
                }
            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
            }

            @Override
            public void onDrawerStateChanged(int i) {
            }
        });
    }

    private void initViewPager() {
        final List<Fragment> fragments = new ArrayList<>();
        final Fragment fragmentNow = new FragmentWeather();
        final Fragment fragmentForecast = new FragmentLifeIndex();
        fragments.add(fragmentNow);
        fragments.add(fragmentForecast);
        final FragmentPageAdapt adapt = new FragmentPageAdapt(fragments, getSupportFragmentManager());
        mViewPager.setAdapter(adapt);
        //侧拉监听
        ((FragmentWeather) fragmentNow).setOnDrawerMenuToggleListener(view -> {
                    final boolean isOpen = mDrawerLayout.isDrawerOpen(Gravity.START);
                    if (!isOpen) {
                        mDrawerLayout.openDrawer(Gravity.START);
                    }
                }
        );
    }


    private void initCitiesRecyclerView() {
        mCitiesListEntities = LitePal.findAll(CitiesListEntity.class);
        mCitiesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCitiesListAdapter = new CitiesListAdapter(R.layout.recy_drawer_city_list_item, mCitiesListEntities);
        mCitiesRecyclerView.setAdapter(mCitiesListAdapter);

        //添加底部按钮
        final View headerView = LayoutInflater.from(this).inflate(R.layout.layout_cities_header_view, null);
        mCitiesListAdapter.addHeaderView(headerView);

        headerView.setOnClickListener(v -> {
            final Intent intent = new Intent(this, CitySelectActivity.class);
            startActivityForResult(intent, RESULT_CODE);
        });

        mCitiesListAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.content_item_city_card:// Item 点击事件
                    mDrawerLayout.closeDrawer(Gravity.START);
                    mWeatherId = mCitiesListEntities.get(position).getWeatherId();
                    mSwipeRefresh.autoRefresh();
                    mSharedPreferences.edit().putString("defCityCode", mWeatherId).apply();

                    AppConfiguration.getInstance().getHandler().postDelayed(() -> {
                        requestWeatherInfo(mWeatherId);
                        Toast.makeText(mContext, "切换成功", Toast.LENGTH_SHORT).show();
                    }, 1000);
                    break;
                case R.id.imgv_city_list_delete: // 侧拉删除按钮
                    // 先获取 cityName
                    final String cityName = mCitiesListEntities.get(position).getCityName();
                    // 集合移除 cityName 刷新适配器
                    mCitiesListAdapter.remove(position);
                    LitePal.deleteAll(CitiesListEntity.class, "cityName=?", cityName);
                    Toast.makeText(mContext, "删除成功", Toast.LENGTH_SHORT).show();
                    break;
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case RESULT_CODE:
                if (resultCode == RESULT_OK) {
                    if (data != null) {
                        final boolean changed = data.getBooleanExtra("changed", false);

                        if (changed) {
                            mCitiesListEntities.clear();
                            mCitiesListEntities.addAll(LitePal.findAll(CitiesListEntity.class));
                            if (mCitiesListEntities.size() > 0) {
                                mCitiesListAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                }
                break;
        }
    }

    @Override
    protected void setupData() {
        final String weatherData = mSharedPreferences.getString("weather_data", "null");
        if ("null".equals(weatherData)) {
            mSwipeRefresh.autoRefresh();
            AppConfiguration.getInstance().getHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    requestWeatherInfo(mWeatherId);
                }
            }, 1500);
        }

        Intent autoUpdateIntent = new Intent(this, AutoUpdateService.class);
        startService(autoUpdateIntent);
    }

    private void requestWeatherInfo(String weatherId) {
        final StringBuilder url = new StringBuilder()
                .append(AppConfiguration.getInstance().getApiHost())
                .append("weather?")
                .append("location=")
                .append(weatherId)
                .append("&key=")
                .append(AppConfiguration.getInstance().getApiKey());

        RestClient.Builder()
                .url(url.toString())
                .success(response -> {
                    final JSONObject heWeather6 = (JSONObject) JSONObject.parse(response);
                    final JSONObject object = heWeather6.getJSONArray("HeWeather6").getJSONObject(0);
                    final String status = object.getString("status");

                    if ("ok".equals(status)) {
                        LogUtil.logD(response);
                        mSharedPreferences.edit().putString("weather_data", response).apply();
                        EventBus.getDefault().post(new RefreshWeatherDataEvent(response));
                        mSwipeRefresh.finishRefresh();
                    }
                })
                .error((code, msg) -> {
                    Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                })
                .build()
                .get();
    }

    private void initRefreshLayout() {
        mSwipeRefresh.setBackgroundResource(R.drawable.bg_sweet_card_header_gradient);
        mSwipeRefresh.setOnRefreshListener(refreshLayout ->
                AppConfiguration.getInstance().getHandler().postDelayed(() ->
                        requestWeatherInfo(mWeatherId), 1000));
    }
}
