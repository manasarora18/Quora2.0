package com.project.quora20.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.quora20.R;
import com.project.quora20.entity.User;

import java.util.List;

public class MyProfileAdapter extends RecyclerView.Adapter<MyProfileAdapter.MyProfileViewHolder> {

    List<User> userList;

    public static class MyProfileViewHolder extends RecyclerView.ViewHolder{
        public TextView userName;
        public ImageView userImageView;
        public TextView userEmail;
        public TextView userPhone;
        public TextView followers;
        public TextView following;
        public TextView userScore;
        public TextView userLevel;

        public MyProfileViewHolder(View view)
        {
            super(view);
           // textView=view.findViewById(R.id.userQuestionText);
            userName=view.findViewById(R.id.profile_userName);
            userImageView=view.findViewById(R.id.profile_userProfileImage);
            userEmail=view.findViewById(R.id.profile_userEmail);
            userPhone=view.findViewById(R.id.profile_userPhone);
            followers=view.findViewById(R.id.profile_followersCount);
            following=view.findViewById(R.id.profile_followingCount);
            userScore=view.findViewById(R.id.profile_userScore);
            userLevel=view.findViewById(R.id.profile_userLevel);

        }
    }

    public MyProfileAdapter(List<User> myList)
    {
        userList=myList;
    }

    @NonNull
    @Override
    public MyProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.question_recycler_items,parent,false);
        MyProfileViewHolder myProfileViewHolder=new MyProfileViewHolder(view);
        return myProfileViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyProfileViewHolder holder, int position) {
        /*User user=userList.get(position);
        holder.userName.setText(user.getUserName());
        //userIamge with picasso
        holder.userEmail.setText(user.getUserEmail());
        //holder.userPhone.setText();
        holder.followers.setText(String.valueOf(user.getUserFollower().size()));
        holder.following.setText(String.valueOf(user.getUserFollowing().size()));
        holder.userScore.setText(String.valueOf(user.getUserScore()));*/


    }

    @Override
    public int getItemCount() {
        if(userList!=null)
            return userList.size();
        return 0;
    }


}
