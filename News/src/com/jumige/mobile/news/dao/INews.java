package com.jumige.mobile.news.dao;

import com.jumige.mobile.news.model.News;

public interface INews {

	//根据ID获取新闻
	public News findNewsById(Integer Id);
	
}
