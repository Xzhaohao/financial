package org.kuro.financial.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Income {

    private String title;
    private String time;
    private Integer type; // 1+，2-
    private String num;

    public Income() {
    }

    public Income(String title, String time, Integer type, String num) {
        this.title = title;
        this.time = time;
        this.type = type;
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public static List<Income> getList() {
        List<Income> list = new ArrayList<>();

        list.add(new Income("充值", "10:50", 1, "40000.00元"));
        list.add(new Income("充值", "10:51", 1, "620.00元"));
        list.add(new Income("提现", "4:51", 2, "5000.00元"));
        list.add(new Income("收益", "8:13", 1, "53.57元"));
        list.add(new Income("借款", "8:43", 2, "10000.00元"));

        return list;
    }
}
