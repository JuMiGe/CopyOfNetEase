package com.jumige.mobile.news.model;

import java.util.List;

import android.R.integer;

public class User {
	// /*
	// * 用户对象ID
	// */
	// private integer ID;
	// /*
	// * 用户email，同样可登录
	// */
	// private String eMailID;
	// /*
	// * 用户的消息提示
	// */
	// private List<String> userMessage;
	//
	/*
	 * 用户名
	 */
	private String userName;
	/*
	 * 用户密码
	 */
	private String passdWord;

	// /*
	// * 用户已收藏的新闻的集合
	// */
	// private List<Integer> enshirneNewsID;
	// /*
	// * 阅读过的新闻ID集合
	// */
	// private List<Integer> readNewsID;
	// /*
	// * 用户的评论ID集合
	// */
	// private List<Integer> userComment;
	// /*
	// * 用户已分享的NewsID集合
	// */
	//
	// private List<Integer> shareNewsID;
	// /*
	// * 用户的地理定位
	// */
	// private String userCity;

	public User() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassdWord() {
		return passdWord;
	}

	public void setPassdWord(String passdWord) {
		this.passdWord = passdWord;
	}

	public User(String userName, String passdWord) {
		super();
		this.userName = userName;
		this.passdWord = passdWord;
	}
}
