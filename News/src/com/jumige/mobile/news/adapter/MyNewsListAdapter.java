package com.jumige.mobile.news.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.jumige.mobile.news.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyNewsListAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<HashMap<String, Object>> mDataList;

	public MyNewsListAdapter(Context context,
			ArrayList<HashMap<String, Object>> dataList) {
		mContext = context;
		mDataList = dataList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDataList.size();
	}

	@Override
	public Object getItem(int position) {
		return mDataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_list_newsviewpager, null);
			holder = new ViewHolder();
			convertView.setTag(holder);

			holder.item_img = (ImageView) convertView
					.findViewById(R.id.img_list_news_img);
			holder.item_title = (TextView) convertView
					.findViewById(R.id.tv_list_news_title);
			holder.item_brieft = (TextView) convertView
					.findViewById(R.id.tv_list_news_digest);
			holder.item_comm = (TextView) convertView
					.findViewById(R.id.tv_list_comm_number);

		} else
			holder = (ViewHolder) convertView.getTag();

		holder.item_img.setImageBitmap((Bitmap) mDataList.get(position).get(
				"img"));
		holder.item_title.setText((CharSequence) mDataList.get(position).get(
				"title"));
		holder.item_brieft.setText((CharSequence) mDataList.get(position).get(
				"digest"));
		holder.item_comm.setText((CharSequence) mDataList.get(position).get(
				"comm"));
		return convertView;
	}

	private final class ViewHolder {
		ImageView item_img;
		TextView item_title;
		TextView item_brieft;
		TextView item_comm;
	}

	public void notifyDataSetChanged0(
			ArrayList<HashMap<String, Object>> threadDataList) {
		this.mDataList = threadDataList;
		this.notifyDataSetChanged();

	}

}
