package com.weather.sweet.xww.colorfulweather.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author xww
 * @desciption : 闪屏页
 * @date 2020/2/15
 * @time 20:46
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(SplashActivity.this, SweetActivity.class);
        startActivity(intent);
        finish();
    }
}
