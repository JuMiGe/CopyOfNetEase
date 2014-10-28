package com.jumige.mobile.news.activity;

import com.mobile.jumige.news.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WelcomeActivity extends Activity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
		/*
		 * 欢迎界面2.5秒后跳转
		 */
        intent = new Intent(this, MainActivity.class);
        Thread thread = new Thread(new runable());
        thread.start();

    }

    /*
     * 延时线程
     */
    private class runable implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(25);
                startActivity(intent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
