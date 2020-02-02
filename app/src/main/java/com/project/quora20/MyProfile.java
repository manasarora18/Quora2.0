package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.quora20.adapter.MyProfileAdapter;
import com.project.quora20.dto.UserDTO;
import com.project.quora20.entity.Ad;
import com.project.quora20.entity.Category;
import com.project.quora20.entity.OnClickRequest;
import com.project.quora20.entity.User;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitAdInstance;
import com.project.quora20.retrofit.RetrofitClientInstance;
import com.project.quora20.retrofit.RetrofitUsersInstance;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyProfile extends AppCompatActivity {

    //List<User> list;
    private RecyclerView.Adapter adapter;
    QuoraRetrofitService quoraRetrofitService;
    public TextView userName;
    public ImageView userImageView;
    public TextView userEmail;
    public TextView userPhone;
    public TextView followers;
    public TextView following;
    public TextView userScore;
    public TextView userLevel;
    public ImageView profile_adview;
    public TextView profile_adDescription;
    public TextView profile_userCategory;
    List<Ad> adList;
    OnClickRequest onClickRequest = new OnClickRequest();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        viewProfile();
        viewAds();
    }


    void viewProfile() {
        //final User user;
        quoraRetrofitService = RetrofitUsersInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        SharedPreferences sharedPreferences = getSharedPreferences("LoginData", MODE_PRIVATE);
        String userId = sharedPreferences.getString("UserId", "");

        String otherUserId;
        Intent otherUser=getIntent();
        //otherUserId=otherUser.getStringExtra("QuesUserId").toString();
        //Call<User> callMyProfile = quoraRetrofitService.viewUser(userId);
        Call<UserDTO> callMyProfile = quoraRetrofitService.viewUser(userId);


        callMyProfile.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                UserDTO user = response.body();
                userName = findViewById(R.id.profile_userName);
                userImageView = findViewById(R.id.profile_userProfileImage);
                userEmail = findViewById(R.id.profile_userEmail);
                followers = findViewById(R.id.profile_followersCount);
                following = findViewById(R.id.profile_followingCount);
                userScore = findViewById(R.id.profile_userScore);
                userLevel = findViewById(R.id.profile_userLevel);
                profile_adview = findViewById(R.id.profile_adview);
                profile_userCategory = findViewById(R.id.profile_userFavCategories);
                userName.setText(user.getUserName());

                userEmail.setText(user.getUserEmail());
                //holder.userPhone.setText();
                if(user.getUserFollower()!=null) {
                    followers.setText(String.valueOf(user.getUserFollower().size()));
                }
                else
                {
                    followers.setText("0");
                }
                if(user.getUserFollowing()!=null) {
                    following.setText(String.valueOf(user.getUserFollowing().size()));
                }
                else{
                    following.setText("0");
                }
                userScore.setText("Score: " + String.valueOf(user.getUserScore()));

                //List<String> categories=user.getUserCategory();

                //System.out.println(user.getUserCategory());
               /* for(int i=0;i<user.getUserCategory().size();i++)
                {
                    String category=categories.get(i)+"\n";
                    profile_userCategory.setText(category);
                }*/
                System.out.println("Inside ViewProfile OnResponse");
            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {
                System.out.println("Inside ViewProfile OnFailure");
            }
        });


    }

    void viewAds() {
        quoraRetrofitService = RetrofitAdInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        SharedPreferences sharedPreferences=getSharedPreferences("LoginData",MODE_PRIVATE);
        final String AccessToken=sharedPreferences.getString("AccessToken","");
        //final String accessToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWQiOjIsIm5hbWUiOiJCaHVtaSIsImVtYWlsIjoiYmh1bWkucGF0ZWxAY292aWFtLmNvbSIsImlhdCI6MTU4MDQ2MzEzNSwiZXhwIjoxNTgxMzI3MTM1fQ.Vy-da5MWLd6CsGdGjP6EEwi6vvWSiCt3NfWhQX0I3ckwBINpQb2VPJ8xcMsrRYCHdIxxeSFKTgqc6KvPvfcVPQ";
//        SharedPreferences sharedPreferences=getSharedPreferences("LoginData",MODE_PRIVATE);
//        final String accessToken=sharedPreferences.getString("AccessToken","");
        Call<List<Ad>> callAdList = quoraRetrofitService.getAds("Bearer " + AccessToken, 2L);
        callAdList.enqueue(new Callback<List<Ad>>() {
            @Override
            public void onResponse(Call<List<Ad>> call, Response<List<Ad>> response) {

                profile_adview = findViewById(R.id.profile_adview);
                profile_adDescription = findViewById(R.id.profile_adDescription);

                if (response.body() != null) {
                    adList = response.body();
                    if(adList!=null) {
                        Picasso.with(profile_adview.getContext()).load(adList.get(0).getImageUrl()).resize(100, 100).centerCrop().into(profile_adview);
                        profile_adDescription.setText(adList.get(0).getDescription());
                    }
                    profile_adview.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences sharedPreferences = getSharedPreferences("LoginData", MODE_PRIVATE);
                            String userId = sharedPreferences.getString("UserId", "");

                            Intent viewIntent =
                                    new Intent("android.intent.action.VIEW",
                                            Uri.parse(adList.get(0).getTargetUrl()));
                            System.out.println("AD ID:" + adList.get(0).getAdId());
                            onClickRequest.setAdId(adList.get(0).getAdId());
                            onClickRequest.setAdvertiserId(adList.get(0).getAdvertiserId());
                            onClickRequest.setCategoryId(adList.get(0).getCategoryName());
                            onClickRequest.setDescription(adList.get(0).getDescription());
                            onClickRequest.setSource("Quora");
                            onClickRequest.setTag(adList.get(0).getTag());
                            onClickRequest.setTargetUrl(adList.get(0).getTargetUrl());
                            onClickRequest.setUserId(userId);

                            Call<String> callAdOnClick = quoraRetrofitService.adOnClick("Bearer " + AccessToken, 2L, onClickRequest);
                            callAdOnClick.enqueue(new Callback<String>() {
                                @Override
                                public void onResponse(Call<String> call, Response<String> response) {
                                    System.out.println("OnResponse Ad on click");
                                }

                                @Override
                                public void onFailure(Call<String> call, Throwable t) {
                                    System.out.println("OnFailure Ad on click" + t.getMessage());

                                }
                            });
                            startActivity(viewIntent);
                        }
                    });
                }
                System.out.println("onResponse Adview" + response.body());
            }

            @Override
            public void onFailure(Call<List<Ad>> call, Throwable t) {
                System.out.println("onFailure Adview" + t.getMessage());
            }
        });
    }
}
