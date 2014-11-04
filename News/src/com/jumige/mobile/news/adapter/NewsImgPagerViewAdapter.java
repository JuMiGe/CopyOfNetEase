package com.jumige.mobile.news.adapter;

import java.util.List;

import com.jumige.mobile.news.activity.HeadNewsActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class NewsImgPagerViewAdapter extends PagerAdapter {
	/*
	 * 头条新闻显示区域的Adapter
	 * 
	 * 
	 * 定义一个views来存储要显示的View，然后定义一个
	 * ScaleType来规定如果ViewPager是用来显示ImageView的，ImageView应该怎样呈现在ViewPager当中
	 * ，如果调用的构造函数不传ScaleType信息，则默认使用ScaleType.CENTER。
	 */
	private Context mContext;
	private List<View> views = null;
	private ScaleType scaleType;

	public NewsImgPagerViewAdapter(Context context, List<View> views) {
		this(context, views, ScaleType.CENTER);
	}

	public NewsImgPagerViewAdapter(Context context, List<View> views,
			ScaleType scaleType) {
		super();
		this.mContext = context;
		this.views = views;
		this.scaleType = scaleType;
	}

	/*
	 * 根据官方API描述，需要重写PageAdapter的
	 * getCount，isViewFromObject，instantiateItem和destroyItem这四个方法，在
	 * instantiateItem中设置ScaleType，
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(View container, final int position) {
		// TODO Auto-generated method stub
		View view = views.get(position);
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 图片点击事件的监听
				Intent intent = new Intent(mContext, HeadNewsActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.putExtra("position2", position);

				mContext.startActivity(intent);

			}
		});
		ViewPager viewPager = (ViewPager) container;
		if (view instanceof ImageView) {
			((ImageView) view).setScaleType(scaleType);
		}
		viewPager.addView(view, 0);
		return view;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager) container).removeView((View) object);
	}

}
