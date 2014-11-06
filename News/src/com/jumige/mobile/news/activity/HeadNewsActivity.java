package com.jumige.mobile.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
	private boolean isFirst = true;
	private Intent intent;
	private int iPosition;// 上一层传过来的
	private ImageView img_back;
	private TextView tv_title;
	private NewsHeadDataDb nhdd;
	private ImageCacheTool imageCacheTool;
	private FragmentPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_headnews);
		imageCacheTool = new ImageCacheTool(getApplicationContext(), 300);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_headnews);
		adapter = new GoogleMusicAdapter(getSupportFragmentManager());
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);
		intent = getIntent();
		iPosition = (Integer) intent.getExtras().get("position2");
		nhdd = new NewsHeadDataDb(getApplicationContext());
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				String string = nhdd.getNewsTitle("newsheaddata/newshead_"
						+ (iPosition + 1) + "_cotext.txt");
				handler.obtainMessage(0, string).sendToTarget();

			}
		});
		thread.start();

		img_back = (ImageView) findViewById(R.id.img_headnews_back);
		tv_title = (TextView) findViewById(R.id.tv_headnews_title);

		img_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 点击返回
				finish();
			}
		});

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
			System.out.println(position);
			if (isFirst) {
				isFirst = false;
				return HeadNewsPagerFragment.newInstance(imageCacheTool
						.getBitmapFromCacheHead("newsheaddata/newshead_"
								+ (iPosition + 1) + "_img" + (position+1)
								+ ".jpg"));
			}
				
			return HeadNewsPagerFragment.newInstance(imageCacheTool
					.getBitmapFromCacheHead("newsheaddata/newshead_"
							+ (iPosition + 1) + "_img" + (position)
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

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			super.handleMessage(msg);

			tv_title.setText((CharSequence) msg.obj);

		}

	};
}
