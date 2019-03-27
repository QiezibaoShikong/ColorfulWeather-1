package com.weather.sweet.xww.applibaray.adapt;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 功能： ViewPageAdapt
 *
 * @author : xww
 * @created at : 19-3-8
 * @time : 下午11:16
 */
public final class ViewPageAdapt extends PagerAdapter {

    private List<View> mViews;

    public ViewPageAdapt(List<View> views) {
        this.mViews = views;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mViews.get(position));
        return mViews.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mViews.get(position));
    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }
}
