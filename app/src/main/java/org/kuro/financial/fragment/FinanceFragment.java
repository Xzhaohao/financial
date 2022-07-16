package org.kuro.financial.fragment;

import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.kuro.financial.R;
import org.kuro.financial.base.BaseFragment;
import org.kuro.financial.utils.DisplayUtil;
import org.kuro.financial.view.progress.CircleProgress;
import org.kuro.financial.view.swipe.Swipe;
import org.kuro.financial.view.swipe.entity.LocalImageInfo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FinanceFragment extends BaseFragment {

    private Swipe swiper;

    public FinanceFragment() {
    }

    public static FinanceFragment newInstance() {
        return new FinanceFragment();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_finance;
    }

    @Override
    protected void initView() {
        //获取控件
        swiper = mRootView.findViewById(R.id.swipe);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, DisplayUtil.getScreenWidth(requireActivity()) / 2
        );
        swiper.setLayoutParams(layoutParams);

        initSwipe(swiper);

        CircleProgress circleProgress = mRootView.findViewById(R.id.finance_progress);
        circleProgress.setProgressNum(75, 2000);
        TextView progressText = mRootView.findViewById(R.id.finance_progress_text);
        circleProgress.setTextView(progressText);
        circleProgress.setOnAnimationListener(new CircleProgress.OnAnimationListener() {
            @Override
            public String howToChangeText(float interpolatedTime, float updateNum, float maxNum) {
                DecimalFormat decimalFormat = new DecimalFormat("0");
                return decimalFormat.format(interpolatedTime * updateNum / maxNum * 100) + "%";
            }

            @Override
            public void howTiChangeProgressColor(Paint paint, float interpolatedTime, float updateNum, float maxNum) {

            }
        });
    }

    @Override
    protected void initData() {
        initLocalImage();
    }


    // 初始化Swipe
    private void initSwipe(Swipe swiper) {
        swiper.loadImage((banner, model, view, position) -> {
            // 加载本地图片展示
            ((ImageView) view).setImageResource(((LocalImageInfo) model).getSwipeUrl());
        });
    }


    // 加载本地图片
    private void initLocalImage() {
        List<LocalImageInfo> data = new ArrayList<>();
        data.add(new LocalImageInfo(R.mipmap.swipe_item));
        data.add(new LocalImageInfo(R.mipmap.swipe_item));
        data.add(new LocalImageInfo(R.mipmap.swipe_item));
        swiper.setBannerData(data);
        swiper.setAutoPlayAble(true);
    }
}