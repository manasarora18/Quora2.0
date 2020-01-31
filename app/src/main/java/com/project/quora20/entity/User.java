package com.project.quora20.entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("userCategoryList")
	private List<String> userCategoryList;

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("userEmail")
	private String userEmail;

	@SerializedName("followersCount")
	private int followersCount;

	@SerializedName("followingCount")
	private int followingCount;

	@SerializedName("questionList")
	private List<QuestionListItem> questionList;



	public void setUserCategoryList(List<String> userCategoryList){
		this.userCategoryList = userCategoryList;
	}

	public List<String> getUserCategoryList(){
		return userCategoryList;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUserEmail(String userEmail){
		this.userEmail = userEmail;
	}

	public String getUserEmail(){
		return userEmail;
	}

	public void setFollowersCount(int followersCount){
		this.followersCount = followersCount;
	}

	public int getFollowersCount(){
		return followersCount;
	}

	public void setFollowingCount(int followingCount){
		this.followingCount = followingCount;
	}

	public int getFollowingCount(){
		return followingCount;
	}

	public void setQuestionList(List<QuestionListItem> questionList){
		this.questionList = questionList;
	}

	public List<QuestionListItem> getQuestionList(){
		return questionList;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"userCategoryList = '" + userCategoryList + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",name = '" + name + '\'' + 
			",userEmail = '" + userEmail + '\'' + 
			",followersCount = '" + followersCount + '\'' + 
			",followingCount = '" + followingCount + '\'' + 
			",questionList = '" + questionList + '\'' + 
			"}";
		}
}