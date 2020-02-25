package com.weather.sweet.xww.colorfulweather.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.SkinAppCompatDelegateImpl;

import com.weather.sweet.xww.applibaray.utils.activity.ActivityUtil;
import com.weather.sweet.xww.applibaray.utils.statusbar.StatusBarUtil;
import com.weather.sweet.xww.colorfulweather.R;

import butterknife.ButterKnife;


/**
 * 功能：基类 activity
 *
 * @author : xww
 * @created at : 19-3-8
 * @time : 下午08:19
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    protected Typeface mTypeface;
    protected SharedPreferences mSharedPreferences;

    protected void onPreCreate() {

    }

    /**
     * 如果项目中使用的Activity继承自AppCompatActivity，需要重载getDelegate()方法
     */
    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        onPreCreate();
        super.onCreate(savedInstanceState);

        ActivityUtil.add(this);
        StatusBarUtil.setTranslucent(this);
        init();
        //加载布局
        setLayout(savedInstanceState);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        setupView();
        setupData();

    }

    /**
     * 在 view 绑定之前调用此方法，如设置状态栏
     */
    protected void init() {
        mTypeface = Typeface.createFromAsset(getAssets(), "fangzhengkaiti.ttf");
    }

    /**
     * 绑定视图，
     */
    protected abstract void setLayout(@Nullable Bundle savedInstanceState);

    /**
     * 　设置 view 参数
     */
    protected void setupView() {
        mContext = this;
        ButterKnife.bind(this);
    }

    /**
     * 设置数据
     */
    protected void setupData() {
    }

    @Override
    protected void onDestroy() {
        mContext = null;
        ActivityUtil.remove(this);
        super.onDestroy();
    }
}
