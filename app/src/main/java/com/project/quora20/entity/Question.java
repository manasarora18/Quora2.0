package com.project.quora20.entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Question{

	@SerializedName("dislikeUserList")
	private List<String> dislikeUserList;

	@SerializedName("date")
	private String date;

	@SerializedName("questionId")
	private String questionId;

	@SerializedName("likeUserList")
	private List<String> likeUserList;

	@SerializedName("answersList")
	private List<String> answersList;

	@SerializedName("dislikeCount")
	private int dislikeCount;

	@SerializedName("likeCount")
	private int likeCount;

	@SerializedName("userId")
	private String userId;

	@SerializedName("orgId")
	private String orgId;

	@SerializedName("bestAnswerId")
	private String bestAnswerId;

	@SerializedName("approvalFlag")
	private boolean approvalFlag;

	@SerializedName("questionBody")
	private String questionBody;

	@SerializedName("categoryId")
	private String categoryId;

	public void setDislikeUserList(List<String> dislikeUserList){
		this.dislikeUserList = dislikeUserList;
	}

	public List<String> getDislikeUserList(){
		return dislikeUserList;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setQuestionId(String questionId){
		this.questionId = questionId;
	}

	public String getQuestionId(){
		return questionId;
	}

	public List<String> getLikeUserList() {
		return likeUserList;
	}

	public void setLikeUserList(List<String> likeUserList) {
		this.likeUserList = likeUserList;
	}

	public void setAnswersList(List<String> answersList){
		this.answersList = answersList;
	}

	public List<String> getAnswersList(){
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

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setOrgId(String orgId){
		this.orgId = orgId;
	}

	public String getOrgId(){
		return orgId;
	}

	public void setBestAnswerId(String bestAnswerId){
		this.bestAnswerId = bestAnswerId;
	}

	public String getBestAnswerId(){
		return bestAnswerId;
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

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	@Override
	public String toString(){
		return
				"Question{" +
						"dislikeUserList = '" + dislikeUserList + '\'' +
						",date = '" + date + '\'' +
						",questionId = '" + questionId + '\'' +
						",likeUserList = '" + likeUserList + '\'' +
						",answersList = '" + answersList + '\'' +
						",dislikeCount = '" + dislikeCount + '\'' +
						",likeCount = '" + likeCount + '\'' +
						",userId = '" + userId + '\'' +
						",orgId = '" + orgId + '\'' +
						",bestAnswerId = '" + bestAnswerId + '\'' +
						",approvalFlag = '" + approvalFlag + '\'' +
						",questionBody = '" + questionBody + '\'' +
						",categoryId = '" + categoryId + '\'' +
						"}";
	}
}