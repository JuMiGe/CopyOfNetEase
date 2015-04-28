package me.cyning.news.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
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
public class ArticleListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{


    public static final String TAG_CHANNEL = "TAG_CHANNEL";

    private ListView mListView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private NewsAdapters mNewsAdapters;

    private ChanInfo mChanInfo;

    public static ArticleListFragment newInstance(ChanInfo _chanInfo){

        ArticleListFragment mDetailFragment = new ArticleListFragment();
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

        request(0L);
    }

    ArticleListHandler mArticleListHandler = new ArticleListHandler(){
        @Override
        public void onSuccess(ArrayList<ArticleItem> mArticals) {
            mNewsAdapters.setList(mArticals);
            mSwipeRefreshLayout.setRefreshing(false);
        }
    };


    private void request(long pageNO){
        requestInfo(mChanInfo.getTid(),mChanInfo.isHeadLine(),pageNO,mArticleListHandler);
    }
   private void requestInfo(String tid,boolean isHeadLine,long pageNo,ArticleListHandler mHandler){
       mArticleListHandler.setTag(tid);
       NetEaseClient.getInstance().getArticleList(tid,isHeadLine,pageNo,mHandler);

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
        mSwipeRefreshLayout = v(view,R.id.swipeL);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mListView = v(view,R.id.lvArcticals);
        mNewsAdapters = new NewsAdapters(this);

        mListView.setAdapter(mNewsAdapters);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(TAG_CHANNEL,mChanInfo);
    }

    @Override
    public void onRefresh() {
        request(0L);
    }
}
