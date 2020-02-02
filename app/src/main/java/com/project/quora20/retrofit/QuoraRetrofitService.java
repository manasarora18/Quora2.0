package com.project.quora20.retrofit;

import com.project.quora20.dto.CategoryRequestDTO;
import com.project.quora20.dto.AccessTokenLoginResponse;
import com.project.quora20.dto.AnswerDTO;
import com.project.quora20.dto.CategoryResponseDTO;
import com.project.quora20.dto.CoAuthLoginRequest;
import com.project.quora20.dto.CommentDTO;
import com.project.quora20.dto.CommentListDto;
import com.project.quora20.dto.IdResponse;
import com.project.quora20.entity.Ad;
import com.project.quora20.dto.CategoryUpdateRequest;
import com.project.quora20.dto.CoAuthRegisterRequest;
import com.project.quora20.dto.JWTGetDetailsRequest;
import com.project.quora20.dto.JWTGetDetailsResponse;
import com.project.quora20.dto.RegisterResponse;
import com.project.quora20.dto.RoleDTO;
import com.project.quora20.dto.RoleResponseDTO;
import com.project.quora20.dto.UserDTO;
import com.project.quora20.entity.Answer;
import com.project.quora20.entity.OnClickRequest;
import com.project.quora20.entity.Organization;
import com.project.quora20.dto.NewPostRequestDTO;
import com.project.quora20.entity.Question;
import com.project.quora20.entity.User;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface QuoraRetrofitService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("/jwt/getUserDetails")
    Call <JWTGetDetailsResponse>getUserDetails(@Header("Authorization") String token,@Body JWTGetDetailsRequest jwtGetDetailsRequest);

    @POST("/auth/signup")
    Call <RegisterResponse> addUser(@Body CoAuthRegisterRequest coAuthRequestDTO);

    @POST("/auth/signin")
    Call<AccessTokenLoginResponse> loginUser(@Body CoAuthLoginRequest coAuthLoginRequest);

    @POST("/user/addUser")
    Call<String>registerOnQuora(@Body UserDTO userDTO);

    @POST("role/updateRole")
    Call<RoleResponseDTO>updateRole(@Header("Authorization") String token, @Body RoleDTO roleDTO);

    @POST("user/addCategories/{userId}")
    Call<Boolean>categoryUpdate(@Path("userId")String userId, @Body CategoryUpdateRequest categoryUpdateRequest);


    @GET("/question/getLoginFeed/{userId}")
    Call <List<Question>> getAllQuestions(@Path("userId")String userId);

    @GET("/question/getCategoryFeed/{catId}")
    Call <List<Question>> getCategoryQuestions(@Path("catId")String catId);

    @POST("/question/getQuestionsbyCategory")
    Call<CategoryResponseDTO>getCategoryResult(@Body CategoryRequestDTO categoryRequestDTO);

    @PUT("/answer/likeanswer/{answerId}")
    Call<String> likeAnswer(@Path("answerId") String answerId);

    @POST("/answer/add")
    Call<IdResponse> addAnswer(@Body AnswerDTO answerDTO);

    @GET("/answer/getAnswersByQuestionId/{questionId}")
    Call<Answer> getAnswersByQuestionId(@Path("questionId")String questionId);

    @GET("/user/viewUser/{userId}")
    Call<UserDTO> viewUser(@Path("userId")String userId);

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

    @GET("/ads/getAds/{srcId}")
    Call<List<Ad>> getAds(@Header("Authorization")String accessToken,@Path("srcId")Long srcId);

    @POST("/ads/onclick/{srcId}")
    Call<String> adOnClick(@Header("Authorization")String accessToken, @Path("srcId")Long srcId, @Body OnClickRequest onClickRequest);

    @POST("/user/addFollowers/{ownId}/{followersId}")
    Call<Boolean> addFollowers(@Path("ownId")String ownId,@Path("followersId")String followersId);

    @POST("/user/addFollowersToOrganization/{ownId}/{organizationId}")
    Call<Boolean> addOrganizationFollowers(@Path("ownId") String ownId, @Path("organizationId") String organizationId);


}

//5e3140bb4c951a1723dc3f01
//OrgId: 5e3149d91edbf851280ccf51