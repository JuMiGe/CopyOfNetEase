package com.jumige.mobile.news.dao.imp;

import java.util.HashMap;



import com.jumige.mobile.news.dao.INewsType;
import com.jumige.mobile.news.model.NewsType;

public class INewsTypeManger implements INewsType {

	/*
	 * 先模拟出栏目数据
	 */
	private HashMap<Integer, NewsType> hashMap = new HashMap<Integer, NewsType>();

	@Override
	public String getNewsTypeById(Integer integer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertNewsType(Integer integer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNewsType(Integer integer) {
		// TODO Auto-generated method stub
		
	}


}
