package org.kuro.financial.fragment;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.kuro.financial.R;
import org.kuro.financial.base.BaseFragment;
import org.kuro.financial.ui.BankActivity;
import org.kuro.financial.ui.IncomeActivity;
import org.kuro.financial.ui.MessageActivity;
import org.kuro.financial.ui.SignInActivity;
import org.kuro.financial.ui.WithdrawActivity;
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
        // 头像
        Avatar avatar = mRootView.findViewById(R.id.mine_avatar);
        avatar.setImageUrl(avatar, "https://nlgc-api.oss-cn-shenzhen.aliyuncs.com/avatar/3.png", true);

        // 显示与隐藏资产
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

        // 跳转签到页面
        TextView signIn = mRootView.findViewById(R.id.mine_sign_in);
        signIn.setOnClickListener(v -> navigateTo(SignInActivity.class));

        // 跳转消息页面
        RelativeLayout messageRow = mRootView.findViewById(R.id.message_row);
        messageRow.setOnClickListener(v -> navigateTo(MessageActivity.class));

        // 跳转我的银行卡页面
        TextView mineBank = mRootView.findViewById(R.id.mine_bank);
        mineBank.setOnClickListener(v -> navigateTo(BankActivity.class));

        // 跳转提现页面
        TextView withdrawDeposit = mRootView.findViewById(R.id.mine_withdraw_deposit);
        withdrawDeposit.setOnClickListener(v -> navigateTo(WithdrawActivity.class));

        // 跳转收支明细页面
        RelativeLayout incomeRow = mRootView.findViewById(R.id.income_row);
        incomeRow.setOnClickListener(v -> navigateTo(IncomeActivity.class));
    }

    @Override
    protected void initData() {

    }
}