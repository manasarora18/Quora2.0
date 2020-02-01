package com.project.quora20.retrofit;

import com.project.quora20.dto.AccessTokenRegisterResponse;
import com.project.quora20.dto.AnswerDTO;
import com.project.quora20.dto.CoAuthRequestDTO;
import com.project.quora20.dto.CommentDTO;
import com.project.quora20.dto.CommentListDto;
import com.project.quora20.dto.IdResponse;
import com.project.quora20.entity.Answer;
import com.project.quora20.entity.Organization;
import com.project.quora20.dto.NewPostRequestDTO;
import com.project.quora20.entity.Question;
import com.project.quora20.entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface QuoraRetrofitService {

//    @GET("/login-service/profile/{userId}")
//    Call<UserDTO> getUserProfile(@Path("userId") String userId);

    @POST("/auth/signup")
    Call <AccessTokenRegisterResponse> addUser(@Body CoAuthRequestDTO coAuthRequestDTO);

    @GET("/question/getLoginFeed/{userId}")
    Call <List<Question>> getAllQuestions(@Path("userId")String userId);

    @GET("/question/getCategoryFeed/{catId}")
    Call <List<Question>> getCategoryQuestions(@Path("catId")String catId);

    @PUT("/answer/likeanswer/{answerId}")
    Call<String> likeAnswer(@Path("answerId") String answerId);

    @POST("/answer/add")
    Call<IdResponse> addAnswer(@Body AnswerDTO answerDTO);

    @GET("/answer/getAnswersByQuestionId/{questionId}")
    Call<Answer> getAnswersByQuestionId(@Path("questionId")String questionId);

    @GET("/user/viewUser/{userId}")
    Call<User> viewUser(@Path("userId")String userId);

    @GET("organiaztion/viewOrganization/{organizationId}")
    Call<Organization> viewOrganization(@Path("organizationId") String organizationId);
  
    @POST("/question/add")
    Call <IdResponse> createNewPost(@Body NewPostRequestDTO newPostRequestDTO);

    @PUT("/question/likequestion/{questionId}/{userId}")
    Call<IdResponse> doLikeQues(@Path("questionId")String qid,@Path("userId")String userId);

    @PUT("/question/dislikequestion/{questionId}/{userId}")
    Call<IdResponse> doDislikeQues(@Path("questionId")String qid,@Path("userId")String userId);

    @PUT("/answer/likeanswer/{answerId}/{userId}")
    Call<IdResponse> doLikeAns(@Path("answerId")String answerId,@Path("userId")String userId);

    @PUT("/answer/dislikeanswer/{answerId}/{userId}")
    Call<IdResponse> doDislikeAns(@Path("answerId")String answerId,@Path("userId")String userId);

    @POST("/comment/addcomment")
    Call<IdResponse> addComment(@Body CommentDTO commentDTO);

    @GET("/comment/getcommentbyanswer/{answerId}")
    Call<CommentListDto> viewCommentsByAnswerId(@Path("answerId")String answerId);

    @GET("/comment/getcommentbyparent/{parentId}")
    Call<CommentListDto> viewCommentsByParentId(@Path("parentId")String parentId);

//    @PUT("/answer/dislikeanswer/{answerId}")
//    Call<String> dislikeAnswer(@Path("answerId") String answerId);

}

//5e3140bb4c951a1723dc3f01
//OrgId: 5e3149d91edbf851280ccf51