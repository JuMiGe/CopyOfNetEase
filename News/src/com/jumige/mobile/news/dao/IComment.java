package com.jumige.mobile.news.dao;

import com.jumige.mobile.news.model.Comment;

public interface IComment {

	//通过ID查找评论
	public Comment findCommById(Integer Id);
}
