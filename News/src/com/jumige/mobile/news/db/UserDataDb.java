package com.jumige.mobile.news.db;

import java.util.ArrayList;
import java.util.HashMap;

import com.jumige.mobile.news.model.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDataDb {
/*
 * 存取用户名，密码
 */
	private Context mContext;
	private ContentValues values;
	private DataBaseHelper dbHelper;
	private SQLiteDatabase db;
	private Cursor cursor;
	private HashMap<String, Object> map;
	private ArrayList<String> list;

	public UserDataDb(Context context) {
		mContext = context;
	}

	public void insertData(User user) {
		// 生成ContentValues对象
		values = new ContentValues();
		// 想该对象当中插入键值对，其中键是列名，值是希望插入到这一列的值，值必须和数据库当中的数据类型一致
		values.put("userName", user.getUserName());
		values.put("passWord", user.getPassdWord());
		dbHelper = new DataBaseHelper(mContext, "user_data", 1);
		db = dbHelper.getWritableDatabase();
		// 调用insert方法，就可以将数据插入到数据库当中
		db.insert("user_data", null, values);
		db.close();
	}

	public HashMap<String, Object> queryUserName() {
		map = new HashMap<String, Object>();
		dbHelper = new DataBaseHelper(mContext, "user_data", 1);
		db = dbHelper.getWritableDatabase();
		cursor = db.rawQuery("select userName from user_data", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			String userName = cursor.getString(cursor
					.getColumnIndex("userName"));
			map.put(userName, userName);
			cursor.moveToNext();
		}
		return map;

	}

	public ArrayList<String> queryPassWord() {
		list = new ArrayList<String>();
		dbHelper = new DataBaseHelper(mContext, "user_data", 1);
		db = dbHelper.getWritableDatabase();
		
		cursor = db.rawQuery("select passWord from user_data", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			String passWord = cursor.getString(cursor
					.getColumnIndex("passWord"));
			list.add(passWord);
			cursor.moveToNext();
		}
		return list;

	}
}
