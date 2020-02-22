package com.weather.sweet.xww.colorfulweather.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.weather.sweet.xww.applibaray.app.AppConfiguration;
import com.weather.sweet.xww.applibaray.net.rest.RestClient;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 2019/5/13
 * @time : 下午10:57
 */
public class AutoUpdateService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        updateBingPicture();
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int gap = 4 * 60 * 1000 * 60;//四个小时间隔
        long triggerTime = SystemClock.elapsedRealtime() + gap;
        Intent serviceIntent = new Intent(this, AutoUpdateService.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, serviceIntent, 0);
        alarmManager.cancel(pendingIntent);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, pendingIntent);
        return super.onStartCommand(intent, flags, startId);
    }

    private void updateBingPicture() {
        RestClient.Builder()
                .url(AppConfiguration.getInstance().getBingApi())
                .success(response -> {
                    final SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
                    editor.putString("bing_pic", response).apply();
                })
                .build()
                .get();
    }
}
