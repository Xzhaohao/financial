package org.kuro.financial.ui;

import android.os.Bundle;
import android.widget.ImageView;

import org.kuro.financial.R;
import org.kuro.financial.base.BaseUIActivity;

public class WithdrawActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        initView();
    }


    private void initView() {
        ImageView back = findViewById(R.id.withdraw_back);
        back.setOnClickListener(v -> finish());
    }
}