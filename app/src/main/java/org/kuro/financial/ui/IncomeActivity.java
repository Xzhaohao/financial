package org.kuro.financial.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import org.kuro.financial.R;
import org.kuro.financial.adapter.IncomeAdapter;
import org.kuro.financial.base.BaseUIActivity;
import org.kuro.financial.model.entity.Income;

public class IncomeActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        initView();
    }


    private void initView() {
        ImageView back = findViewById(R.id.income_back);
        back.setOnClickListener(v -> finish());

        ListView incomeList = findViewById(R.id.income_list);
        incomeList.setAdapter(new IncomeAdapter(this, Income.getList()));
    }
}