package com.project.quora20.dto.logindtos;

import com.google.gson.annotations.SerializedName;

public class AccessTokenLoginResponse {

	@SerializedName("accessToken")
	private String accessToken;

	@SerializedName("tokenType")
	private String tokenType;

	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}

	public String getAccessToken(){
		return accessToken;
	}

	public void setTokenType(String tokenType){
		this.tokenType = tokenType;
	}

	public String getTokenType(){
		return tokenType;
	}

	@Override
 	public String toString(){
		return 
			"AccessTokenRegisterResponse{" + 
			"accessToken = '" + accessToken + '\'' + 
			",tokenType = '" + tokenType + '\'' + 
			"}";
		}
}