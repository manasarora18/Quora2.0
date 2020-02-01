package com.project.quora20.dto;

import com.google.gson.annotations.SerializedName;

public class JWTGetDetailsResponse{

	@SerializedName("role")
	private String role;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private Long id;

	@SerializedName("email")
	private String email;

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"JWTGetDetailsResponse{" + 
			"role = '" + role + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}