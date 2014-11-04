package com.jumige.mobile.news.activity;

import com.jumige.mobile.news.R;
import com.jumige.mobile.news.dao.imp.IUserManger;
import com.jumige.mobile.news.model.User;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	/*
	 * 注册页面，将数据匹配后，返回
	 */
	private TextView tv_back;
	private OnClickListener listener;
	private EditText edt_userName;
	private EditText edt_passWord;
	private TextView tv_register;
	private IUserManger IUserManger;
	private User iUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_register);
		tv_back = (TextView) findViewById(R.id.tv_register_back);
		edt_userName = (EditText) findViewById(R.id.edt_register_user);
		edt_passWord = (EditText) findViewById(R.id.edt_register_password);
		tv_register = (TextView) findViewById(R.id.tv_register_register);
		initListener();
		tv_register.setOnClickListener(listener);
		tv_back.setOnClickListener(listener);

	}

	private void initListener() {
		listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.tv_register_back:
					RegisterActivity.this.finish();
					break;

				case R.id.tv_register_register:
					IUserManger = new IUserManger(getApplicationContext());
					String iUserName = edt_userName.getText().toString();
					String iPassWord = edt_passWord.getText().toString();
					iUser = new User(iUserName, iPassWord);
					if (IUserManger.insertUser(iUser)) {
						Toast.makeText(getApplicationContext(), "注册成功",
								Toast.LENGTH_SHORT).show();
						RegisterActivity.this.finish();
					} else {
						Toast.makeText(getApplicationContext(), "该用户已存在",
								Toast.LENGTH_LONG).show();
					}
					break;
				}

			}
		};
	}

}
