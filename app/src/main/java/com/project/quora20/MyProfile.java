package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.quora20.entity.User;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        viewProfile();
    }


    void viewProfile()
    {
        //final User user;
        quoraRetrofitService= RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        Call<User> callMyProfile=quoraRetrofitService.viewUser("5e3140bb4c951a1723dc3f01");
        callMyProfile.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user=response.body();
                //adapter=new MyProfileAdapter(user);
                userName=findViewById(R.id.profile_userName);
                userImageView=findViewById(R.id.profile_userProfileImage);
                userEmail=findViewById(R.id.profile_userEmail);
                userPhone=findViewById(R.id.profile_userPhone);
                followers=findViewById(R.id.profile_followersCount);
                following=findViewById(R.id.profile_followingCount);
                userScore=findViewById(R.id.profile_userScore);
                userLevel=findViewById(R.id.profile_userLevel);

                userName.setText(user.getName());
                //userIamge with picasso
                //Picasso.with(getBaseContext())
                userEmail.setText(user.getUserEmail());
                //holder.userPhone.setText();
                followers.setText(String.valueOf(user.getFollowersCount()));
                following.setText(String.valueOf(user.getFollowingCount()));
                //userScore.setText("Score: "+String.valueOf(user.get()));



                System.out.println("Inside ViewProfile OnResponse");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Inside ViewProfile OnFailure");
            }
        });

    }
}
