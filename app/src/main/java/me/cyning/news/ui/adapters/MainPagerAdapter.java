package me.cyning.news.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jumige.android.common.utils.CollectionUtil;

import java.util.ArrayList;

import cyning.me.libnerss.rss.Channel.ChanInfo;
import me.cyning.news.ui.NewsDetailFragment;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午6:31
 * Desc  : 主页面的PageAdapter
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<ChanInfo> mChanInfos;


    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return  NewsDetailFragment.newInstance(mChanInfos.get(position));
    }

    @Override
    public int getCount() {
        return !CollectionUtil.isListMoreOne(mChanInfos)?0:mChanInfos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mChanInfos.get(position).getTname();
    }

    public void setChanInfos(ArrayList<ChanInfo> _chanInfos) {
        mChanInfos = _chanInfos;
    }
}
