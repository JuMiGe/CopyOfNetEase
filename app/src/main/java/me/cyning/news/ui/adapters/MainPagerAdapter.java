package me.cyning.news.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import me.cyning.news.ui.NewsDetailFragment;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午6:31
 * Desc  : 主页面的PageAdapter
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {


    String[] title = { "项目一", "项目二", "项目三" };
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new NewsDetailFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
