package com.project.quora20.entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Organization{

	@SerializedName("organizationId")
	private String organizationId;

	@SerializedName("oranizationImage")
	private String oranizationImage;

	@SerializedName("organizationFollowers")
	private List<String> organizationFollowers;

	@SerializedName("organizationName")
	private String organizationName;

	@SerializedName("organizationEmail")
	private String organizationEmail;

	@SerializedName("moderatorId")
	private String moderatorId;

	@SerializedName("organizationMembers")
	private List<Object> organizationMembers;

	public void setOrganizationId(String organizationId){
		this.organizationId = organizationId;
	}

	public String getOrganizationId(){
		return organizationId;
	}

	public void setOranizationImage(String oranizationImage){
		this.oranizationImage = oranizationImage;
	}

	public String getOranizationImage(){
		return oranizationImage;
	}

	public void setOrganizationFollowers(List<String> organizationFollowers){
		this.organizationFollowers = organizationFollowers;
	}

	public List<String> getOrganizationFollowers(){
		return organizationFollowers;
	}

	public void setOrganizationName(String organizationName){
		this.organizationName = organizationName;
	}

	public String getOrganizationName(){
		return organizationName;
	}

	public void setOrganizationEmail(String organizationEmail){
		this.organizationEmail = organizationEmail;
	}

	public String getOrganizationEmail(){
		return organizationEmail;
	}

	public void setModeratorId(String moderatorId){
		this.moderatorId = moderatorId;
	}

	public String getModeratorId(){
		return moderatorId;
	}

	public void setOrganizationMembers(List<Object> organizationMembers){
		this.organizationMembers = organizationMembers;
	}

	public List<Object> getOrganizationMembers(){
		return organizationMembers;
	}

	@Override
 	public String toString(){
		return 
			"Organization{" + 
			"organizationId = '" + organizationId + '\'' + 
			",oranizationImage = '" + oranizationImage + '\'' + 
			",organizationFollowers = '" + organizationFollowers + '\'' + 
			",organizationName = '" + organizationName + '\'' + 
			",organizationEmail = '" + organizationEmail + '\'' + 
			",moderatorId = '" + moderatorId + '\'' + 
			",organizationMembers = '" + organizationMembers + '\'' + 
			"}";
		}
}