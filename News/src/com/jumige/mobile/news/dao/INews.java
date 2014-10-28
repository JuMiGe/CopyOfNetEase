package com.jumige.mobile.news.dao;

import com.jumige.mobile.news.model.News;

public interface INews {

	//通过ID查找新闻
	public News findNewsById(Integer Id);
	
}
