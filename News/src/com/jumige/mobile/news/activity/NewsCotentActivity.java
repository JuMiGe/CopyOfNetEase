package com.jumige.mobile.news.activity;

import com.jumige.mobile.news.R;
import com.jumige.mobile.news.db.NewsListDataDb;
import com.jumige.mobile.news.tools.ImageCacheTool;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsCotentActivity extends Activity {
	/*
	 * 点击列表内的新闻后，显示新闻
	 */
	private Intent intent;
	private ImageCacheTool imageCacheTool;
	private NewsListDataDb nldd;
	private ImageView img_back;
	private TextView tv_title;
	private ImageView img_img1;
	private ImageView img_img2;
	private TextView tv_content;
	private int position;
	private TextView tv_comm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listnews);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_listnews);
		intent = getIntent();
		position = intent.getExtras().getInt("position");
		imageCacheTool = new ImageCacheTool(getApplicationContext(), 550);
		nldd = new NewsListDataDb(getApplicationContext());
		tv_content = (TextView) findViewById(R.id.tv_cotent_txt);
		img_back = (ImageView) findViewById(R.id.img_content_back);
		tv_title = (TextView) findViewById(R.id.tv_cotent_title);
		img_img1 = (ImageView) findViewById(R.id.img_cotent_img1);
		img_img2 = (ImageView) findViewById(R.id.img_cotent_img2);
		tv_comm = (TextView) findViewById(R.id.tv_content_comm);
		tv_comm.setText(nldd.commentNum[position]);
		img_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}
		});

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				String string;
				Bitmap bitmap;
				Looper.prepare();
				// 子线程更新UI

				string = nldd.getNewsTitle("newslistdata/newslist_"
						+ (position - 1) + "_context");
				handler.obtainMessage(0, string).sendToTarget();
				bitmap = imageCacheTool.getBitmapFromCacheList(String
						.valueOf("newslistdata/newslist_" + (position - 1)
								+ "_img1.jpg"));
				handler.obtainMessage(1, bitmap).sendToTarget();
				bitmap = imageCacheTool.getBitmapFromCacheList(String
						.valueOf("newslistdata/newslist_" + (position - 1)
								+ "_img2.jpg"));
				handler.obtainMessage(2, bitmap).sendToTarget();
				string = nldd.getNewsContext(1, "newslistdata/newslist_"
						+ (position - 1) + "_context");
				handler.obtainMessage(3, string).sendToTarget();
				Looper.loop();

			}
		});
		thread.start();

	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// 重写handleMessage来接收处理handler发送的消息
			switch (msg.what) {
			case 0:
				tv_title.setText((CharSequence) msg.obj);
				;
				break;

			case 1:
				img_img1.setImageBitmap((Bitmap) msg.obj);
				break;
			case 2:
				img_img2.setImageBitmap((Bitmap) msg.obj);
				break;
			case 3:
				tv_content.setText((CharSequence) msg.obj);
				break;
			}
		}

	};

}
