package org.kuro.financial.fragment;

import android.widget.ImageView;
import android.widget.TextView;

import org.kuro.financial.R;
import org.kuro.financial.base.BaseFragment;
import org.kuro.financial.view.avatar.Avatar;

public class MineFragment extends BaseFragment {

    public MineFragment() {
    }

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        Avatar avatar = mRootView.findViewById(R.id.mine_avatar);
        avatar.setImageUrl(avatar, "https://nlgc-api.oss-cn-shenzhen.aliyuncs.com/avatar/3.png", true);

        TextView property = mRootView.findViewById(R.id.mine_property);
        TextView incomeYesterday = mRootView.findViewById(R.id.mine_income_yesterday);
        TextView incomeCount = mRootView.findViewById(R.id.mine_income_count);
        ImageView eye = mRootView.findViewById(R.id.property_eye);
        eye.setOnClickListener(v -> {
            if (property.getText().toString().equals("****")) {
                property.setText(R.string.mine_balance_num);
                incomeYesterday.setText(R.string.mine_income_yesterday_num);
                incomeCount.setText(R.string.mine_income_count_num);
                eye.setImageResource(R.mipmap.eye);
            } else {
                property.setText(R.string.mine_property_num);
                incomeYesterday.setText(R.string.mine_property_num);
                incomeCount.setText(R.string.mine_property_num);
                eye.setImageResource(R.mipmap.no_eye);
            }
        });
    }

    @Override
    protected void initData() {

    }
}