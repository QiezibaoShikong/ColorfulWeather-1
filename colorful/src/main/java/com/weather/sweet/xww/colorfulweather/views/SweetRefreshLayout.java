package com.weather.sweet.xww.colorfulweather.views;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * 功能：解决SwipeRefreshLayout和ViewPager 滑动事件冲突
 * 解决思路：
 * 1. 因为下拉刷新，只有纵向滑动的时候才有效，那么我们就判断此时是纵向滑动还是横向滑动就可以了。
 * 2. 纵向滑动就拦截事件，横向滑动不拦截。
 * 3. 怎么判断是纵向滑动还是横向滑动，只要判断Y轴的移动距离大于X轴的移动距离那么就判定为纵向滑动就行了。
 *
 * @author : xww
 * @created at : 2019/4/30
 * @time : 下午6:38
 */
public class SweetRefreshLayout extends SwipeRefreshLayout {

    private float downY;
    private float downX;
    // 记录viewPager是否拖拽的标记
    private boolean mIsVpDragger;
    private final int mTouchSlop;

    public SweetRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录手指按下的位置
                downY = ev.getY();
                downX = ev.getX();
                // 初始化标记
                mIsVpDragger = false;
                break;
            case MotionEvent.ACTION_MOVE:
                // 如果viewpager正在拖拽中，那么不拦截它的事件，直接return false；
                if (mIsVpDragger) {
                    return false;
                }

                // 获取当前手指位置
                float endY = ev.getY();
                float endX = ev.getX();
                float distanceX = Math.abs(endX - downX);
                float distanceY = Math.abs(endY - downY);
                // 如果X轴位移大于Y轴位移，那么将事件交给viewPager处理。
                if (distanceX > mTouchSlop && distanceX > distanceY) {
                    mIsVpDragger = true;
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                // 初始化标记
                mIsVpDragger = false;
                break;
        }
        // 如果是Y轴位移大于X轴，事件交给swipeRefreshLayout处理。
        return super.onInterceptTouchEvent(ev);
    }

}
