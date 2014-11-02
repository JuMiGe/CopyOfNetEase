package com.jumige.mobile.news.activity;

import com.jumige.mobile.news.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class SettingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		// 设置标题栏
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_setting);
	}

}
