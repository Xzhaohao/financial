package org.kuro.financial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.kuro.financial.R;

public class SignInAdapter extends BaseAdapter {

    private final Context mContext;

    public SignInAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView signInCard;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (position < 2) {
            signInCard = (TextView) inflater.inflate(R.layout.sign_in_card, null);
        } else {
            signInCard = (TextView) inflater.inflate(R.layout.sign_in_not_card, null);
        }
        signInCard.setText(String.valueOf(position + 1));
        return signInCard;
    }
}
