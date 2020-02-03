package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.quora20.dto.UserProfileDTO;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitUsersInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtherUserProfile extends AppCompatActivity {

    QuoraRetrofitService quoraRetrofitService;
    public TextView userName;
    public ImageView userImageView;
    public TextView userEmail;
    public TextView followers;
    public TextView following;
    public TextView userScore;
    public TextView userLevel;
    public TextView profile_userCategory;
    private String othersUserId;
    private String userId;
    private SharedPreferences sharedPreferences;
    private List<String> followinglist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_user_profile);

        Intent otherUser=getIntent();
        othersUserId=otherUser.getStringExtra("OtherUserId");
        viewOtherUserProfile(othersUserId);
        sharedPreferences=getSharedPreferences("LoginData",MODE_PRIVATE);
        userId=sharedPreferences.getString("UserId","");


        final Button follow=findViewById(R.id.other_FollowButton);
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                followAPI(userId,othersUserId);
                follow.setText("Following");
                follow.setClickable(false);
            }
        });

        QuoraRetrofitService quoraRetrofitService1=RetrofitUsersInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        Call<UserProfileDTO>call=quoraRetrofitService1.viewUser(userId);
        call.enqueue(new Callback<UserProfileDTO>() {
            @Override
            public void onResponse(Call<UserProfileDTO> call, Response<UserProfileDTO> response) {
                if(response.body()!=null){
                    followinglist=response.body().getFollowing();
                    for(String u:followinglist){
                        if(u.equals(othersUserId)){
                            follow.setClickable(false);
                            follow.setText("Following");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<UserProfileDTO> call, Throwable t) {

            }
        });


    }

    void followAPI(String userId,String othersUserId){
        QuoraRetrofitService quoraRetrofitService=RetrofitUsersInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        Call<Boolean>call=quoraRetrofitService.addFollowers(userId,othersUserId);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.body()){
                    System.out.println("OnResponse FollowUser True");
                }
                else {
                    System.out.println("OnResponse FollowUser False");
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println("OnFailure FollowUser"+t.getMessage());
            }
        });
    }

    void viewOtherUserProfile(String userId)
    {
        userName = findViewById(R.id.other_userName);
        userImageView = findViewById(R.id.other_userProfileImage);
        userEmail = findViewById(R.id.other_userEmail);
        followers = findViewById(R.id.other_followersCount);
        following = findViewById(R.id.other_followingCount);
        userScore = findViewById(R.id.other_userScore);
        userLevel = findViewById(R.id.other_userLevel);
        profile_userCategory = findViewById(R.id.other_userFavCategories);

        quoraRetrofitService = RetrofitUsersInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        Call<UserProfileDTO> callMyProfile = quoraRetrofitService.viewUser(userId);
        callMyProfile.enqueue(new Callback<UserProfileDTO>() {
            @Override
            public void onResponse(Call<UserProfileDTO> call, Response<UserProfileDTO> response) {
                UserProfileDTO user = response.body();

                if(user.getName()!=null) {
                    userName.setText(user.getName());
                }
                else
                {
                    userName.setText("");
                }
                userScore.setText(String.valueOf(user.getScore()));

                userEmail.setText(user.getUserEmail());
                if(user.getFollowersCount()!=0) {
                    followers.setText(String.valueOf(user.getFollowersCount()));
                }
                else
                {
                    followers.setText("0");
                }
                if(user.getFollowingCount()!=0) {
                    following.setText(String.valueOf(user.getFollowingCount()));
                }
                else{
                    following.setText("0");
                }
                System.out.println("Inside ViewProfile OnResponse");
            }

            @Override
            public void onFailure(Call<UserProfileDTO> call, Throwable t) {
                System.out.println("Inside ViewProfile OnFailure");
            }
        });

    }
}
