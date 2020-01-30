package com.project.quora20.entity;

import com.google.gson.annotations.SerializedName;

public class Question{

	@SerializedName("date")
	private String date;

	@SerializedName("bestAnswerId")
	private String bestAnswerId;

	@SerializedName("questionId")
	private String questionId;

	@SerializedName("answersList")
	private String answersList;

	@SerializedName("dislikeCount")
	private int dislikeCount;

	@SerializedName("likeCount")
	private int likeCount;

	@SerializedName("approvalFlag")
	private boolean approvalFlag;

	@SerializedName("userId")
	private String userId;

	@SerializedName("questionBody")
	private String questionBody;

	@SerializedName("categoryId")
	private String categoryId;

	@SerializedName("orgId")
	private String orgId;

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

	public void setAnswersList(String answersList){
		this.answersList = answersList;
	}

	public String getAnswersList(){
		return answersList;
	}

	public void setDislikeCount(int dislikeCount){
		this.dislikeCount = dislikeCount;
	}

	public int getDislikeCount(){
		return dislikeCount;
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
			"Question{" + 
			"date = '" + date + '\'' + 
			",bestAnswerId = '" + bestAnswerId + '\'' + 
			",questionId = '" + questionId + '\'' + 
			",answersList = '" + answersList + '\'' + 
			",dislikeCount = '" + dislikeCount + '\'' + 
			",likeCount = '" + likeCount + '\'' + 
			",approvalFlag = '" + approvalFlag + '\'' + 
			",userId = '" + userId + '\'' + 
			",questionBody = '" + questionBody + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			",orgId = '" + orgId + '\'' + 
			"}";
		}
}