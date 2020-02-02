package com.project.quora20.dto;


import com.google.gson.annotations.SerializedName;

public class FCMTokenRequest{

	@SerializedName("fcmToken")
	private String fcmtoken;

	public void setFcmtoken(String fcmtoken){
		this.fcmtoken = fcmtoken;
	}

	public String getFcmtoken(){
		return fcmtoken;
	}

	@Override
 	public String toString(){
		return 
			"FCMTokenRequest{" + 
			"fcmtoken = '" + fcmtoken + '\'' + 
			"}";
		}
}