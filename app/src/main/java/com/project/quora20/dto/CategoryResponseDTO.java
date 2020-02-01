package com.project.quora20.dto;

import com.google.gson.annotations.SerializedName;
import com.project.quora20.entity.Question;

import java.util.List;

public class CategoryResponseDTO {
    @SerializedName("questionList")
    List<Question> questionList;

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
