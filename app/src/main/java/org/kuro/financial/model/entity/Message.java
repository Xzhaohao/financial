package org.kuro.financial.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Message {

    private Integer type; // 1理财，2提现，3借款
    private String typeName;
    private String createTime;
    private String title;
    private String content;

    public Message() {
    }

    public Message(Integer type, String typeName, String createTime, String title, String content) {
        this.type = type;
        this.typeName = typeName;
        this.createTime = createTime;
        this.title = title;
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static List<Message> getList() {
        List<Message> list = new ArrayList<>();
        list.add(new Message(
                1,
                "理财",
                "2022-07-13 10:50",
                "购买金融网90天理财",
                "购买成功，预计2022-07-13到账。")
        );
        list.add(new Message(
                3,
                "借款",
                "2022-07-13 10:50",
                "借款金额¥30000.00元",
                "已成功到账，请至招商银行查询。")
        );
        list.add(new Message(
                2,
                "提现",
                "2022-07-13 10:50",
                "提现余额¥30000.00元",
                "提现至建设银行，预计2022-07-13 15:00前到账。")
        );
        return list;
    }
}
