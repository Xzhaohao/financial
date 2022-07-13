package org.kuro.financial.fragment;

import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

import org.kuro.financial.R;
import org.kuro.financial.base.BaseFragment;
import org.kuro.financial.ui.LoginActivity;

public class HomeFragment extends BaseFragment {

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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