package com.project.quora20.dto;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TagsDARequest{

	@SerializedName("appId")
	private String appId;

	@SerializedName("action")
	private String action;

	@SerializedName("tag")
	private List<String> tag;

	@SerializedName("userId")
	private String userId;

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

	public void setTag(List<String> tag){
		this.tag = tag;
	}

	public List<String> getTag(){
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
			"TagsDARequest{" + 
			"appId = '" + appId + '\'' + 
			",action = '" + action + '\'' + 
			",tag = '" + tag + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}