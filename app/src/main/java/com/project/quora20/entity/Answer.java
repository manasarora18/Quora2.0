package com.project.quora20.entity;
import java.util.List;
import com.google.gson.annotations.SerializedName;
public class Answer{
  
   @SerializedName("answerList")
   private List<AnswerListItem> answerList;
   @SerializedName("question")
   private Question question;
   public void setAnswerList(List<AnswerListItem> answerList){
      this.answerList = answerList;
   }
   public List<AnswerListItem> getAnswerList(){
      return answerList;
   }
   public void setQuestion(Question question){
      this.question = question;
   }
   public Question getQuestion(){
      return question;
   }
   @Override
   public String toString(){
      return 
         "Answer{" + 
         "answerList = '" + answerList + '\'' + 
         ",question = '" + question + '\'' + 
         "}";
      }