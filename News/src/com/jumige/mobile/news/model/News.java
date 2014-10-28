package com.jumige.mobile.news.model;

import java.net.URL;
import java.util.List;

public class News {

	/*
	 * 新闻的ID
	 */
	private Integer newsID;
	/*
	 * 新闻的标题
	 */
	private String newsTitle;
	
	/*
	 * 评论的数量
	 */
	private Integer commentCount;
	/*
	 * 是否已收藏
	 */
	private boolean isEnshirne;
	/*
	 * 新闻源
	 */
	private String newsSource;
	/*
	 * 所属的栏目的ID
	 */
	private Integer typeID;

	/*
	 * 新闻的视频URL
	 */
	private String newsVideoURL;

	/*
	 * 推广的广告可不写
	 */

	/*
	 * 新闻源地址
	 */
	private String newsUrl;
	/*
	 * 在列表里显示的摘要
	 */
	private String digest;
	/*
	 * 是否已被阅读
	 */
	private boolean isRead;
	/*
	 * 图片的URL集合
	 */

	private List<URL> picList;
	/*
	 * 是否是图片型新闻
	 */
	private boolean isPicNews;
	/*
	 * 是否是视频型新闻
	 */

	private boolean isVideoNews;

	public Integer getNewsID() {
		return newsID;
	}

	public void setNewsID(Integer newsID) {
		this.newsID = newsID;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}


	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public boolean isEnshirne() {
		return isEnshirne;
	}

	public void setEnshirne(boolean isEnshirne) {
		this.isEnshirne = isEnshirne;
	}

	public String getNewsSource() {
		return newsSource;
	}

	public void setNewsSource(String newsSource) {
		this.newsSource = newsSource;
	}

	public Integer getTypeID() {
		return typeID;
	}

	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}

	public String getNewsVideoURL() {
		return newsVideoURL;
	}

	public void setNewsVideoURL(String newsVideoURL) {
		this.newsVideoURL = newsVideoURL;
	}

	public String getNewsUrl() {
		return newsUrl;
	}

	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public List<URL> getPicList() {
		return picList;
	}

	public void setPicList(List<URL> picList) {
		this.picList = picList;
	}

	public boolean isPicNews() {
		return isPicNews;
	}

	public void setPicNews(boolean isPicNews) {
		this.isPicNews = isPicNews;
	}

	public boolean isVideoNews() {
		return isVideoNews;
	}

	public void setVideoNews(boolean isVideoNews) {
		this.isVideoNews = isVideoNews;
	}

}
