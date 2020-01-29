package com.project.quora20.entity;

import com.google.gson.annotations.SerializedName;

public class Answer{

	@SerializedName("answerId")
	private String answerId;

	@SerializedName("questionId")
	private String questionId;

	@SerializedName("answerBody")
	private String answerBody;

	@SerializedName("dislikeCount")
	private int dislikeCount;

	@SerializedName("likeCount")
	private int likeCount;

	@SerializedName("approvalFlag")
	private boolean approvalFlag;

	public void setAnswerId(String answerId){
		this.answerId = answerId;
	}

	public String getAnswerId(){
		return answerId;
	}

	public void setQuestionId(String questionId){
		this.questionId = questionId;
	}

	public String getQuestionId(){
		return questionId;
	}

	public void setAnswerBody(String answerBody){
		this.answerBody = answerBody;
	}

	public String getAnswerBody(){
		return answerBody;
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

	@Override
 	public String toString(){
		return 
			"Answer{" + 
			"answerId = '" + answerId + '\'' + 
			",questionId = '" + questionId + '\'' + 
			",answerBody = '" + answerBody + '\'' + 
			",dislikeCount = '" + dislikeCount + '\'' + 
			",likeCount = '" + likeCount + '\'' + 
			",approvalFlag = '" + approvalFlag + '\'' + 
			"}";
		}
}