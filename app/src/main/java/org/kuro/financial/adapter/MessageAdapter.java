package org.kuro.financial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.kuro.financial.R;
import org.kuro.financial.model.entity.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    List<Message> messageList;
    private final Context context;

    public MessageAdapter(List<Message> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageAdapter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView view = (CardView) LayoutInflater.from(context).inflate(R.layout.message_card_item, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MessageViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.title.setText(message.getTitle());
        holder.content.setText(message.getContent());
        holder.time.setText(message.getCreateTime());
        holder.type.setText(message.getTypeName());

        // 设置图标
        switch (message.getType()) {
            case 1:
                holder.typeImage.setImageResource(R.mipmap.insurance);
                break;
            case 2:
                holder.typeImage.setImageResource(R.mipmap.mine_borrow_money);
                break;
            case 3:
                holder.typeImage.setImageResource(R.drawable.borrow_money_unselected);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }


    static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView type;
        TextView time;
        TextView title;
        TextView content;
        ImageView typeImage;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.message_type_name);
            time = itemView.findViewById(R.id.message_time);
            title = itemView.findViewById(R.id.message_title);
            content = itemView.findViewById(R.id.message_content);
            typeImage = itemView.findViewById(R.id.message_type_image);
        }
    }
}
