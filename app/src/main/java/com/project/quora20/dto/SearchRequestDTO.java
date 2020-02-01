package com.project.quora20.dto;

import com.google.gson.annotations.SerializedName;

public class SearchRequestDTO{

	@SerializedName("searchTerm")
	private String searchTerm;

	public void setSearchTerm(String searchTerm){
		this.searchTerm = searchTerm;
	}

	public String getSearchTerm(){
		return searchTerm;
	}

	@Override
 	public String toString(){
		return 
			"SearchRequestDTO{" + 
			"searchTerm = '" + searchTerm + '\'' + 
			"}";
		}
}