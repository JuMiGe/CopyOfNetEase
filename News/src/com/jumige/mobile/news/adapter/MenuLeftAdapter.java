package com.jumige.mobile.news.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.jumige.mobile.news.R;

public class MenuLeftAdapter {
	/*
	 * 右滑列表的图片数据
	 */
	public SimpleAdapter simpleAdapter;
	private Context mContext;
	private OnItemClickListener listener;
	private DrawerLayout mDrawerLayout;
	private ListView menu_listView_left;
	private ArrayList<HashMap<String, Object>> dataList;
	private String itemText[] = new String[] { "新闻", "订阅", "图片", "视频", "跟帖",
			"投票" };
	private int itemImg[] = new int[] { R.drawable.list_slidingright_news,
			R.drawable.list_slidingright_read,
			R.drawable.list_slidingright_pic,
			R.drawable.list_slidingright_video,
			R.drawable.list_slidingright_comm,
			R.drawable.list_slidingright_voted };

	public MenuLeftAdapter(Context context) {
		mContext = context;
	}

	public SimpleAdapter getAdapter(ListView listView, DrawerLayout drawerLayout) {
		/*
		 * 生成6个数据源
		 */
		// 初始化监听
		menu_listView_left = listView;
		mDrawerLayout = drawerLayout;
		initListener();

		dataList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < itemText.length; i++) {
			HashMap<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("img", itemImg[i]);
			dataMap.put("text", itemText[i]);
			dataList.add(dataMap);
		}
		menu_listView_left.setOnItemClickListener(listener);
		return simpleAdapter = new SimpleAdapter(mContext, dataList,
				R.layout.item_list_slidingright,
				new String[] { "img", "text" }, new int[] {
						R.id.img_slidingmenu_right, R.id.tv_slidingmenu_right });
	}

	private void initListener() {
		listener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					mDrawerLayout.closeDrawer(Gravity.LEFT);
					break;
				case 1:
					Toast.makeText(mContext, "该功能尚未实现", Toast.LENGTH_LONG)
							.show();
					break;
				case 2:
					Toast.makeText(mContext, "该功能尚未实现", Toast.LENGTH_LONG)
							.show();
					break;
				case 3:
					Toast.makeText(mContext, "该功能尚未实现", Toast.LENGTH_LONG)
							.show();
					break;
				case 4:
					Toast.makeText(mContext, "该功能尚未实现", Toast.LENGTH_LONG)
							.show();
					break;

				case 5:
					Toast.makeText(mContext, "该功能尚未实现", Toast.LENGTH_LONG)
							.show();

					break;
				}
			}
		};
	}

}
