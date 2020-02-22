package com.weather.sweet.xww.colorfulweather.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

import com.weather.sweet.xww.colorfulweather.R;

/**
 * 功能：根据服务器返回的天梯code
 * 获得对应的天气icon
 *
 * @author : xww
 * @created at : 2019/4/2
 * @time : 22:23
 */
public class Icon {

    public static Drawable getIcon(Context context, String iconCode) {
        Drawable drawable = null;
        switch (iconCode) {
            case "100":
                drawable = getDrawable(context, R.drawable.ic_100);
                break;
            case "100n":
                drawable = getDrawable(context, R.drawable.ic_100n);
                break;
            case "101":
                drawable = getDrawable(context, R.drawable.ic_101);
                break;
            case "102":
                drawable = getDrawable(context, R.drawable.ic_102);
                break;
            case "103":
                drawable = getDrawable(context, R.drawable.ic_103);
                break;
            case "103n":
                drawable = getDrawable(context, R.drawable.ic_103n);
                break;
            case "104":
                drawable = getDrawable(context, R.drawable.ic_104);
                break;
            case "104n":
                drawable = getDrawable(context, R.drawable.ic_104n);
                break;

            case "200":
                drawable = getDrawable(context, R.drawable.ic_200);
                break;
            case "201":
                drawable = getDrawable(context, R.drawable.ic_201);
                break;
            case "202":
                drawable = getDrawable(context, R.drawable.ic_202);
                break;
            case "203":
                drawable = getDrawable(context, R.drawable.ic_203);
                break;
            case "204":
                drawable = getDrawable(context, R.drawable.ic_204);
                break;
            case "205":
                drawable = getDrawable(context, R.drawable.ic_205);
                break;
            case "206":
                drawable = getDrawable(context, R.drawable.ic_206);
                break;
            case "207":
                drawable = getDrawable(context, R.drawable.ic_207);
                break;
            case "208":
                drawable = getDrawable(context, R.drawable.ic_208);
                break;
            case "209":
                drawable = getDrawable(context, R.drawable.ic_209);
                break;
            case "210":
                drawable = getDrawable(context, R.drawable.ic_210);
                break;
            case "211":
                drawable = getDrawable(context, R.drawable.ic_211);
                break;
            case "212":
                drawable = getDrawable(context, R.drawable.ic_212);
                break;
            case "213":
                drawable = getDrawable(context, R.drawable.ic_213);
                break;

            case "300":
                drawable = getDrawable(context, R.drawable.ic_300);
                break;
            case "300n":
                drawable = getDrawable(context, R.drawable.ic_300n);
                break;
            case "301":
                drawable = getDrawable(context, R.drawable.ic_301);
                break;
            case "301n":
                drawable = getDrawable(context, R.drawable.ic_301n);
                break;
            case "302":
                drawable = getDrawable(context, R.drawable.ic_302);
                break;
            case "303":
                drawable = getDrawable(context, R.drawable.ic_303);
                break;
            case "304":
                drawable = getDrawable(context, R.drawable.ic_304);
                break;
            case "305":
                drawable = getDrawable(context, R.drawable.ic_305);
                break;
            case "306":
                drawable = getDrawable(context, R.drawable.ic_306);
                break;
            case "307":
                drawable = getDrawable(context, R.drawable.ic_307);
                break;
            case "309":
                drawable = getDrawable(context, R.drawable.ic_309);
// ************************************* 莫名其妙 ********************************************* //
            case "399": // （ Api 返回一个 cond_code ：399）
                drawable = getDrawable(context, R.drawable.ic_309);
// ************************************* 莫名其妙 ********************************************* //
                break;
            case "310":
                drawable = getDrawable(context, R.drawable.ic_310);
                break;
            case "311":
                drawable = getDrawable(context, R.drawable.ic_311);
                break;
            case "312":
                drawable = getDrawable(context, R.drawable.ic_312);
                break;
            case "313":
                drawable = getDrawable(context, R.drawable.ic_313);
                break;

            case "400":
                drawable = getDrawable(context, R.drawable.ic_400);
                break;
            case "401":
                drawable = getDrawable(context, R.drawable.ic_401);
                break;
            case "402":
                drawable = getDrawable(context, R.drawable.ic_402);
                break;
            case "403":
                drawable = getDrawable(context, R.drawable.ic_403);
                break;
            case "404":
                drawable = getDrawable(context, R.drawable.ic_404);
                break;
            case "405":
                drawable = getDrawable(context, R.drawable.ic_405);
                break;
            case "406":
                drawable = getDrawable(context, R.drawable.ic_406);
                break;
            case "406n":
                drawable = getDrawable(context, R.drawable.ic_406n);
                break;
            case "407":
                drawable = getDrawable(context, R.drawable.ic_407);
                break;
            case "407n":
                drawable = getDrawable(context, R.drawable.ic_407n);
                break;

            case "500":
                drawable = getDrawable(context, R.drawable.ic_500);
                break;
            case "501":
                drawable = getDrawable(context, R.drawable.ic_501);
                break;
            case "502":
                drawable = getDrawable(context, R.drawable.ic_502);
                break;
            case "503":
                drawable = getDrawable(context, R.drawable.ic_503);
                break;
            case "504":
                drawable = getDrawable(context, R.drawable.ic_504);
                break;
            case "507":
                drawable = getDrawable(context, R.drawable.ic_507);
                break;
            case "508":
                drawable = getDrawable(context, R.drawable.ic_508);
                break;

            case "900":
                drawable = getDrawable(context, R.drawable.ic_900);
                break;
            case "901":
                drawable = getDrawable(context, R.drawable.ic_901);
                break;
            case "999":
                drawable = getDrawable(context, R.drawable.ic_999);
                break;
        }
        return drawable;
    }

    public static Drawable getDrawable(Context context, @DrawableRes int res) {
        return context.getResources().getDrawable(res);
    }
}
