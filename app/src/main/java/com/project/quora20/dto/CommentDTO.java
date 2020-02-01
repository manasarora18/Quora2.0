package com.project.quora20.dto;

import com.google.gson.annotations.SerializedName;

public class CommentDTO{

	@SerializedName("answerId")
	private String answerId;

	@SerializedName("UserId")
	private String userId;

	@SerializedName("commentBody")
	private String commentBody;

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
			"CommentDTO{" + 
			"answerId = '" + answerId + '\'' + 
			",userId = '" + userId + '\'' + 
			",commentBody = '" + commentBody + '\'' + 
			",userName = '" + userName + '\'' + 
			",parentId = '" + parentId + '\'' + 
			"}";
		}
}