package com.project.quora20.dto.logindtos;

import com.google.gson.annotations.SerializedName;

public class RegisterQuoraUser{

	@SerializedName("privateFlag")
	private boolean privateFlag;

	@SerializedName("userImage")
	private String userImage;

	@SerializedName("userEmail")
	private String userEmail;

	@SerializedName("userScore")
	private int userScore;

	@SerializedName("userName")
	private String userName;

	@SerializedName("userId")
	private String userId;

	public void setPrivateFlag(boolean privateFlag){
		this.privateFlag = privateFlag;
	}

	public boolean isPrivateFlag(){
		return privateFlag;
	}

	public void setUserImage(String userImage){
		this.userImage = userImage;
	}

	public String getUserImage(){
		return userImage;
	}

	public void setUserEmail(String userEmail){
		this.userEmail = userEmail;
	}

	public String getUserEmail(){
		return userEmail;
	}

	public void setUserScore(int userScore){
		this.userScore = userScore;
	}

	public int getUserScore(){
		return userScore;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	@Override
 	public String toString(){
		return 
			"RegisterQuoraUser{" + 
			"privateFlag = '" + privateFlag + '\'' + 
			",userImage = '" + userImage + '\'' + 
			",userEmail = '" + userEmail + '\'' + 
			",userScore = '" + userScore + '\'' + 
			",userName = '" + userName + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}