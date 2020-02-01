package com.project.quora20.dto;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CategoryUpdateRequest{

	@SerializedName("categoryList")
	private List<String> categoryList;

	public void setCategoryList(List<String> categoryList){
		this.categoryList = categoryList;
	}

	public List<String> getCategoryList(){
		return categoryList;
	}

	@Override
 	public String toString(){
		return 
			"CategoryUpdateRequest{" + 
			"categoryList = '" + categoryList + '\'' + 
			"}";
		}
}