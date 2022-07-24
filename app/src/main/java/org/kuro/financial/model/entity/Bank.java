package org.kuro.financial.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private String cardNum;

    public Bank() {
    }

    public Bank(String name, String cardNum) {
        this.name = name;
        this.cardNum = cardNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public static List<Bank> getList() {
        List<Bank> list = new ArrayList<>();

        list.add(new Bank("招商银行", "6122 **** **** 7666"));
        list.add(new Bank("建设银行", "6466 **** **** 5728"));
        list.add(new Bank("中国银行", "6466 **** **** 5728"));
        list.add(new Bank("交通银行", "6466 **** **** 5728"));

        return list;
    }
}
