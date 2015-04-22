package me.cyning.news.ui;

import android.os.Bundle;

import com.jumige.android.ui.template.base.BaseFragment;

import me.cyning.news.R;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午6:33
 * Desc  : 类/接口描述
 */
public class NewsDetailFragment  extends BaseFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_news_detail;
    }
}
