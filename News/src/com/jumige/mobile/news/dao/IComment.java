package com.jumige.mobile.news.dao;

import com.jumige.mobile.news.model.Comment;

public interface IComment {

	//根据ID获取评论
	public Comment findCommById(Integer Id);
}
