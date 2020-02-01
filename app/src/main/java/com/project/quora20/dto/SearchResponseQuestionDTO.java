package com.project.quora20.dto;

import com.google.gson.annotations.SerializedName;

public class SearchResponseQuestionDTO{

	@SerializedName("questionId")
	private String questionId;

	@SerializedName("questionImage")
	private String questionImage;

	@SerializedName("approvalFlag")
	private boolean approvalFlag;

	@SerializedName("questionBody")
	private String questionBody;

	public void setQuestionId(String questionId){
		this.questionId = questionId;
	}

	public String getQuestionId(){
		return questionId;
	}

	public void setQuestionImage(String questionImage){
		this.questionImage = questionImage;
	}

	public String getQuestionImage(){
		return questionImage;
	}

	public void setApprovalFlag(boolean approvalFlag){
		this.approvalFlag = approvalFlag;
	}

	public boolean isApprovalFlag(){
		return approvalFlag;
	}

	public void setQuestionBody(String questionBody){
		this.questionBody = questionBody;
	}

	public String getQuestionBody(){
		return questionBody;
	}

	@Override
 	public String toString(){
		return 
			"SearchResponseQuestionDTO{" + 
			"questionId = '" + questionId + '\'' + 
			",questionImage = '" + questionImage + '\'' + 
			",approvalFlag = '" + approvalFlag + '\'' + 
			",questionBody = '" + questionBody + '\'' + 
			"}";
		}
}