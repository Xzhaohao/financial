package org.kuro.financial.fragment;

import com.google.android.material.button.MaterialButton;

import org.kuro.financial.R;
import org.kuro.financial.base.BaseFragment;
import org.kuro.financial.ui.LoginActivity;

public class HomeFragment extends BaseFragment {

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        MaterialButton button = mRootView.findViewById(R.id.home_login_get);
        button.setOnClickListener(v -> navigateTo(LoginActivity.class));
    }

    @Override
    protected void initData() {

    }
}