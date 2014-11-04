package com.jumige.mobile.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.jumige.mobile.news.R;
import com.jumige.mobile.news.db.NewsHeadDataDb;
import com.jumige.mobile.news.tools.ImageCacheTool;
import com.jumige.mobile.news.view.fragment.HeadNewsPagerFragment;

public class HeadNewsActivity extends FragmentActivity {
	/*
	 * 点击大图，显示头条新闻的图片
	 */
	private ImageCacheTool imageCacheTool;//图片缓存器
	private Intent intent;
	private int iPosition;//上一层传过来的
	private ImageView img_back;
	private TextView tv_title;
	private NewsHeadDataDb nhdd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_headnews);

		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_headnews);
		nhdd = new NewsHeadDataDb(getApplicationContext());
		img_back = (ImageView) findViewById(R.id.img_headnews_back);
		tv_title = (TextView) findViewById(R.id.tv_headnews_title);

		img_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 点击返回
				finish();
			}
		});
		intent = getIntent();
		iPosition = (Integer) intent.getExtras().get("position2");
		tv_title.setText(nhdd.getNewsTitle("newsheaddata/newshead_"
				+ (iPosition + 1) + "_cotext.txt"));
		imageCacheTool = new ImageCacheTool(getApplicationContext(), 400);
		FragmentPagerAdapter adapter = new GoogleMusicAdapter(
				getSupportFragmentManager());

		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setOffscreenPageLimit(1);
		pager.setAdapter(adapter);
	}

	/*
	 * ViewPager复写的方法//有待研究
	 */
	class GoogleMusicAdapter extends FragmentPagerAdapter {
		public GoogleMusicAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return HeadNewsPagerFragment.newInstance(imageCacheTool
					.getBitmapFromCacheHead("newsheaddata/newshead_"
							+ (iPosition + 1) + "_img" + (1 + position)
							+ ".jpg"));
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return null;

		}

		@Override
		public int getCount() {
			return 3;
		}
	}
}
