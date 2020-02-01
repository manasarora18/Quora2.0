package com.project.quora20.entity;

import com.google.gson.annotations.SerializedName;

public class OnClickRequest{

	@SerializedName("adId")
	private String adId;

	@SerializedName("description")
	private String description;

	@SerializedName("tag")
	private String tag;

	@SerializedName("source")
	private String source;

	@SerializedName("targetUrl")
	private String targetUrl;

	@SerializedName("categoryId")
	private String categoryId;

	@SerializedName("advertiserId")
	private String advertiserId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@SerializedName("userId")
	private String userId;

	public void setAdId(String adId){
		this.adId = adId;
	}

	public String getAdId(){
		return adId;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTag(String tag){
		this.tag = tag;
	}

	public String getTag(){
		return tag;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setTargetUrl(String targetUrl){
		this.targetUrl = targetUrl;
	}

	public String getTargetUrl(){
		return targetUrl;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setAdvertiserId(String advertiserId){
		this.advertiserId = advertiserId;
	}

	public String getAdvertiserId(){
		return advertiserId;
	}

	@Override
 	public String toString(){
		return 
			"OnClickRequest{" + 
			"adId = '" + adId + '\'' + 
			",description = '" + description + '\'' + 
			",tag = '" + tag + '\'' + 
			",source = '" + source + '\'' + 
			",targetUrl = '" + targetUrl + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			",advertiserId = '" + advertiserId + '\'' + 
			"}";
		}
}