package com.jumige.mobile.news.view.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.Inflater;

import junit.framework.Test;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnLastItemVisibleListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.jumige.mobile.news.activity.NewsCotentActivity;
import com.jumige.mobile.news.adapter.NewsImgPagerViewMark;
import com.jumige.mobile.news.db.NewsListDataDb;
import com.jumige.mobile.news.tools.ImageCacheTool;
import com.jumige.mobile.news.R;

import android.app.LauncherActivity.ListItem;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;
import android.widget.Toast;

public class ViewPagerFragment extends ListFragment {
	// 定义一个下拉刷新的ListView
	private PullToRefreshListView pullListRefresh;
	private View view;

	/*
	 * 模拟新闻列表的数据
	 */
	private NewsListDataDb nldd;

	private SimpleAdapter simpleAdapter;
	private ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
	private HashMap<String, Object> dataMap;
	private String commentNum[];
	private ImageCacheTool imageCacheTool;

	public static ViewPagerFragment newInstance() {
		ViewPagerFragment fragment = new ViewPagerFragment();
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO Auto-generated method stub
		nldd = new NewsListDataDb(getActivity());
		commentNum = nldd.commentNum;
		/*
		 * 生成数据源
		 */
		imageCacheTool = new ImageCacheTool(getActivity(), 55);
		for (int i = 0; i < commentNum.length; i++) {

			dataMap = new HashMap<String, Object>();
			dataMap.put("img", imageCacheTool.getBitmapFromCacheList(String
					.valueOf("newslistdata/newslist_" + (i + 1) + "_img1.jpg")));
			dataMap.put(
					"title",
					nldd.getNewsTitle("newslistdata/newslist_" + (i + 1)
							+ "_context"));
			dataMap.put(
					"digest",
					nldd.getNewsContext(0, "newslistdata/newslist_" + (i + 1)
							+ "_brieft"));
			dataMap.put("comm", commentNum[i]);
			dataList.add(dataMap);
		}
		simpleAdapter = new SimpleAdapter(getActivity(), dataList,
				R.layout.item_list_newsviewpager, new String[] { "img",
						"title", "digest", "comm" }, new int[] {
						R.id.img_list_news_img, R.id.tv_list_news_title,
						R.id.tv_list_news_digest, R.id.tv_list_comm_number });
		simpleAdapter.setViewBinder(new ViewBinder() {

			@Override
			public boolean setViewValue(View view, Object data,
					String textRepresentation) {
				// 不用此方法，SimpleAdapter无法适配资源图片
				if (view instanceof ImageView && data instanceof Bitmap) {
					ImageView iv = (ImageView) view;
					iv.setImageBitmap((Bitmap) data);
					return true;
				} else
					return false;
			}
		});
		this.setListAdapter(simpleAdapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 创建一个View获得ListView的布局ID。Fragment是不能findViewById的
		view = inflater.inflate(R.layout.list_news_viewpager, container, false);
		// ID声明
		pullListRefresh = (PullToRefreshListView) view
				.findViewById(R.id.pull_refresh_list);

		// 大图滑动区域，添加了一个ViewPager
		pullListRefresh.getRefreshableView().addHeaderView(
				inflater.inflate(R.layout.news_img_viewpager, null));
		// 给个监听，当应该被刷新的时候
		pullListRefresh.setOnRefreshListener(new OnRefreshListener<ListView>() {
			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				// 应该是给个时间的提示
				String label = DateUtils.formatDateTime(getActivity(),
						System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
								| DateUtils.FORMAT_SHOW_DATE
								| DateUtils.FORMAT_ABBREV_ALL);
				// 显示最后更新的时间
				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
				// 模拟下载任务 //任务完成后更新数据
				new GetDataTask().execute();
			}
		});
		// 下拉到最后的监听
		pullListRefresh.onRefreshComplete();
		pullListRefresh
				.setOnLastItemVisibleListener(new OnLastItemVisibleListener() {

					@Override
					public void onLastItemVisible() {
						Toast.makeText(getActivity(), "End of List!",
								Toast.LENGTH_SHORT).show();
					}
				});
		return view;

	}

	// 模拟加载数据
	private class GetDataTask extends AsyncTask<Void, Void, String[]> {

		@Override
		protected void onPostExecute(String[] result) {
			pullListRefresh.onRefreshComplete();

			super.onPostExecute(result);
		}

		@Override
		protected String[] doInBackground(Void... params) {
			// TODO Auto-generated method stub
			return null;
		}

	}
	/*
	 */
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(getActivity(), NewsCotentActivity.class);
		intent.putExtra("position", position);
		getActivity().startActivity(intent);
	}

}
