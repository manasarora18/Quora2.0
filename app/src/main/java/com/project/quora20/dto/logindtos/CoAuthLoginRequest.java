package com.project.quora20.dto.logindtos;

import com.google.gson.annotations.SerializedName;

public class CoAuthLoginRequest{

	@SerializedName("password")
	private String password;

	@SerializedName("email")
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
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
			"CoAuthLoginRequest{" + 
			"password = '" + password + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}