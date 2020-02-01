package com.project.quora20.dto;

import com.google.gson.annotations.SerializedName;

public class SearchResponseUserDTO {

	@SerializedName("privateFlag")
	private boolean privateFlag;

	@SerializedName("userImage")
	private String userImage;

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
			"SearchResponseDTO{" + 
			"privateFlag = '" + privateFlag + '\'' + 
			",userImage = '" + userImage + '\'' + 
			",userName = '" + userName + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}