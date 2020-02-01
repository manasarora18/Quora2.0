package com.project.quora20.dto;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.project.quora20.entity.Comment;


public class CommentListDto{

	@SerializedName("commentList")
	private List<Comment> commentList;

	public void setCommentList(List<Comment> commentList){
		this.commentList = commentList;
	}

	public List<Comment> getCommentList(){
		return commentList;
	}

	@Override
 	public String toString(){
		return 
			"CommentListDto{" + 
			"commentList = '" + commentList + '\'' + 
			"}";
		}
}