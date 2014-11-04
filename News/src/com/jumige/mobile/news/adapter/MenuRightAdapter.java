package com.jumige.mobile.news.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.jumige.mobile.news.R;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MenuRightAdapter {
	/*
	 * 右滑列表的数据适配
	 */
	private Context mContext;
	private ListView menu_listView_right;
	private OnItemClickListener listener;
	private SimpleAdapter simpleAdapter;
	private ArrayList<HashMap<String, Object>> dataList;

	private int itemImg1[] = new int[] { R.drawable.slidingleft_player,
			R.drawable.slidingleft_activity, R.drawable.slidingleft_app,
			R.drawable.slidingleft_game };
	private int itemImg2[] = new int[] { R.drawable.slidingleft_you };
	private String itemText1[] = new String[] { "商城", "活动", "应用", "游戏" };
	private String itemText2[] = new String[] { "能赚能花,土豪当家!", "开心大转盘  新闻玩起来",
			"快创金币富豪传奇", "一大波手游福利礼包来袭" };

	public MenuRightAdapter(Context context) {
		mContext = context;
	}

	public SimpleAdapter getAdapter(ListView listView) {
		menu_listView_right = listView;
		initListener();

		// 生成四个数据源
		dataList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < itemImg1.length; i++) {
			HashMap<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("img1", itemImg1[i]);
			dataMap.put("txt1", itemText1[i]);
			dataMap.put("txt2", itemText2[i]);
			dataMap.put("img2", itemImg2[0]);
			dataList.add(dataMap);
		}
		return simpleAdapter = new SimpleAdapter(mContext, dataList,
				R.layout.item_list_slidingleft, new String[] { "img1", "txt1",
						"txt2", "img2" }, new int[] {
						R.id.img_slidingleft_img1, R.id.tv_slidingleft_text1,
						R.id.tv_slidingleft_text2, R.id.img_slidingleft_img2 });
	}

	private void initListener() {
		listener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:
					Toast.makeText(mContext, "该功能尚未实现", Toast.LENGTH_LONG)
							.show();
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
				}

			}
		};

		menu_listView_right.setOnItemClickListener(listener);

	}
}
