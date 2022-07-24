package org.kuro.financial.ui;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.kuro.financial.R;
import org.kuro.financial.adapter.BankAdapter;
import org.kuro.financial.base.BaseUIActivity;
import org.kuro.financial.model.entity.Bank;

public class BankActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        initView();
    }

    private void initView() {
        RecyclerView bankList = findViewById(R.id.bank_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        bankList.setLayoutManager(layoutManager);
        bankList.setAdapter(new BankAdapter(Bank.getList(), this));

        ImageView back = findViewById(R.id.bank_back);
        back.setOnClickListener(v -> finish());
    }
}