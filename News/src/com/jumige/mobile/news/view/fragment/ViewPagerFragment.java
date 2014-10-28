package com.jumige.mobile.news.view.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.Test;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnLastItemVisibleListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.mobile.jumige.news.R;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ViewPagerFragment extends ListFragment {
	// 定义一个下拉刷新的ListView
	private PullToRefreshListView pullListRefresh;
	private View view;

	/*
	 * 模拟新闻列表的数据
	 */

	private SimpleAdapter simpleAdapter;
	private ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
	private HashMap<String, Object> dataMap;
	private int newsImage[] = new int[] { R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher, };
	private String newsTitle[] = new String[] { "新闻的简要标题" };
	private String newsDigest[] = new String[] { "新闻的简要叙述" };
	private String commentNum[] = new String[] { "跟帖数量" };

	public static ViewPagerFragment newInstance() {
		ViewPagerFragment fragment = new ViewPagerFragment();

		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/*
		 * / 生成数据源
		 */
		for (int i = 0; i < newsImage.length; i++) {
			dataMap = new HashMap<String, Object>();
			dataMap.put("img", newsImage[i]);
			dataMap.put("title", newsTitle[0]);
			dataMap.put("digest", newsDigest[0]);
			dataMap.put("comm", commentNum[0]);
			dataList.add(dataMap);
		}

		simpleAdapter = new SimpleAdapter(getActivity(), dataList,
				R.layout.item_list_newsviewpager, new String[] { "img",
						"title", "digest", "comm" }, new int[] {
						R.id.img_list_news_img, R.id.tv_list_news_title,
						R.id.tv_list_news_digest, R.id.tv_list_comm_number });

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
				new GetDataTask();
				onPostExecute();
			}
		});
		// 下拉到最后的监听
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
		protected String[] doInBackground(Void... params) {
			// Simulates a background job.
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			return new String[] { "a" };
		}

	}

	/*
	 * 重写的ListActivity的更新数据的方法。暂时无法完善
	 */
	protected void onPostExecute() {
		// mListItems.addFirst("Added after refresh...");
		// mAdapter.notifyDataSetChanged();

		// Call onRefreshComplete when the list has been refreshed.
		pullListRefresh.onRefreshComplete();

		// super.onPostExecute(result);
	}

}
