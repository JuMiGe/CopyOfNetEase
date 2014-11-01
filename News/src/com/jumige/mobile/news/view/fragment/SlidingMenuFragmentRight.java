package com.jumige.mobile.news.view.fragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnCloseListener;
import com.jumige.mobile.news.activity.MainActivity;
import com.jumige.mobile.news.R;

import android.accounts.NetworkErrorException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.Toast;

/*
 * 用来实现右滑的List
 */
public class SlidingMenuFragmentRight extends ListFragment {
	/*
	 * 右滑列表的图片数据
	 */
	private ArrayList<SlidingMenu> listMenuData;
	private SlidingMenu menuRight;
	private SimpleAdapter simpleAdapter;
	private ArrayList<HashMap<String, Object>> dataList;
	private String itemText[] = new String[] { "新闻", "订阅", "图片", "视频", "跟帖",
			"投票" };
	private int itemImg[] = new int[] { R.drawable.list_slidingright_news,
			R.drawable.list_slidingright_read,
			R.drawable.list_slidingright_pic,
			R.drawable.list_slidingright_video,
			R.drawable.list_slidingright_comm,
			R.drawable.list_slidingright_voted };

	/*
	 * 同过newInstance方法，返回一个Bundle封装的Slidmenu对象
	 */
	public static SlidingMenuFragmentRight newInstance(
			ArrayList<SlidingMenu> list) {

		SlidingMenuFragmentRight newFragment = new SlidingMenuFragmentRight();
		Bundle bundle = new Bundle();
		bundle.putSerializable("slidData", list);
		newFragment.setArguments(bundle);
		return newFragment;

	}

	/*
	 * Fragment必须实现的三个回调函数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// 系统在创建Fragment的时候调用这个方法，这里应该初始化相关的组件，一些即便是被暂停或者被停止时依然需要保留的东西.
		super.onCreate(savedInstanceState);
		dataList = new ArrayList<HashMap<String, Object>>();
		/*
		 * 接收传回来的SlidingMenu
		 */
		Bundle args = getArguments();
		if (args != null) {
			listMenuData = (ArrayList<SlidingMenu>) args
					.getSerializable("slidData");

			menuRight = (SlidingMenu) listMenuData.get(0);
		}

		/*
		 * 生成6个数据源
		 */
		for (int i = 0; i < itemText.length; i++) {
			HashMap<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("img", itemImg[i]);
			dataMap.put("text", itemText[i]);
			dataList.add(dataMap);
		}

		simpleAdapter = new SimpleAdapter(getActivity(), dataList,
				R.layout.item_list_slidingright,
				new String[] { "img", "text" }, new int[] {
						R.id.img_slidingmenu_right, R.id.tv_slidingmenu_right });
		this.setListAdapter(simpleAdapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 当第一次绘制Fragment的UI时系统调用这个方法，必须返回一个View，如果Fragment不提供UI也可以返回null。
		// 布局文件fragment_slidingmenu

		return inflater.inflate(R.layout.list_slidingmenuright, container,
				false);

	}

	@Override
	public void onPause() {

		// 当用户离开Fragment时第一个调用这个方法，需要提交一些变化，因为用户很可能不再返回来。
		super.onPause();
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// 右滑菜单的点击监听
		super.onListItemClick(l, v, position, id);
		switch (position) {
		case 0:

			menuRight.showContent(true);
			break;
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;

		default:
			break;
		}
	}
}
