package com.jumige.mobile.news.activity;

import com.jumige.mobile.news.R;
import com.jumige.mobile.news.dao.imp.IUserManger;
import com.jumige.mobile.news.model.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	/*
	 * 登录界面
	 */
	private TextView tv_back;
	private OnClickListener listener;
	private EditText edt_userName;
	private EditText edt_passWord;
	private TextView tv_login;
	private TextView tv_register;
	private IUserManger IUserManger;
	private User iUser;
	public static final String action = "jason.broadcast.action";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_login);
		initListener();
		tv_back = (TextView) findViewById(R.id.tv_login_back);
		edt_userName = (EditText) findViewById(R.id.edt_login_user);
		edt_passWord = (EditText) findViewById(R.id.edt_login_password);
		tv_login = (TextView) findViewById(R.id.tv_login_login);
		tv_register = (TextView) findViewById(R.id.tv_login_register);
		tv_login.setOnClickListener(listener);
		tv_register.setOnClickListener(listener);
		tv_back.setOnClickListener(listener);

	}

	private void initListener() {
		listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.tv_login_back:
					// 点击返回
					LoginActivity.this.finish();
					break;

				case R.id.tv_login_login:
					//判断用户名和密码，登录成功则返回，发送广播到上一层更新UI
					IUserManger = new IUserManger(getApplicationContext());
					String iUserName = edt_userName.getText().toString();
					String iPassWord = edt_passWord.getText().toString();
					iUser = new User(iUserName, iPassWord);
					if (IUserManger.loginUser(iUser)) {
						Toast.makeText(getApplicationContext(), "登录成功",
								Toast.LENGTH_SHORT).show();
						Intent intent1 = new Intent();
						intent1.setAction(action);
						intent1.putExtra("data", iUserName);
						sendBroadcast(intent1,
								"com.android.permission.RECV_NEWS");
						LoginActivity.this.finish();
					} else {
						Toast.makeText(getApplicationContext(), "用户名或密码不正确",
								Toast.LENGTH_LONG).show();
					}
					break;
				case R.id.tv_login_register:
					Intent intent = new Intent(LoginActivity.this,
							RegisterActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					getApplication().startActivity(intent);
				}

			}
		};
	}

}
