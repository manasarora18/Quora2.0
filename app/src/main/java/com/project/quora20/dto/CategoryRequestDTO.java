package com.project.quora20.dto;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CategoryRequestDTO{

	@SerializedName("listOfQuestionId")
	private List<String> listOfQuestionId;

	public void setListOfQuestionId(List<String> listOfQuestionId){
		this.listOfQuestionId = listOfQuestionId;
	}

	public List<String> getListOfQuestionId(){
		return listOfQuestionId;
	}

	@Override
 	public String toString(){
		return 
			"CategoryRequestDTO{" + 
			"listOfQuestionId = '" + listOfQuestionId + '\'' + 
			"}";
		}
}