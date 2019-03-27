package com.weather.sweet.xww.applibaray.ui.dialog.usual;

import android.content.Context;

/**
 * 功能：
 *
 * @author : xww
 * @created at : 19-3-19
 * @time : 下午4:10
 */
public final class UsualDialogBuidler {

    private Context mContext;
    private String mTitle;
    private String mMessage;
    private String mConfirmText;
    private String mCancelText;
    private OnConfirmClickListener mOnConfirmClickListener;
    private OnCancelClickListener mOnCcancelClickListener;

    public UsualDialogBuidler(Context context) {
        this.mContext = context;
    }

    public final UsualDialogBuidler setTitle(String title) {
        this.mTitle = title;
        return this;
    }

    public final UsualDialogBuidler setMessage(String message) {
        this.mMessage = message;
        return this;
    }

    public final UsualDialogBuidler setOnConfirmClickListener(String confirmText, OnConfirmClickListener confirmclickListener) {
        this.mConfirmText = confirmText;
        this.mOnConfirmClickListener = confirmclickListener;
        return this;
    }

    public final UsualDialogBuidler setOnCancelClickListener(String cancelText, OnCancelClickListener onCancelclickListener) {
        this.mCancelText = cancelText;
        this.mOnCcancelClickListener = onCancelclickListener;
        return this;
    }

    public final UsualDialog build() {
        return new UsualDialog(mContext, mTitle, mMessage, mConfirmText, mCancelText,
                mOnConfirmClickListener, mOnCcancelClickListener);
    }
}

