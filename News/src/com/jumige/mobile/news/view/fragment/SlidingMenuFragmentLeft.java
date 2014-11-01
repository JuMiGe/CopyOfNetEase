package com.jumige.mobile.news.view.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

import com.jumige.mobile.news.R;
import com.jumige.mobile.news.activity.LoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SlidingMenuFragmentLeft extends ListFragment {

	private TextView tv_login;
	private View v;
	private OnClickListener listener;
	/*
	 * 左滑的数据加载
	 */
	private SimpleAdapter simpleAdapter;
	private ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();

	private int itemImg1[] = new int[] { R.drawable.slidingleft_player,
			R.drawable.slidingleft_activity, R.drawable.slidingleft_app,
			R.drawable.slidingleft_game };
	private int itemImg2[] = new int[] { R.drawable.slidingleft_you };
	private String itemText1[] = new String[] { "商城", "活动", "应用", "游戏" };
	private String itemText2[] = new String[] { "能赚能花,土豪当家!", "开心大转盘  新闻玩起来",
			"快创金币富豪传奇", "一大波手游福利礼包来袭" };

	/*
	 * Fragment必须实现的三个回调函数
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// 系统在创建Fragment的时候调用这个方法，这里应该初始化相关的组件，一些即便是被暂停或者被停止时依然需要保留的东西.
		super.onCreate(savedInstanceState);

		// 生成四个数据源
		for (int i = 0; i < itemImg1.length; i++) {
			HashMap<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("img1", itemImg1[i]);
			dataMap.put("txt1", itemText1[i]);
			dataMap.put("txt2", itemText2[i]);
			dataMap.put("img2", itemImg2[0]);
			dataList.add(dataMap);
		}
		simpleAdapter = new SimpleAdapter(getActivity(), dataList,
				R.layout.item_list_slidingleft, new String[] { "img1", "txt1",
						"txt2", "img2" }, new int[] {
						R.id.img_slidingleft_img1, R.id.tv_slidingleft_text1,
						R.id.tv_slidingleft_text2, R.id.img_slidingleft_img2 });

		this.setListAdapter(simpleAdapter);
	}

	private void initListener() {
		listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.tv_slidingright_login:
					// 点击登录，跳转到登录界面
					Intent intent = new Intent(getActivity(),
							LoginActivity.class);
					getActivity().startActivity(intent);
					break;

				case R.id.tv_slidingright_score:
					// 点击“积分”
					Toast.makeText(getActivity(), "等。。。。。", Toast.LENGTH_LONG)
							.show();
					break;
				case R.id.tv_slidingleft_gohead:
					Toast.makeText(getActivity(), "没实现、、、没实现",
							Toast.LENGTH_LONG).show();
					break;
				case R.id.tv_slidingleft_gocover:
					Toast.makeText(getActivity(), "没实现、、、没实现",
							Toast.LENGTH_LONG).show();
					break;
				case R.id.tv_slidingleft_email:
					Toast.makeText(getActivity(), "没实现、、、没实现",
							Toast.LENGTH_LONG).show();
					break;
				case R.id.tv_slidingleft_message:
					Toast.makeText(getActivity(), "没实现、、、没实现",
							Toast.LENGTH_LONG).show();
					break;
				case R.id.tv_slidingleft_caipiao:
					Toast.makeText(getActivity(), "没实现、、、没实现",
							Toast.LENGTH_LONG).show();
					break;
				}

			}
		};
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 当第一次绘制Fragment的UI时系统调用这个方法，必须返回一个View，如果Fragment不提供UI也可以返回null。
		// 布局文件fragment_slidingmenu
		v = inflater.inflate(R.layout.fragment_slidingmenuleft, container,
				false);
		// 初始化监听器
		initListener();
		tv_login = (TextView) v.findViewById(R.id.tv_slidingright_login);
		tv_login.setOnClickListener(listener);
		return v;
	}

	@Override
	public void onPause() {
		// 当用户离开Fragment时第一个调用这个方法，需要提交一些变化，因为用户很可能不再返回来。
		super.onPause();
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		switch (position) {
		case 0:
			Toast.makeText(getActivity(), "该功能还未实现", Toast.LENGTH_LONG).show();
			break;
		case 1:
			Toast.makeText(getActivity(), "该功能还未实现", Toast.LENGTH_LONG).show();
			break;
		case 2:
			Toast.makeText(getActivity(), "该功能还未实现", Toast.LENGTH_LONG).show();
			break;
		case 3:
			Toast.makeText(getActivity(), "该功能还未实现", Toast.LENGTH_LONG).show();
			break;
		default:
			break;
		}
	}
}
