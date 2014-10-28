package com.jumige.mobile.news.dao;

import com.jumige.mobile.news.model.User;

public interface IUser {
	
	//添加User
	public User insertUser(User user);
	//通过ID查找用户
	public User findUserById(Integer Id);
	//通过emile查找用户
	public User findUserByEmile(String emile);
}
