package com.weather.sweet.xww.colorfulweather.views;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.weather.sweet.xww.colorfulweather.R;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/3/26
 * @time : 16:02
 */
public class IconViewAnimation extends View {

    private Paint mPaint;
    private int clrWhite;
    private Bitmap mWeatherBitmap;
    //icon的x坐标
    private int x;
    //icon的y坐标
    private int y;
    //画布的宽
    private int canvasWidth;
    //画布的高
    private int canvasHeight;
    //图片缩放后实际的宽
    private int realBmpWidth;
    //图片缩放后实际的高
    private int realBmpHeight;
    /**
     * icon 移动的标识
     */
    private boolean isLeft = true;
    private boolean isRight = false;

    public IconViewAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
        init();
    }

    public IconViewAnimation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setWeatherIcon(@DrawableRes int iconRes) {
        mWeatherBitmap = BitmapFactory.decodeResource(getResources(), iconRes);

    }

    private void init() {
        initPaint();
        setWeatherIcon(R.drawable.ic_100);
        startAnimation();
    }

    private void initPaint() {
        clrWhite = getResources().getColor(R.color.colorSecondaryText);
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setColor(clrWhite);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10f);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("CanvasSize")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        final Bitmap icon = getNewBitmap(mWeatherBitmap, canvasWidth / 4, canvasWidth / 4);
        realBmpWidth = icon.getWidth();
        realBmpHeight = icon.getHeight();
        //画边框
//        canvas.drawRect(0, 0, canvasWidth, canvasHeight, mPaint);
        //画到底部
        y = canvasHeight - realBmpHeight;
        //画天气图标
        canvas.drawBitmap(icon, x, y, mPaint);
    }

    public Bitmap getNewBitmap(Bitmap bitmap, int newWidth, int newHeight) {
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {//如果图片为空，或者宽、高为0，则无法显示
            //默认加载一张天气icon
            mWeatherBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_100);
            return setScaleBitmap(mWeatherBitmap, newWidth, newHeight);
        } else {
            return setScaleBitmap(bitmap, newWidth, newHeight);
        }
    }

    /**
     * 缩放天气icon图片
     */
    private Bitmap setScaleBitmap(Bitmap bitmap, int newWidth, int newHeight) {
        // 获得图片的宽高.
        final int width = bitmap.getWidth();
        final int height = bitmap.getHeight();
        // 计算缩放比例.
        final float scaleWidth = ((float) newWidth) / width;
        final float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数.
        final Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片.
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            invalidate();
        }
    };

    private void startAnimation() {
        new Thread(() -> {
            while (true) {

                if (isLeft) {
                    x++;
                    if (x + realBmpWidth >= canvasWidth) {
                        isLeft = false;
                        isRight = true;
                    }
                }
                if (isRight) {
                    x--;
                    if (x <= 0) {
                        isRight = false;
                        isLeft = true;
                    }
                }
//                y++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(0);

            }
        }).start();
    }
}
