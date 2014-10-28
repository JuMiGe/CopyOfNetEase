package com.jumige.mobile.news.model;

import java.util.List;

import android.R.integer;

public class User {
	/*
	 * 用户对象ID
	 */
	private integer ID;
	/*
	 * 用户email，同样可登录
	 */
	private String eMailID;
	/*
	 * 用户的消息提示
	 */
	private List<String> userMessage;

	/*
	 * 用户名
	 */
	private String userName;
	/*
	 * 用户密码
	 */
	private String passdWord;
	/*
	 * 用户已收藏的新闻的集合
	 */
	private List<Integer> enshirneNewsID;
	/*
	 * 阅读过的新闻ID集合
	 */
	private List<Integer> readNewsID;
	/*
	 * 用户的评论ID集合
	 */
	private List<Integer> userComment;
	/*
	 * 用户已分享的NewsID集合
	 */

	private List<Integer> shareNewsID;
	/*
	 * 用户的地理定位
	 */
	private String userCity;

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	/*
	 * 用户已收藏的评论ID
	 */
	private List<Integer> enshirneCommID;
	/*
	 * 所拥有的金币数量
	 */
	private Integer goldNumber;

	public Integer getGoldNumber() {
		return goldNumber;
	}

	public void setGoldNumber(Integer goldNumber) {
		this.goldNumber = goldNumber;
	}

	public List<Integer> getEnshirneID() {
		return enshirneNewsID;
	}

	public void setEnshirneID(List<Integer> enshirneID) {
		this.enshirneNewsID = enshirneID;
	}

	public List<Integer> getEnshirneNewsID() {
		return enshirneNewsID;
	}

	public void setEnshirneNewsID(List<Integer> enshirneNewsID) {
		this.enshirneNewsID = enshirneNewsID;
	}

	public List<Integer> getShareNewsID() {
		return shareNewsID;
	}

	public void setShareNewsID(List<Integer> shareNewsID) {
		this.shareNewsID = shareNewsID;
	}

	public List<Integer> getEnshirneCommID() {
		return enshirneCommID;
	}

	public void setEnshirneCommID(List<Integer> enshirneCommID) {
		this.enshirneCommID = enshirneCommID;
	}

	public List<Integer> getReadNewsID() {
		return readNewsID;
	}

	public void setReadNewsID(List<Integer> readNewsTitle) {
		this.readNewsID = readNewsTitle;
	}

	public List<Integer> getUserComment() {
		return userComment;
	}

	public void setUserComment(List<Integer> userComment) {
		this.userComment = userComment;
	}

	public integer getID() {
		return ID;
	}

	public void setID(integer iD) {
		ID = iD;
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

	public String geteMailID() {
		return eMailID;
	}

	public void seteMailID(String eMailID) {
		this.eMailID = eMailID;
	}

	public List<String> getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(List<String> userMessage) {
		this.userMessage = userMessage;
	}

	public User(integer iD, String eMail, String userName, String passdWord) {
		super();
		ID = iD;
		this.eMailID = eMail;
		this.userName = userName;
		this.passdWord = passdWord;

	}

	public User() {
	}
}
