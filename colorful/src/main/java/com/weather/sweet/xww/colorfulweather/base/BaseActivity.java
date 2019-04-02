package com.weather.sweet.xww.colorfulweather.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.weather.sweet.xww.applibaray.utils.activity.ActivityUtil;
import com.weather.sweet.xww.applibaray.utils.statusbar.StatusBarUtil;
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



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityUtil.add(this);
        StatusBarUtil.setTranslucent(this);
        init();
        //加载布局
        setLayout(savedInstanceState);
        setupView();
        setupData();
    }

    /**
     * 在 view 绑定之前调用此方法，如设置状态栏
     */
    protected void init() {
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
        super.onDestroy();
        ActivityUtil.remove(this);
    }
}
