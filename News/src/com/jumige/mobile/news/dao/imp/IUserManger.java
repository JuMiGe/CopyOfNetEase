package com.jumige.mobile.news.dao.imp;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.bool;
import android.content.Context;

import com.jumige.mobile.news.dao.IUser;
import com.jumige.mobile.news.db.UserDataDb;
import com.jumige.mobile.news.model.User;

public class IUserManger implements IUser {

	private UserDataDb userDataDb;
	private Context mContext;
	private HashMap<String, Object> userNameResult;
	private ArrayList<String> passWordResult;

	/*
	 * 增加新用户，成功则返回true，失败则返回false
	 */
	@Override
	public boolean insertUser(User user) {

		userNameResult = userDataDb.queryUserName();
		if (userNameResult.get(user.getUserName()) == null) {
			userDataDb.insertData(user);
			return true;
		}
		return false;
	}

	/*
	 * 登录验证 成功则返回true，失败返回false
	 */
	public Boolean loginUser(User user) {
		userNameResult = userDataDb.queryUserName();
		passWordResult = userDataDb.queryPassWord();
		if (!(userNameResult.get(user.getUserName()) == null)) {
			for (int i = 0; i < passWordResult.size(); i++) {
				if (passWordResult.get(i).equals(user.getPassdWord())) {
					return true;
				}
			}
		}
		return false;

	}

	public IUserManger(Context context) {
		mContext = context;
		userDataDb = new UserDataDb(mContext);
	}

}
