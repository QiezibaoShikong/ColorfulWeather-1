package com.weather.sweet.xww.colorfulweather.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.sweet.xww.applibaray.utils.statusbar.StatusBarUtil;
import com.weather.sweet.xww.colorfulweather.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 功能：基类Fragment
 *
 * @author : xww
 * @created at : 2019/3/31
 * @time : 23:11
 */
public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    protected Unbinder unbinder;
    protected Typeface mTypeface;

    protected int defColorAccent;
    protected int defColorPrimary;
    protected int defSecondTextColor;
    protected SharedPreferences mSharedPreferences;

    private void initColor() {
        defColorAccent = getResources().getColor(R.color.colorAccent);
        defColorPrimary = getResources().getColor(R.color.colorPrimary);
        defSecondTextColor = getResources().getColor(R.color.colorSecondaryText);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        initColor();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = setContentView(inflater, container, savedInstanceState);
        mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fangzhengkaiti.ttf");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        setupView();
        setupData(view, savedInstanceState);
    }

    protected abstract View setContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    protected abstract void setupView();

    protected abstract void setupData(@NonNull View view, @Nullable Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
