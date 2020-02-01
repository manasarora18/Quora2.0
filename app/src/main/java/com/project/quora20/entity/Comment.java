package com.project.quora20.entity;

import com.google.gson.annotations.SerializedName;

public class Comment{

	@SerializedName("answerId")
	private String answerId;

	@SerializedName("date")
	private String date;

	@SerializedName("UserId")
	private String userId;

	@SerializedName("commentBody")
	private String commentBody;

	@SerializedName("commentId")
	private String commentId;

	@SerializedName("userName")
	private String userName;

	@SerializedName("parentId")
	private String parentId;

	public void setAnswerId(String answerId){
		this.answerId = answerId;
	}

	public String getAnswerId(){
		return answerId;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setCommentBody(String commentBody){
		this.commentBody = commentBody;
	}

	public String getCommentBody(){
		return commentBody;
	}

	public void setCommentId(String commentId){
		this.commentId = commentId;
	}

	public String getCommentId(){
		return commentId;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setParentId(String parentId){
		this.parentId = parentId;
	}

	public String getParentId(){
		return parentId;
	}

	@Override
 	public String toString(){
		return 
			"Comment{" + 
			"answerId = '" + answerId + '\'' + 
			",date = '" + date + '\'' + 
			",userId = '" + userId + '\'' + 
			",commentBody = '" + commentBody + '\'' + 
			",commentId = '" + commentId + '\'' + 
			",userName = '" + userName + '\'' + 
			",parentId = '" + parentId + '\'' + 
			"}";
		}
}