package org.kuro.financial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.kuro.financial.R;
import org.kuro.financial.model.entity.Bank;

import java.util.List;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder> {

    List<Bank> bankList;
    private final Context context;

    public BankAdapter(List<Bank> bankList, Context context) {
        this.bankList = bankList;
        this.context = context;
    }

    @NonNull
    @Override
    public BankAdapter.BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.bank_card_item, parent, false);
        return new BankAdapter.BankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankAdapter.BankViewHolder holder, int position) {
        Bank bank = bankList.get(position);
        holder.bankName.setText(bank.getName());
        holder.bankCardNum.setText(bank.getCardNum());

        // 设置背景
        switch (bank.getName()) {
            case "招商银行":
                holder.bankWrap.setBackgroundResource(R.mipmap.bank_card_bg1);
                break;
            case "建设银行":
                holder.bankWrap.setBackgroundResource(R.mipmap.bank_card_bg2);
                break;
            case "中国银行":
                holder.bankWrap.setBackgroundResource(R.mipmap.bank_card_bg3);
                break;
            case "交通银行":
                holder.bankWrap.setBackgroundResource(R.mipmap.bank_card_bg4);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return bankList.size();
    }

    static class BankViewHolder extends RecyclerView.ViewHolder {
        TextView bankName;
        TextView bankCardNum;
        LinearLayout bankWrap;

        public BankViewHolder(@NonNull View itemView) {
            super(itemView);
            bankName = itemView.findViewById(R.id.bank_name);
            bankCardNum = itemView.findViewById(R.id.bank_card_num);
            bankWrap = itemView.findViewById(R.id.bank_wrap);
        }
    }
}
