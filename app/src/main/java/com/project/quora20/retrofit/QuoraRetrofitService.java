package com.project.quora20.retrofit;

import com.project.quora20.dto.AccessTokenRegisterResponse;
import com.project.quora20.dto.CoAuthRequestDTO;
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
//
    @POST("/auth/signup")
    Call <AccessTokenRegisterResponse> addUser(@Body CoAuthRequestDTO coAuthRequestDTO);

    @GET("/question/getLoginFeed/{userId}")
    Call <List<Question>> getAllQuestions(@Path("userId")String userId);

    @GET("/question/getCategoryFeed/{catId}")
    Call <List<Question>> getCategoryQuestions(@Path("catId")String catId);

//    @POST("/login-service/login")
//    Call<AccessTokenDTO> loginUser(@Body RegisterUser registerUser);

    @PUT("/answer/likeanswer/{answerId}")
    Call<String> likeAnswer(@Path("answerId") String answerId);

    @GET("/user/viewUser/{userId}")
    Call<User> viewUser(@Path("userId")String userId);

    @GET("organiaztion/viewOrganization/{organizationId}")
    Call<Organization> viewOrganization(@Path("organizationId") String organizationId);
  
    @POST("/question/add")
    Call<String> createNewPost(@Body NewPostRequestDTO newPostRequestDTO);

    @PUT("/question/likequestion/{qid}")
    Call<String> doLikeQues(@Path("qid")String qid);

    @PUT("/question/dislikequestion/{qid}")
    Call<String> doDislikeQues(@Path("qid")String qid);

//    @PUT("/answer/dislikeanswer/{answerId}")
//    Call<String> dislikeAnswer(@Path("answerId") String answerId);
}
//5e3140bb4c951a1723dc3f01

//OrgId: 5e3149d91edbf851280ccf51