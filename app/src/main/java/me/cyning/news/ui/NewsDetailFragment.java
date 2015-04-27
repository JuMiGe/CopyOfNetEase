package me.cyning.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import com.jumige.android.ui.template.base.BaseFragment;

import java.util.ArrayList;

import cyning.me.libnerss.rss.Channel.ArticleItem;
import cyning.me.libnerss.rss.Channel.ChanInfo;
import cyning.me.libnerss.rss.Channel.handlers.ArticleListHandler;
import cyning.me.libnerss.rss.NetEaseClient;
import me.cyning.news.R;
import me.cyning.news.ui.adapters.NewsAdapters;

/**
 * Author: cyning
 * Date  : 2015.04.22
 * Time  : 下午6:33
 * Desc  : 类/接口描述
 */
public class NewsDetailFragment  extends BaseFragment{


    public static final String TAG_CHANNEL = "TAG_CHANNEL";

    private ListView mListView;
    private NewsAdapters mNewsAdapters;

    private ChanInfo mChanInfo;

    public static NewsDetailFragment newInstance(ChanInfo _chanInfo){

        NewsDetailFragment mDetailFragment = new NewsDetailFragment();
        Bundle mBundle = new Bundle();
        mBundle.putParcelable(TAG_CHANNEL,_chanInfo);
        mDetailFragment.setArguments(mBundle);
        return  mDetailFragment;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null && getArguments().getParcelable(TAG_CHANNEL) != null){
            mChanInfo = savedInstanceState.getParcelable(TAG_CHANNEL);
        }else{
            mChanInfo = getArguments().getParcelable(TAG_CHANNEL);
        }

        NetEaseClient.getInstance().getArticleList(mChanInfo.getTid(),false,0L,new ArticleListHandler(mChanInfo.getTid()){
            @Override
            public void onSuccess(ArrayList<ArticleItem> mArticals) {
                mNewsAdapters.setList(mArticals);
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_news_detail;
    }

    @Override
    protected void setupViews(View view) {
        super.setupViews(view);

        mListView = v(view,R.id.lvArcticals);
        mNewsAdapters = new NewsAdapters(this);

        mListView.setAdapter(mNewsAdapters);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(TAG_CHANNEL,mChanInfo);
    }
}
