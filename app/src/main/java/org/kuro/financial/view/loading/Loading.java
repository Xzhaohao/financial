package org.kuro.financial.view.loading;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.kuro.financial.R;
import org.kuro.financial.manager.DialogManager;
import org.kuro.financial.utils.AnimUtils;
import org.kuro.financial.view.dialog.DialogView;

/**
 * Loading 加载提示框
 */
public class Loading {

    private final DialogView dialogView;

    private final TextView loadingText;
    private final ImageView loadingImage;

    private final ObjectAnimator mAnim;

    public Loading(Context context) {
        dialogView = DialogManager.getInstance().initView(context, R.layout.loading);
        loadingText = dialogView.findViewById(R.id.loading_text);
        loadingImage = dialogView.findViewById(R.id.loading_image);
        mAnim = AnimUtils.rotation(loadingImage);
    }


    // 设置Loading图片
    public void setLoadingImage(int resId) {
        loadingImage.setImageResource(resId);
    }


    // 设置Loading文本
    public void setLoadingText(String text) {
        if (!TextUtils.isEmpty(text)) {
            loadingText.setText(text);
        }
    }


    public void show() {
        mAnim.start();
        DialogManager.getInstance().show(dialogView);
    }


    public void show(String text) {
        mAnim.start();
        setLoadingText(text);
        DialogManager.getInstance().show(dialogView);
    }


    public void hide() {
        mAnim.pause();
        DialogManager.getInstance().hide(dialogView);
    }


    /**
     * 外部是否可以点击消失
     *
     * @param flag
     */
    public void setCancelable(boolean flag) {
        dialogView.setCancelable(flag);
    }
}
