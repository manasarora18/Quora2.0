package com.project.quora20.dto;

import com.google.gson.annotations.SerializedName;


public class RoleDTO{

	@SerializedName("channel_channel_id")
	private long channelChannelId;

	@SerializedName("role")
	private String role;

	public void setChannelChannelId(long channelChannelId){
		this.channelChannelId = channelChannelId;
	}

	public long getChannelChannelId(){
		return channelChannelId;
	}

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	@Override
 	public String toString(){
		return 
			"RoleDTO{" + 
			"channel_channel_id = '" + channelChannelId + '\'' + 
			",role = '" + role + '\'' + 
			"}";
		}
}