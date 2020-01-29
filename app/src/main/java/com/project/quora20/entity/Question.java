package com.project.quora20.entity;

import com.google.gson.annotations.SerializedName;

public class Question{

	@SerializedName("date")
	private String date;

	@SerializedName("bestAnswerId")
	private String bestAnswerId;

	@SerializedName("questionId")
	private String questionId;

	@SerializedName("likeCount")
	private int likeCount;

	@SerializedName("approvalFlag")
	private boolean approvalFlag;

	@SerializedName("userId")
	private String userId;

	@SerializedName("questionBody")
	private String questionBody;

	@SerializedName("disLikeCount")
	private int disLikeCount;

	@SerializedName("categoryId")
	private String categoryId;

	@SerializedName("orgid")
	private String orgid;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setBestAnswerId(String bestAnswerId){
		this.bestAnswerId = bestAnswerId;
	}

	public String getBestAnswerId(){
		return bestAnswerId;
	}

	public void setQuestionId(String questionId){
		this.questionId = questionId;
	}

	public String getQuestionId(){
		return questionId;
	}

	public void setLikeCount(int likeCount){
		this.likeCount = likeCount;
	}

	public int getLikeCount(){
		return likeCount;
	}

	public void setApprovalFlag(boolean approvalFlag){
		this.approvalFlag = approvalFlag;
	}

	public boolean isApprovalFlag(){
		return approvalFlag;
	}

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

	public void setDisLikeCount(int disLikeCount){
		this.disLikeCount = disLikeCount;
	}

	public int getDisLikeCount(){
		return disLikeCount;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setOrgid(String orgid){
		this.orgid = orgid;
	}

	public String getOrgid(){
		return orgid;
	}

	@Override
 	public String toString(){
		return 
			"Question{" + 
			"date = '" + date + '\'' + 
			",bestAnswerId = '" + bestAnswerId + '\'' + 
			",questionId = '" + questionId + '\'' + 
			",likeCount = '" + likeCount + '\'' + 
			",approvalFlag = '" + approvalFlag + '\'' + 
			",userId = '" + userId + '\'' + 
			",questionBody = '" + questionBody + '\'' + 
			",disLikeCount = '" + disLikeCount + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			",orgid = '" + orgid + '\'' + 
			"}";
		}
}