package com.project.quora20.dto;

import com.google.gson.annotations.SerializedName;


public class IdResponse {

	@SerializedName("id")
	private String id;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"NewPostResponse{" + 
			"id = '" + id + '\'' + 
			"}";
		}
}