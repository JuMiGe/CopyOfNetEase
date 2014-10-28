package com.jumige.mobile.news.model;

public class Comment {

	/*
	 * 被评论新闻的ID
	 */
	private int commNewsID;

	public int getCommNewsID() {
		return commNewsID;
	}

	public void setCommNewsID(int commNewsID) {
		this.commNewsID = commNewsID;
	}

	/*
	 * 评论的用户名
	 */
	private String commentUser;
	/*
	 * 评论被赞的数量
	 */
	private Integer commentNumber;
	/*
	 * 评论的ID
	 */
	private Integer commentID;
	/*
	 * 评论的时间
	 */
	private String commentTime;
	/*
	 * 评论的回复
	 */
	private String commentReply;
	/*
	 * 评论是否被收藏
	 */
	private boolean isEnshirne;

	public String getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}

	public Integer getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(Integer commentNumber) {
		this.commentNumber = commentNumber;
	}

	public Integer getCommentID() {
		return commentID;
	}

	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public String getCommentReply() {
		return commentReply;
	}

	public void setCommentReply(String commentReply) {
		this.commentReply = commentReply;
	}

	public boolean isEnshirne() {
		return isEnshirne;
	}

	public void setEnshirne(boolean isEnshirne) {
		this.isEnshirne = isEnshirne;
	}

}
