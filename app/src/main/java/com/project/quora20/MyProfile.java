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
import com.project.quora20.dto.UserProfileDTO;
import com.project.quora20.entity.Ad;
import com.project.quora20.entity.OnClickRequest;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitAdInstance;
import com.project.quora20.retrofit.RetrofitUsersInstance;
import com.squareup.picasso.Picasso;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyProfile extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    QuoraRetrofitService quoraRetrofitService;
    public TextView userName;
    public ImageView userImageView;
    public TextView userEmail;
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
        SharedPreferences sharedPreferences = getSharedPreferences("LoginData", MODE_PRIVATE);
        String userId = sharedPreferences.getString("UserId", "");
        quoraRetrofitService = RetrofitUsersInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        Call<UserProfileDTO> callMyProfile = quoraRetrofitService.viewUser(userId);
        callMyProfile.enqueue(new Callback<UserProfileDTO>() {
            @Override
            public void onResponse(Call<UserProfileDTO> call, Response<UserProfileDTO> response) {
                UserProfileDTO user = response.body();
                userName = findViewById(R.id.profile_userName);
                userImageView = findViewById(R.id.profile_userProfileImage);
                userEmail = findViewById(R.id.profile_userEmail);
                followers = findViewById(R.id.profile_followersCount);
                following = findViewById(R.id.profile_followingCount);
                userScore = findViewById(R.id.profile_userScore);
                userLevel = findViewById(R.id.profile_userLevel);
                profile_adview = findViewById(R.id.profile_adview);
                profile_userCategory = findViewById(R.id.profile_userFavCategories);
                userName.setText(user.getName());
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

    void viewAds() {
        quoraRetrofitService = RetrofitAdInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        SharedPreferences sharedPreferences=getSharedPreferences("LoginData",MODE_PRIVATE);
        final String AccessToken=sharedPreferences.getString("AccessToken","");

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
