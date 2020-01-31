package com.project.quora20.dto;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NewPostRequestDTO{

//	@SerializedName("tag")
//	private String tag;

	@SerializedName("userId")
	private String userId;

	@SerializedName("questionBody")
	private String questionBody;

	@SerializedName("personsTag")
	private List<String> personsTag;

	@SerializedName("categoryId")
	private String categoryId;

	@SerializedName("orgId")
	private String orgId;

//	public void setTag(String tag){
//		this.tag = tag;
//	}
//
//	public String getTag(){
//		return tag;
//	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setQuestionBody(String questionBody){
		this.questionBody = questionBody;
	}

	public String getQuestionBody(){
		return questionBody;
	}

	public void setPersonsTag(List<String> personsTag){
		this.personsTag = personsTag;
	}

	public List<String> getPersonsTag(){
		return personsTag;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setOrgId(String orgId){
		this.orgId = orgId;
	}

	public String getOrgId(){
		return orgId;
	}

	@Override
 	public String toString(){
		return 
			"NewPostRequestDTO{" + 
//			"tag = '" + tag + '\'' +
			",userId = '" + userId + '\'' + 
			",questionBody = '" + questionBody + '\'' + 
			",personsTag = '" + personsTag + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			",orgId = '" + orgId + '\'' + 
			"}";
		}
}