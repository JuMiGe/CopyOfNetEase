package com.jumige.mobile.news.activity;

import com.jumige.mobile.news.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class SettingActivity extends Activity {
	/*
	 * 设置页面，只是个布局
	 */
	private TextView tv_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		// 设置标题栏
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_setting);
		tv_back = (TextView) findViewById(R.id.tv_setting_back);
		tv_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				finish();

			}
		});
	}

}
