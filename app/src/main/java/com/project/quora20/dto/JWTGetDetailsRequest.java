package com.project.quora20.dto;

import com.google.gson.annotations.SerializedName;

public class JWTGetDetailsRequest{

	@SerializedName("provider")
	private long provider;

	public void setProvider(long provider){
		this.provider = provider;
	}

	public long getProvider(){
		return provider;
	}

	@Override
 	public String toString(){
		return 
			"JWTGetDetailsRequest{" + 
			"provider = '" + provider + '\'' + 
			"}";
		}
}