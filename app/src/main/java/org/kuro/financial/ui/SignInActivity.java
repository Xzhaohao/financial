package org.kuro.financial.ui;

import android.os.Bundle;
import android.widget.GridView;

import org.kuro.financial.R;
import org.kuro.financial.adapter.SignInAdapter;
import org.kuro.financial.base.BaseUIActivity;

public class SignInActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initView();
    }


    private void initView() {
        GridView layout = findViewById(R.id.sign_in_days);
        layout.setAdapter(new SignInAdapter(this));
    }
}