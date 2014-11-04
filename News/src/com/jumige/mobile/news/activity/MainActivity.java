package com.jumige.mobile.news.activity;

import com.jumige.mobile.news.adapter.MenuLeftAdapter;
import com.jumige.mobile.news.adapter.MenuRightAdapter;
import com.jumige.mobile.news.db.NewsTypeDataDb;
import com.jumige.mobile.news.view.fragment.ViewPagerFragment;
import com.jumige.mobile.news.R;
import com.viewpagerindicator.TabPageIndicator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	private MenuLeftAdapter menuLeftAdapter;
	private MenuRightAdapter menuRightAdapter;
	private DrawerLayout mDrawer_layout;// DrawerLayout容器
	private RelativeLayout mMenu_layout_left;// 左边Menu抽屉
	private LinearLayout mMenu_layout_right;// 右边Menu抽屉
	private ListView menu_listview_left;
	private ListView menu_listview_right;
	private NewsTypeDataDb newsTypeDataDb;
	private ImageView img_title_left;
	private ImageView img_title_right;
	private ImageView img_title_user;
	private OnClickListener listener;
	private TextView tv_menu_right_login;
	private TextView tv_menu_right_score;
	private TextView tv_menu_right_message;
	private TextView tv_menu_right_email;
	private TextView tv_menu_right_gohead;
	private TextView tv_menu_right_gocover;
	private TextView tv_menu_right_caipiao;
	private ActionBar actionBar;
	// 下拉菜单
	private PopMenu popMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 设置标题栏
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_main);

		// findViewById
		initFindViewById();
		// 滑动菜单
		initDrawerLayout();
		// 初始化栏目数据
		newsTypeDataDb = new NewsTypeDataDb();
		newsTypeDataDb.initNewsType();
		// ViewPager的代码块(对ViewPager进行适配，初始化其Tab栏)
		initViewPager();
		// 初始化监听器
		initListener();
		popMenu = new PopMenu(MainActivity.this);
		IntentFilter filter = new IntentFilter(LoginActivity.action); 
		//等待登录成功返回的消息
		registerReceiver(broadcastReceiver, filter);
		
	}
	private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// 接收登录成功传回来的信息
			tv_menu_right_login.setText(intent.getExtras()
					.getString("data"));

		}
	};

	protected void onDestroy() {
		unregisterReceiver(broadcastReceiver);
	};

	// 初始化监听器
	private void initListener() {

		listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.img_title_left:

					// 点击“网易”标题，弹出左边的滑动菜单
					if (mDrawer_layout.isDrawerOpen(Gravity.LEFT)) {

						mDrawer_layout.closeDrawers();
					} else {
						mDrawer_layout.openDrawer(Gravity.LEFT);
					}

					break;
				case R.id.img_title_user:
					// 点击“用户”图标，弹出右滑动菜单
					if (mDrawer_layout.isDrawerOpen(Gravity.RIGHT)) {
						mDrawer_layout.closeDrawer(Gravity.RIGHT);
					} else {
						mDrawer_layout.openDrawer(Gravity.RIGHT);
					}

					break;
				case R.id.img_title_right:

					popMenu.showAsDropDown(v);
					// 菜单项点击监听器
					break;

				case R.id.tv_menu_right_login:
					if (tv_menu_right_login.getText().toString().equals("立即登录")) {
						Intent intent = new Intent(MainActivity.this,
								LoginActivity.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						getApplication().startActivity(intent);
					} else {
						Toast.makeText(getApplicationContext(), "该功能尚未实现",
								Toast.LENGTH_LONG).show();
					}

					break;
				case R.id.tv_menu_right__score:
					Toast.makeText(getApplicationContext(), "该功能尚未实现",
							Toast.LENGTH_LONG).show();
					break;
				case R.id.tv_menu_right__message:
					Toast.makeText(getApplicationContext(), "该功能尚未实现",
							Toast.LENGTH_LONG).show();
					break;
				case R.id.tv_menu_right__gohead:
					Toast.makeText(getApplicationContext(), "该功能尚未实现",
							Toast.LENGTH_LONG).show();
					break;
				case R.id.tv_menu_right__gocover:
					Toast.makeText(getApplicationContext(), "该功能尚未实现",
							Toast.LENGTH_LONG).show();
					break;
				case R.id.tv_menu_right__caipiao:
					Toast.makeText(getApplicationContext(), "该功能尚未实现",
							Toast.LENGTH_LONG).show();
					break;
				case R.id.tv_menu_right__email:
					Toast.makeText(getApplicationContext(), "该功能尚未实现",
							Toast.LENGTH_LONG).show();
					break;

				}

			}
		};
		img_title_left.setOnClickListener(listener);
		img_title_user.setOnClickListener(listener);
		img_title_right.setOnClickListener(listener);
		tv_menu_right_login.setOnClickListener(listener);
		tv_menu_right_score.setOnClickListener(listener);
		tv_menu_right_message.setOnClickListener(listener);
		tv_menu_right_email.setOnClickListener(listener);
		tv_menu_right_gocover.setOnClickListener(listener);
		tv_menu_right_gohead.setOnClickListener(listener);
		tv_menu_right_caipiao.setOnClickListener(listener);

	}

	// findViewById
	private void initFindViewById() {
		// 更多菜单的初始化

		img_title_left = (ImageView) findViewById(R.id.img_title_left);
		img_title_right = (ImageView) findViewById(R.id.img_title_right);
		img_title_user = (ImageView) findViewById(R.id.img_title_user);
		tv_menu_right_login = (TextView) findViewById(R.id.tv_menu_right_login);
		tv_menu_right_score = (TextView) findViewById(R.id.tv_menu_right__score);
		tv_menu_right_message = (TextView) findViewById(R.id.tv_menu_right__message);
		tv_menu_right_email = (TextView) findViewById(R.id.tv_menu_right__email);
		tv_menu_right_gohead = (TextView) findViewById(R.id.tv_menu_right__gohead);
		tv_menu_right_gocover = (TextView) findViewById(R.id.tv_menu_right__gocover);
		tv_menu_right_caipiao = (TextView) findViewById(R.id.tv_menu_right__caipiao);
	}

	/*
	 * 初始化滑动菜单
	 */
	private void initDrawerLayout() {

		mDrawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mMenu_layout_left = (RelativeLayout) findViewById(R.id.menu_layout_left);
		mMenu_layout_right = (LinearLayout) findViewById(R.id.menu_layout_right);
		menu_listview_left = (ListView) findViewById(R.id.menu_listView_left);
		menu_listview_right = (ListView) findViewById(R.id.menu_listView_right);
		menuLeftAdapter = new MenuLeftAdapter(getApplicationContext());
		menuRightAdapter = new MenuRightAdapter(getApplicationContext());
		menu_listview_left.setAdapter(menuLeftAdapter.getAdapter(
				menu_listview_left, mDrawer_layout));
		menu_listview_right.setAdapter(menuRightAdapter
				.getAdapter(menu_listview_right));

	}

	@Override
	public void onBackPressed() {
		// 点击返回键关闭滑动菜单
		if (mDrawer_layout.isActivated()) {
			mDrawer_layout.closeDrawers();
		} else {
			super.onBackPressed();
		}

	}

	// ViewPager的代码块(对ViewPager进行适配，初始化其Tab栏)
	private void initViewPager() {
		FragmentPagerAdapter adapter = new GoogleMusicAdapter(
				getSupportFragmentManager());

		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);

		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
	}

	/*
	 * ViewPager复写的方法
	 */
	class GoogleMusicAdapter extends FragmentPagerAdapter {
		public GoogleMusicAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return ViewPagerFragment.newInstance();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return newsTypeDataDb.onNewsTypeMap.get(position).toUpperCase();

		}

		@Override
		public int getCount() {
			return newsTypeDataDb.onNewsTypeMap.size();
		}
	}

}
