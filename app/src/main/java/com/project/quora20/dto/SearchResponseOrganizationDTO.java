package com.project.quora20.dto;

import com.google.gson.annotations.SerializedName;

public class SearchResponseOrganizationDTO{

	@SerializedName("organizationId")
	private String organizationId;

	@SerializedName("flag")
	private boolean flag;

	@SerializedName("organizationName")
	private String organizationName;

	@SerializedName("organizationImage")
	private String organizationImage;

	public void setOrganizationId(String organizationId){
		this.organizationId = organizationId;
	}

	public String getOrganizationId(){
		return organizationId;
	}

	public void setFlag(boolean flag){
		this.flag = flag;
	}

	public boolean isFlag(){
		return flag;
	}

	public void setOrganizationName(String organizationName){
		this.organizationName = organizationName;
	}

	public String getOrganizationName(){
		return organizationName;
	}

	public void setOrganizationImage(String organizationImage){
		this.organizationImage = organizationImage;
	}

	public String getOrganizationImage(){
		return organizationImage;
	}

	@Override
 	public String toString(){
		return 
			"SearchResponseOrganizationDTO{" + 
			"organizationId = '" + organizationId + '\'' + 
			",flag = '" + flag + '\'' + 
			",organizationName = '" + organizationName + '\'' + 
			",organizationImage = '" + organizationImage + '\'' + 
			"}";
		}
}