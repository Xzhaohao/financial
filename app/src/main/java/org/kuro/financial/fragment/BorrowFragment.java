package org.kuro.financial.fragment;

import android.os.Handler;

import org.kuro.financial.R;
import org.kuro.financial.base.BaseFragment;
import org.kuro.financial.view.loading.Loading;

public class BorrowFragment extends BaseFragment {

    private static final int CLOSE_LOADING = 2;

    private Loading loading;

    private final Handler mHandler = new Handler(message -> {
        if (message.what == CLOSE_LOADING) {
            loading.hide();
        }
        return false;
    });

    public BorrowFragment() {
    }

    public static BorrowFragment newInstance() {
        return new BorrowFragment();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_borrow;
    }

    @Override
    protected void initView() {
        loading = new Loading(requireActivity());
        loading.show();
        mHandler.sendEmptyMessageDelayed(CLOSE_LOADING, 2000);
    }

    @Override
    protected void initData() {

    }
}