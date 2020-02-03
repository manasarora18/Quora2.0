package com.project.quora20.dto.logindtos;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UserDTO{

	@SerializedName("organizationId")
	private String organizationId;

	@SerializedName("userFollowingOrganization")
	private List<String> userFollowingOrganization;

	@SerializedName("userFollowing")
	private List<String> userFollowing;

	@SerializedName("privateFlag")
	private boolean privateFlag;

	@SerializedName("userImage")
	private String userImage;

	@SerializedName("userCategory")
	private List<String> userCategory;

	@SerializedName("userEmail")
	private String userEmail;

	@SerializedName("userScore")
	private int userScore;

	@SerializedName("userName")
	private String userName;

	@SerializedName("userId")
	private String userId;

	@SerializedName("userFollower")
	private List<String> userFollower;

	public void setOrganizationId(String organizationId){
		this.organizationId = organizationId;
	}

	public String getOrganizationId(){
		return organizationId;
	}

	public void setUserFollowingOrganization(List<String> userFollowingOrganization){
		this.userFollowingOrganization = userFollowingOrganization;
	}

	public List<String> getUserFollowingOrganization(){
		return userFollowingOrganization;
	}

	public void setUserFollowing(List<String> userFollowing){
		this.userFollowing = userFollowing;
	}

	public List<String> getUserFollowing(){
		return userFollowing;
	}

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

	public void setUserCategory(List<String> userCategory){
		this.userCategory = userCategory;
	}

	public List<String> getUserCategory(){
		return userCategory;
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

	public void setUserFollower(List<String> userFollower){
		this.userFollower = userFollower;
	}

	public List<String> getUserFollower(){
		return userFollower;
	}

	@Override
 	public String toString(){
		return 
			"UserDTO{" + 
			"organizationId = '" + organizationId + '\'' + 
			",userFollowingOrganization = '" + userFollowingOrganization + '\'' + 
			",userFollowing = '" + userFollowing + '\'' + 
			",privateFlag = '" + privateFlag + '\'' + 
			",userImage = '" + userImage + '\'' + 
			",userCategory = '" + userCategory + '\'' + 
			",userEmail = '" + userEmail + '\'' + 
			",userScore = '" + userScore + '\'' + 
			",userName = '" + userName + '\'' + 
			",userId = '" + userId + '\'' + 
			",userFollower = '" + userFollower + '\'' + 
			"}";
		}
}