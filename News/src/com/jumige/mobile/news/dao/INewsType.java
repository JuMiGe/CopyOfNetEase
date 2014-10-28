package com.jumige.mobile.news.dao;


public interface INewsType {
	// 通过ID查找栏目
	public String getNewsTypeById(Integer integer);

	// 添加需要的栏目
	public void insertNewsType(Integer integer);

	// 去除不需要的栏目
	public void deleteNewsType(Integer integer);

}
