package com.project.quora20.entity;

import com.google.gson.annotations.SerializedName;

public class Ad{

	@SerializedName("adId")
	private String adId;

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("description")
	private String description;

	@SerializedName("location")
	private String location;

	@SerializedName("tag")
	private String tag;

	@SerializedName("categoryName")
	private String categoryName;

	@SerializedName("targetUrl")
	private String targetUrl;

	@SerializedName("advertiserId")
	private String advertiserId;

	public void setAdId(String adId){
		this.adId = adId;
	}

	public String getAdId(){
		return adId;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setTag(String tag){
		this.tag = tag;
	}

	public String getTag(){
		return tag;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return categoryName;
	}

	public void setTargetUrl(String targetUrl){
		this.targetUrl = targetUrl;
	}

	public String getTargetUrl(){
		return targetUrl;
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
			"Ad{" + 
			"adId = '" + adId + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",description = '" + description + '\'' + 
			",location = '" + location + '\'' + 
			",tag = '" + tag + '\'' + 
			",categoryName = '" + categoryName + '\'' + 
			",targetUrl = '" + targetUrl + '\'' + 
			",advertiserId = '" + advertiserId + '\'' + 
			"}";
		}
}