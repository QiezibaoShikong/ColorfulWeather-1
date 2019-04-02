package com.weather.sweet.xww.colorfulweather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 功能：处理了拦截事件
 * 解决VerticalViewPager与SwipeRefreshLayout
 * 下拉滑动事件冲突
 *
 * @author : xww
 * @created at : 2019/3/31
 * @time : 21:47
 */
public class VerticalViewPager extends fr.castorflex.android.verticalviewpager.VerticalViewPager {

    //    private int x;
    private int y;
    //按下的x,y坐标
//    private int downX;
    private int downY;


    public VerticalViewPager(Context context) {
        super(context);
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (getCurrentItem() == 0) {
//            x = (int) e.getX();
            y = (int) e.getY();
            switch (e.getAction()) {
                case MotionEvent.ACTION_DOWN:
//                    downX = x;
                    downY = y;
                    break;
                case MotionEvent.ACTION_MOVE:
//                    int dx = x - downX;
                    int dy = y - downY;
                    /**
                     * 如果viewpager在第一页时，放弃处理下拉的事件
                     * 丢给子控件(SwipeRefreshLayout)处理
                     */
                    if (dy > 0) {
                        return false;
                    }
//                    downX = x;
                    downY = y;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
        }
        return super.onInterceptTouchEvent(e);
    }
}
