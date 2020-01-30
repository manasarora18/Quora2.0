package com.project.quora20.retrofit;

import com.project.quora20.entity.AccessTokenRegisterResponse;
import com.project.quora20.entity.CoAuthRequestDTO;
import com.project.quora20.entity.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
}
//5e3140bb4c951a1723dc3f01