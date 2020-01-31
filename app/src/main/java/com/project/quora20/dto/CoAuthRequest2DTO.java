package com.project.quora20.dto;

import com.google.gson.annotations.SerializedName;

public class CoAuthRequest2DTO{

	@SerializedName("role")
	private String role;

	@SerializedName("tokenId")
	private String tokenId;

	@SerializedName("Channel_channel_id")
	private long channelChannelId;

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	public void setTokenId(String tokenId){
		this.tokenId = tokenId;
	}

	public String getTokenId(){
		return tokenId;
	}

	public void setChannelChannelId(long channelChannelId){
		this.channelChannelId = channelChannelId;
	}

	public long getChannelChannelId(){
		return channelChannelId;
	}

	@Override
 	public String toString(){
		return 
			"CoAuthRequest2DTO{" + 
			"role = '" + role + '\'' + 
			",tokenId = '" + tokenId + '\'' + 
			",channel_channel_id = '" + channelChannelId + '\'' + 
			"}";
		}
}