package com.jumige.mobile.news.activity;

import com.jumige.mobile.news.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class SearchNewsActivity extends Activity {

	private TextView tv_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchnews);
		// 设置标题栏
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_searchnews);

		tv_back = (TextView) findViewById(R.id.tv_search_back);
		tv_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 点击返回
				SearchNewsActivity.this.finish();
			}
		});
	}

}
