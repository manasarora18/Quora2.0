package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.quora20.dto.UserDTO;
import com.project.quora20.dto.UserProfileDTO;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitUsersInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtherUserProfile extends AppCompatActivity {

    QuoraRetrofitService quoraRetrofitService;
    public TextView userName;
    public ImageView userImageView;
    public TextView userEmail;
    //public TextView userPhone;
    public TextView followers;
    public TextView following;
    public TextView userScore;
    public TextView userLevel;
    public TextView profile_userCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_user_profile);

        Intent otherUser=getIntent();
        String userId=otherUser.getStringExtra("OtherUserId");
        viewOtherUserProfile(userId);
    }

    void viewOtherUserProfile(String userId)
    {
        quoraRetrofitService = RetrofitUsersInstance.getRetrofitInstance().create(QuoraRetrofitService.class);

        Call<UserProfileDTO> callMyProfile = quoraRetrofitService.viewUser(userId);


        callMyProfile.enqueue(new Callback<UserProfileDTO>() {
            @Override
            public void onResponse(Call<UserProfileDTO> call, Response<UserProfileDTO> response) {
                UserProfileDTO user = response.body();
                userName = findViewById(R.id.other_userName);
                userImageView = findViewById(R.id.other_userProfileImage);
                userEmail = findViewById(R.id.other_userEmail);
                followers = findViewById(R.id.other_followersCount);
                following = findViewById(R.id.other_followingCount);
                userScore = findViewById(R.id.other_userScore);
                userLevel = findViewById(R.id.other_userLevel);
                //profile_adview = findViewById(R.id.other__adview);
                profile_userCategory = findViewById(R.id.other_userFavCategories);
                userName.setText(user.getName());
                userScore.setText(String.valueOf(user.getScore()));

                userEmail.setText(user.getUserEmail());
                //holder.userPhone.setText();
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
            public void onFailure(Call<UserProfileDTO> call, Throwable t) {
                System.out.println("Inside ViewProfile OnFailure");
            }
        });

    }
}
