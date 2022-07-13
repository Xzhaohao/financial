package org.kuro.financial.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

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

        mHandler.sendEmptyMessageDelayed(SKIP_MAIN, 2 * 1000);
        initView();
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
}