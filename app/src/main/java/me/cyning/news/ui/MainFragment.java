package me.cyning.news.ui;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.jumige.android.ui.template.base.BaseFragment;

import me.cyning.news.R;
import me.cyning.news.ui.adapters.MainPagerAdapter;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午6:00
 * Desc  : 首页的内容Fragment
 */
public class MainFragment extends BaseFragment {

    private PagerSlidingTabStrip mTabStrip;
    private ViewPager            mViewPager;
    private MainPagerAdapter     mPagerAdapter;

    public static MainFragment newInstance(){
        MainFragment mMainFragment = new MainFragment();
        return  mMainFragment;
    }

    public MainFragment() {
    }

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void setupViews(View view) {
        mViewPager   = v(view,R.id.vpContent);
        mTabStrip    = v(view,R.id.tabs);
        mPagerAdapter = new MainPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mTabStrip.setViewPager(mViewPager);
    }




}
