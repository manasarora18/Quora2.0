package com.project.quora20.entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;
public class Answer{
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
	public void setAnswerId(String answerId){
		this.answerId = answerId;
	}
	public String getAnswerId(){
		return answerId;
	}
	public void setDislikeUserList(List<String> dislikeUserList){
		this.dislikeUserList = dislikeUserList;
	}
	public List<String> getDislikeUserList(){
		return dislikeUserList;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setCommentsList(List<String> commentsList){
		this.commentsList = commentsList;
	}
	public List<String> getCommentsList(){
		return commentsList;
	}
	public void setQuestionId(String questionId){
		this.questionId = questionId;
	}
	public String getQuestionId(){
		return questionId;
	}
	public void setLikeUserList(List<String> likeUserList){
		this.likeUserList = likeUserList;
	}
	public List<String> getLikeUserList(){
		return likeUserList;
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
	@Override
	public String toString(){
		return
				"Answer{" +
						"answerId = '" + answerId + '\'' +
						",dislikeUserList = '" + dislikeUserList + '\'' +
						",date = '" + date + '\'' +
						",commentsList = '" + commentsList + '\'' +
						",questionId = '" + questionId + '\'' +
						",likeUserList = '" + likeUserList + '\'' +
						",answerBody = '" + answerBody + '\'' +
						",dislikeCount = '" + dislikeCount + '\'' +
						",likeCount = '" + likeCount + '\'' +
						",approvalFlag = '" + approvalFlag + '\'' +
						",userId = '" + userId + '\'' +
						",orgId = '" + orgId + '\'' +
						"}";
	}
}