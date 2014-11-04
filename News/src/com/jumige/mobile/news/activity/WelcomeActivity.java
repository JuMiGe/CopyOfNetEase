package com.jumige.mobile.news.activity;

import com.jumige.mobile.news.R;
import com.jumige.mobile.news.db.DataBaseHelper;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class WelcomeActivity extends Activity {
	/*
	 * 欢迎页面。第一次创建数据库，创建表
	 */
	private Intent intent;
	private Thread thread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		/*
		 * 欢迎界面1秒后跳转
		 */
		intent = new Intent(this, MainActivity.class);
		thread = new Thread(new runable());
		thread.start();

	}

	/*
	 * 延时线程 创建数据库
	 */
	private class runable implements Runnable {

		@Override
		public void run() {
			try {

				// 创建一个DatabaseHelper对象
				DataBaseHelper dbHelper = new DataBaseHelper(
						WelcomeActivity.this, "user_data");
				// 只有调用了DatabaseHelper对象的getReadableDatabase()方法，或者是getWritableDatabase()方法之后，才会创建，或打开一个数据库
				SQLiteDatabase db = dbHelper.getReadableDatabase();
				db.close();
				Thread.sleep(1000);

				startActivity(intent);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
