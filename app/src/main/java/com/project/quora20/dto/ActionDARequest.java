package com.project.quora20.dto;


import com.google.gson.annotations.SerializedName;


public class ActionDARequest{

	@SerializedName("targetId")
	private String targetId;

	@SerializedName("targetEntity")
	private String targetEntity;

	@SerializedName("appId")
	private String appId;

	@SerializedName("action")
	private String action;

	@SerializedName("tag")
	private String tag;

	@SerializedName("userId")
	private String userId;

	public void setTargetId(String targetId){
		this.targetId = targetId;
	}

	public String getTargetId(){
		return targetId;
	}

	public void setTargetEntity(String targetEntity){
		this.targetEntity = targetEntity;
	}

	public String getTargetEntity(){
		return targetEntity;
	}

	public void setAppId(String appId){
		this.appId = appId;
	}

	public String getAppId(){
		return appId;
	}

	public void setAction(String action){
		this.action = action;
	}

	public String getAction(){
		return action;
	}

	public void setTag(String tag){
		this.tag = tag;
	}

	public String getTag(){
		return tag;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	@Override
 	public String toString(){
		return 
			"ActionDARequest{" + 
			"targetId = '" + targetId + '\'' + 
			",targetEntity = '" + targetEntity + '\'' + 
			",appId = '" + appId + '\'' + 
			",action = '" + action + '\'' + 
			",tag = '" + tag + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}