package org.kuro.financial.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.kuro.financial.R;
import org.kuro.financial.model.entity.Income;

import java.util.List;

public class IncomeAdapter extends BaseAdapter {

    private List<Income> incomes;
    private final Context context;

    public IncomeAdapter(Context context, List<Income> incomes) {
        this.context = context;
        this.incomes = incomes;
    }

    @Override
    public int getCount() {
        return incomes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "ResourceAsColor"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.income_item, parent, false);
        TextView title = layout.findViewById(R.id.income_item_title);
        TextView type = layout.findViewById(R.id.income_item_type);
        TextView time = layout.findViewById(R.id.income_item_time);
        TextView num = layout.findViewById(R.id.income_item_num);

        Income income = incomes.get(position);
        title.setText(income.getTitle());
        time.setText(income.getTime());
        num.setText(income.getNum());
        if (income.getType() == 1) {
            type.setText("+");
            type.setTextColor(context.getResources().getColor(R.color.green));
            num.setTextColor(context.getResources().getColor(R.color.green));
        } else {
            type.setText("-");
            type.setTextColor(context.getResources().getColor(R.color.project_num_red));
            num.setTextColor(context.getResources().getColor(R.color.project_num_red));
        }

        if (position == incomes.size() - 1) {
            layout.setBackgroundResource(R.color.white);
        }

        return layout;
    }
}
