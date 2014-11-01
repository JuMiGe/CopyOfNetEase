package com.jumige.mobile.news.activity;

import com.jumige.mobile.news.R;
import com.jumige.mobile.news.model.News;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class LoginActivity extends Activity {

	private TextView tv_back;
	private OnClickListener listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_login);
		initListener();
		tv_back = (TextView) findViewById(R.id.tv_login_back);
		tv_back.setOnClickListener(listener);
	}

	private void initListener() {
		listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.tv_login_back:
					//点击返回
					LoginActivity.this.finish();
					break;

				default:
					break;
				}

			}
		};
	}

}
