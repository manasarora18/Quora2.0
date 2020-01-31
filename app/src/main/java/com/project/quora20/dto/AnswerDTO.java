package com.project.quora20.dto;

public class AnswerDTO{
	private String questionId;
	private String answerBody;
	private String userId;
	private String orgId;

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
			"AnswerDTO{" + 
			"questionId = '" + questionId + '\'' + 
			",answerBody = '" + answerBody + '\'' + 
			",userId = '" + userId + '\'' + 
			",orgId = '" + orgId + '\'' + 
			"}";
		}
}
