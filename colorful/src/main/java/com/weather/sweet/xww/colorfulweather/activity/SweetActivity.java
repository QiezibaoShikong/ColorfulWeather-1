package com.weather.sweet.xww.colorfulweather.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;

import com.weather.sweet.xww.applibaray.adapt.FragmentPageAdapt;
import com.weather.sweet.xww.colorfulweather.R;
import com.weather.sweet.xww.colorfulweather.base.BaseActivity;
import com.weather.sweet.xww.colorfulweather.fragment.FragmentLifeIndex;
import com.weather.sweet.xww.colorfulweather.fragment.FragmentWeather;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;

/**
 * 功能：天气app主界面
 *
 * @author : xww
 * @created at : 19-3-8
 * @time : 下午08:12
 */
public class SweetActivity extends BaseActivity  {

    @BindView(R.id.sweet_drawer)
    DrawerLayout mDrawerLayout;//侧拉抽屉
    @BindView(R.id.vertical_vpage_sweet)
    VerticalViewPager mVerticalViewPager;

    @Override
    protected void setLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_sweet);
    }

    @Override
    protected void setupView() {
        super.setupView();
        initDrawerLayout();
        initViewPager();
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
        mVerticalViewPager.setAdapter(adapt);
        //侧拉监听
        ((FragmentWeather) fragmentNow).setOnDrawerMenuToggleListener(view -> {
                    final boolean isOpen = mDrawerLayout.isDrawerOpen(Gravity.START);
                    if (!isOpen) {
                        mDrawerLayout.openDrawer(Gravity.START);
                    }
                }
        );
    }

    @Override
    protected void setupData() {

    }
}
