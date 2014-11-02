package com.jumige.mobile.news.activity;

import java.util.ArrayList;
import com.jumige.mobile.news.tools.NotificationTool;
import com.jumige.mobile.news.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.location.GpsStatus.Listener;
import android.media.Image;
import android.sax.TextElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class PopMenu {
	private String[] string = new String[] { "15℃/9℃", "离线", "夜间", "搜索", "扫一扫",
			"设置" };
	private int[] images = new int[] { R.drawable.menu_more_weather,
			R.drawable.menu_more_download, R.drawable.menu_more_theme,
			R.drawable.menu_more_search, R.drawable.menu_more_scan,
			R.drawable.menu_more_setting };
	private ArrayList<String> itemList;
	private Context context;
	private PopupWindow popupWindow;
	private ListView listView;
	private OnItemClickListener listener;
	private ListAdapter adapter;

	public PopMenu(Context context) {
		this.context = context;
		itemList = new ArrayList<String>();
		for (int i = 0; i < string.length; i++) {
			itemList.add(string[i]);
		}
		View view = LayoutInflater.from(context).inflate(
				R.layout.listview_more, null);

		// 设置 listview
		listView = (ListView) view.findViewById(R.id.listview_more);
		adapter = new PopAdapter();
		listView.setAdapter(adapter);
		// listView.setFocusableInTouchMode(true);
		// listView.setFocusable(true);
		// 初始化、设置ListView的点击事件
		initListener();
		listView.setOnItemClickListener(listener);

		popupWindow = new PopupWindow(view, 350, 550);
		// popupWindow = new PopupWindow(view, context.getResources()
		// .getDimensionPixelSize(R.dimen.popmenu_width),
		// LayoutParams.WRAP_CONTENT);

		// 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
	}

	// 初始化ListView的点击事件
	private void initListener() {
		listener = new OnItemClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:
					// 点击“天气” 跳转页面
					Intent intent = new Intent(context, WeatherActivity.class);
					context.startActivity(intent);
					break;
				case 1:
					// 点击“离线”，开始下载离线新闻(按钮Text改变)
					TextView t = (TextView) listView.getChildAt(position)
							.findViewById(R.id.tv_morelist_text);
					int ID_DOWNLOAD_NOTIFICATION = 0;
					int ID_CANCEL_DOWNLOAD = 1;
					NotificationTool n = new NotificationTool();
					if (t.getText().toString().equals("离线")) {
						t.setText("取消离线");
						n.sendMessage(context, ID_DOWNLOAD_NOTIFICATION);
						listView.deferNotifyDataSetChanged();
					} else {
						t.setText("离线");
						n.sendMessage(context, ID_CANCEL_DOWNLOAD);
						listView.deferNotifyDataSetChanged();
					}

					break;
				case 2:
					// 点击“夜间”按钮(涉及到太多图片，这里不做处理)
					TextView t1 = (TextView) listView.getChildAt(position)
							.findViewById(R.id.tv_morelist_text);
					if (t1.getText().toString().equals("夜间")) {
						t1.setText("日间");
						listView.deferNotifyDataSetChanged();
					} else {
						t1.setText("夜间");
						listView.deferNotifyDataSetChanged();
					}

					Toast.makeText(context, "涉及到太多图片，这里不做处理", Toast.LENGTH_LONG)
							.show();
					break;
				case 3:
					//点击“搜索”按钮,跳转页面
					Intent intent1 = new Intent(context,
							SearchNewsActivity.class);
					context.startActivity(intent1);
					break;

				case 4:
					//点击“扫一扫”，（该功能先放一放）
					Toast.makeText(context, "该功能先放一放", Toast.LENGTH_LONG)
					.show();
					break;
				case 5:
					//点击“设置”
					Intent intent2 = new Intent(context,SettingActivity.class);
					context.startActivity(intent2);
					break;
				}

			}
		};
	}

	// 设置菜单项点击监听器
	// public void setOnItemClickListener(OnItemClickListener listener) {
	// listView.setOnItemClickListener(listener);
	// }

	// 批量添加菜单项
	// public void addItems(String[] items) {
	// for (String s : items) {
	// itemList.add(s);
	// }
	// }

	// 单个添加菜单项
	// public void addItem(String item) {
	// itemList.add(item);
	// }

	// 下拉式 弹出 pop菜单 parent 右下角
	public void showAsDropDown(View parent) {
		// 保证尺寸是根据屏幕像素密度来的
		// popupWindow.showAsDropDown(parent, 10,
		//
		// context.getResources().getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width));
		popupWindow.showAsDropDown(parent);
		// 使其聚集
		popupWindow.setFocusable(true);
		// 设置允许在外点击消失
		popupWindow.setOutsideTouchable(true);
		// 刷新状态
		popupWindow.update();
	}

	// 隐藏菜单
	public void dismiss() {
		popupWindow.dismiss();
	}

	// 适配器
	private final class PopAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return itemList.size();
		}

		@Override
		public Object getItem(int position) {
			return itemList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.item_lsit_more, null);
				holder = new ViewHolder();
				convertView.setTag(holder);

				holder.item_Text = (TextView) convertView
						.findViewById(R.id.tv_morelist_text);
				holder.item_Img = (ImageView) convertView
						.findViewById(R.id.img_morelist_img);

			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			holder.item_Text.setText(itemList.get(position));
			holder.item_Img.setImageResource(images[position]);

			return convertView;
		}

		private final class ViewHolder {
			ImageView item_Img;
			TextView item_Text;

		}

	}
}
