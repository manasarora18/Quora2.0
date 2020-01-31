package com.project.quora20.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnswerListItem{

	@SerializedName("answerId")
	private String answerId;

	@SerializedName("dislikeUserList")
	private List<String> dislikeUserList;

	@SerializedName("date")
	private String date;

	@SerializedName("commentsList")
	private List<String> commentsList;

	@SerializedName("questionId")
	private String questionId;

	@SerializedName("likeUserList")
	private List<String> likeUserList;

	@SerializedName("answerBody")
	private String answerBody;

	@SerializedName("dislikeCount")
	private int dislikeCount;

	@SerializedName("likeCount")
	private int likeCount;

	@SerializedName("approvalFlag")
	private boolean approvalFlag;

	@SerializedName("userId")
	private String userId;

	@SerializedName("orgId")
	private String orgId;

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public List<String> getDislikeUserList() {
		return dislikeUserList;
	}

	public void setDislikeUserList(List<String> dislikeUserList) {
		this.dislikeUserList = dislikeUserList;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<String> commentsList) {
		this.commentsList = commentsList;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public List<String> getLikeUserList() {
		return likeUserList;
	}

	public void setLikeUserList(List<String> likeUserList) {
		this.likeUserList = likeUserList;
	}

	public String getAnswerBody() {
		return answerBody;
	}

	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}

	public int getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public boolean isApprovalFlag() {
		return approvalFlag;
	}

	public void setApprovalFlag(boolean approvalFlag) {
		this.approvalFlag = approvalFlag;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
}