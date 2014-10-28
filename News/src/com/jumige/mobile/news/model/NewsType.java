package com.jumige.mobile.news.model;

public class NewsType {
	/*
	 * 栏目ID
	 */
	private Integer typeID;
	/*
	 * 栏目名字
	 */
	private String typeName;
	/*
	 * 栏目是否被选中
	 */
	private Boolean isSelect;

	public Integer getTypeID() {
		return typeID;
	}

	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Boolean getIsSelect() {
		return isSelect;
	}

	public void setIsSelect(Boolean isSelect) {
		this.isSelect = isSelect;
	}

}
