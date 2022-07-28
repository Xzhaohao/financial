package org.kuro.financial.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;

import org.kuro.financial.MainActivity;
import org.kuro.financial.R;
import org.kuro.financial.base.BaseUIActivity;
import org.kuro.financial.utils.SystemUI;

/**
 * 启动页 / 闪屏页
 */
public class IndexActivity extends BaseUIActivity {

    private static final int SKIP_MAIN = 1000;

    private final Handler mHandler = new Handler(message -> {
        if (message.what == SKIP_MAIN) {
            startMain();
        }
        return false;
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        SystemUI.fixSystemUI(this, true);

        mHandler.sendEmptyMessageDelayed(SKIP_MAIN, 2000);
        initView();

        // 设置动画，从透明到不透明
        AlphaAnimation animation = new AlphaAnimation(0, 1);
        animation.setDuration(800);
        // 动画变化率
        animation.setInterpolator(new AccelerateInterpolator());

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // 动画开始
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // 动画结束：跳转页面
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // 动画重复
            }
        });

        RelativeLayout layout = findViewById(R.id.index_layout);
        layout.startAnimation(animation);
    }


    private void initView() {
        Button button = findViewById(R.id.index_start_btn);
        button.setOnClickListener(v -> {
            mHandler.removeMessages(SKIP_MAIN);
            startMain();
        });
    }


    // 进入主页
    private void startMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeMessages(SKIP_MAIN);
    }
}