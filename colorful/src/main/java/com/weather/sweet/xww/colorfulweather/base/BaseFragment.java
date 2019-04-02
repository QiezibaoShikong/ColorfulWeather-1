package com.weather.sweet.xww.colorfulweather.base;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.sweet.xww.applibaray.utils.statusbar.StatusBarUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/3/31
 * @time : 23:11
 */
public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    protected Unbinder unbinder;
    protected Typeface mTypeface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = setContentView(inflater, container, savedInstanceState);
        mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "maobixingshu.ttf");
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

    /**
     * 透明化了状态栏，所以要添加一个 view
     * 来填充到状态栏上，否则内容将会偏移到
     * 状态栏中，显得难看。
     */
    protected View getOccupyStatusbarView() {
        final int statusBarHeight = StatusBarUtil.getStatusBarHeight(mContext);
        //添加一个 view 填充到状态栏中，用于偏移
        final View view = new View(mContext);
        final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(1, statusBarHeight);
        view.setLayoutParams(layoutParams);
        return view;
    }


    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
