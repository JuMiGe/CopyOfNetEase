package com.jumige.mobile.news.db;

import java.util.HashMap;

import com.jumige.mobile.news.dao.INewsType;

public class NewsTypeDataDb implements INewsType {
	/*
	 * 初始化栏目数据
	 */
	public HashMap<Integer, String> onNewsTypeMap = new HashMap<Integer, String>();
	public HashMap<Integer, String> noNewsTypeMap = new HashMap<Integer, String>();

	public void initNewsType() {
		onNewsTypeMap.put(0, "头条");
		onNewsTypeMap.put(1, "热点");
		onNewsTypeMap.put(2, "娱乐");
		onNewsTypeMap.put(3, "体育");
		onNewsTypeMap.put(4, "财经");
		onNewsTypeMap.put(5, "北京");
		onNewsTypeMap.put(6, "科技");
		onNewsTypeMap.put(7, "段子");
		onNewsTypeMap.put(8, "图片");
		onNewsTypeMap.put(9, "汽车");
		onNewsTypeMap.put(10, "时尚");
		onNewsTypeMap.put(11, "轻松一刻");
		onNewsTypeMap.put(12, "军事");
		onNewsTypeMap.put(13, "历史");
		onNewsTypeMap.put(14, "房产");
		onNewsTypeMap.put(15, "游戏");
		onNewsTypeMap.put(16, "精选");
		onNewsTypeMap.put(17, "电台");
		noNewsTypeMap.put(18, "论坛");
		noNewsTypeMap.put(19, "博客");
		noNewsTypeMap.put(20, "社会");
		noNewsTypeMap.put(21, "电影");
		noNewsTypeMap.put(22, "彩票");
		noNewsTypeMap.put(23, "NBA");
		noNewsTypeMap.put(24, "中国足球");
		noNewsTypeMap.put(25, "国际足球");
		noNewsTypeMap.put(26, "CBA");
		noNewsTypeMap.put(27, "跑步");
		noNewsTypeMap.put(28, "手机");
		noNewsTypeMap.put(29, "数码");
		noNewsTypeMap.put(30, "移动互联");
		noNewsTypeMap.put(31, "原创");
		noNewsTypeMap.put(32, "家居");
		noNewsTypeMap.put(33, "时尚大家");
		noNewsTypeMap.put(34, "教育");
		noNewsTypeMap.put(35, "酒香");
		noNewsTypeMap.put(36, "暴雪游戏");
		noNewsTypeMap.put(37, "亲子");
		noNewsTypeMap.put(38, "葡萄酒");
		noNewsTypeMap.put(39, "旅游");
		noNewsTypeMap.put(40, "情感");
		noNewsTypeMap.put(41, "政务");
	}

	@Override
	public String getNewsTypeById(Integer integer) {
		// 通过ID得到栏目
		if (integer <= onNewsTypeMap.size()) {
			return onNewsTypeMap.get(integer);
		}

		return noNewsTypeMap.get(integer);
	}

	@Override
	public void insertNewsType(Integer integer) {
		// 添加需要的栏目
		onNewsTypeMap.put(integer, noNewsTypeMap.get(integer));

	}

	@Override
	public void deleteNewsType(Integer integer) {
		// 删除已选中的栏目
		onNewsTypeMap.remove(integer);

	}
}
