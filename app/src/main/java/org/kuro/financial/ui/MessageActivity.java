package org.kuro.financial.ui;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.kuro.financial.R;
import org.kuro.financial.adapter.MessageAdapter;
import org.kuro.financial.base.BaseUIActivity;
import org.kuro.financial.model.entity.Message;

public class MessageActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        initView();
    }


    private void initView() {
        RecyclerView messageList = findViewById(R.id.message_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        messageList.setLayoutManager(layoutManager);
        messageList.setAdapter(new MessageAdapter(Message.getList(), this));
    }
}