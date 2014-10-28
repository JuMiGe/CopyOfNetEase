package com.jumige.mobile.news.view.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import com.mobile.jumige.news.R;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class ViewPagerFragment extends ListFragment {

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

	public static ViewPagerFragment newInstance(Object content) {
		ViewPagerFragment fragment = new ViewPagerFragment();

		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		 * 生成数据源
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
		return inflater.inflate(R.layout.list_news_viewpager, container, false);

	}

}
