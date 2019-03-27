package com.weather.sweet.xww.applibaray.ui.dialog.usual;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;

import com.weather.sweet.xww.applibaray.R;


/**
 * 功能：
 *
 * @author : xww
 * @created at : 19-3-19
 * @time : 下午3:30
 */
public class UsualDialog extends AppCompatDialog {
    //标题
    private final String TITLE;
    //提示消息
    private final String MESSAGE;
    //确定按钮的文本内容
    private final String CONFIRM_TEXT;
    //取消按钮的文本内容
    private final String CANCEL_TEXT;
    //确定按钮的监听事件
    private final OnConfirmClickListener ON_CONFIRM_CLICK_LISTENER;
    //取消按钮的监听事件
    private final OnCancelClickListener ON_CANCEL_CLICK_LISTENER;


    public UsualDialog(@NonNull Context context, String title, String message, String confirmText, String cancelText,
                       OnConfirmClickListener onConfirmClickListener, OnCancelClickListener onCancelClickListener) {
        //设置 dialog 样式主题
        super(context, R.style.UsualDialog);
        this.TITLE = title;
        this.MESSAGE = message;
        this.CONFIRM_TEXT = confirmText;
        this.CANCEL_TEXT = cancelText;
        this.ON_CONFIRM_CLICK_LISTENER = onConfirmClickListener;
        this.ON_CANCEL_CLICK_LISTENER = onCancelClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_usual);
        //取消点击空白处隐藏 dialog 事件
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView() {
        final AppCompatButton btnDlgConfirm = findViewById(R.id.btn_confirm);
        final AppCompatButton btnDlgCancel = findViewById(R.id.btn_cancel);
        final AppCompatTextView tvDlgTitle = findViewById(R.id.tv_title);
        final AppCompatTextView tvDlgMessage = findViewById(R.id.tv_message);

        if (!TextUtils.isEmpty(TITLE)) {
            if (tvDlgTitle != null)
                tvDlgTitle.setText(TITLE);
        }
        if (!TextUtils.isEmpty(MESSAGE)) {
            if (tvDlgMessage != null)
                tvDlgMessage.setText(MESSAGE);
        }

        if (!TextUtils.isEmpty(CONFIRM_TEXT)) {
            if (btnDlgConfirm != null) {
                //设置 button 文本
                btnDlgConfirm.setText(CONFIRM_TEXT);
                //设置 button 监听事件
                btnDlgConfirm.setOnClickListener(view -> {
                    if (ON_CONFIRM_CLICK_LISTENER == null)
                        throw new NullPointerException("ON_CONFIRM_CLICK_LISTENER is NULL");

                    ON_CONFIRM_CLICK_LISTENER.onClick(view);
                });
            }
        }

        if (!TextUtils.isEmpty(CANCEL_TEXT)) {
            if (btnDlgCancel != null) {
                btnDlgCancel.setText(CANCEL_TEXT);
                btnDlgCancel.setOnClickListener(view -> {
                    if (ON_CANCEL_CLICK_LISTENER == null)
                        throw new NullPointerException("ON_CANCEL_CLICK_LISTENER is NULL");

                    ON_CANCEL_CLICK_LISTENER.onClick(view);
                });
            }
        }
    }

    public final UsualDialog showing() {
        this.show();
        return this;
    }
}
