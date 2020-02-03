package com.project.quora20.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.quora20.R;
import com.project.quora20.dto.IdResponse;
import com.project.quora20.entity.Ad;
import com.project.quora20.entity.OnClickRequest;
import com.project.quora20.entity.Question;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitAdInstance;
import com.project.quora20.retrofit.RetrofitClientInstance;
import com.project.quora20.retrofit.RetrofitUsersInstance;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private List<Question> questionList;
    private QuestionCommunication questionCommunication;
    private String userId;
    List<String> likedList = new ArrayList<>();
    List<String> dislikedList = new ArrayList<>();
    List<Ad> adList=new ArrayList<>();
    OnClickRequest onClickRequest = new OnClickRequest();
    QuoraRetrofitService quoraRetrofitService;
    SharedPreferences sharedPreferences;
    String AccessToken;
    int adCounter;


    public HomeAdapter(List<Question> questionList, QuestionCommunication questionCommunication, String userId, String AccessToken) {
        this.questionList = questionList;
        this.questionCommunication = questionCommunication;
        this.userId = userId;
        this.AccessToken = AccessToken;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView questionBody;
        TextView questionLike;
        TextView questionDislike;
        ImageView questionUserImage;
        TextView questionTimeStamp;
        ImageButton questionLikeButton;
        ImageButton questionDislikeButton;
        Button viewMoreAnswers;
        ImageButton organizationImage;
        ImageView adView;

        public HomeViewHolder(View view) {
            super(view);
            this.questionBody = view.findViewById(R.id.home_userQuestionText);
            this.questionDislike = view.findViewById(R.id.home_quesdislikesCount);
            this.questionLike = view.findViewById(R.id.home_queslikesCount);
            this.questionUserImage = view.findViewById(R.id.home_quesUserImage);
            this.questionTimeStamp = view.findViewById(R.id.home_questionTimeStamp);
            this.questionLikeButton = view.findViewById(R.id.home_queslikeButton);
            this.questionDislikeButton = view.findViewById(R.id.home_quesdislikeButton);
            this.viewMoreAnswers = view.findViewById(R.id.home_viewMoreAnswersButton);
            this.organizationImage = view.findViewById(R.id.home_organizationImage);
            this.adView = view.findViewById(R.id.home_adView);
        }
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.home_recycler_items, parent, false);
        return new HomeViewHolder(view);
    }

    //LIKE CHECK on Question
    private boolean LikeCheck(List<String> likedList) {

        boolean likedFlag = false;
        if (likedList != null) {
            likedFlag = likedList.contains(userId);
        }
        return likedFlag;
    }

    //DISLIKE CHECK on Question
    private boolean DislikeCheck(List<String> dislikedList) {

        boolean dislikedFlag = false;
        if (dislikedList != null) {
            dislikedFlag = dislikedList.contains(userId);
        }
        return dislikedFlag;
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeViewHolder holder, final int position) {

        holder.questionLikeButton.setColorFilter(Color.parseColor("#000000"));
        holder.questionDislikeButton.setColorFilter(Color.parseColor("#000000"));

        holder.viewMoreAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionCommunication.onClick(questionList.get(position));
            }
        });

        holder.questionBody.setText(questionList.get(position).getQuestionBody());
        holder.questionLike.setText(String.valueOf(questionList.get(position).getLikeCount()));
        holder.questionDislike.setText(String.valueOf(questionList.get(position).getDislikeCount()));
        holder.questionTimeStamp.setText(questionList.get(position).getDate());

        System.out.println("OrganizationId:" + questionList.get(position).getOrgId());

        if (questionList.get(position).getOrgId() != null) {
            holder.organizationImage.setVisibility(View.VISIBLE);
            holder.organizationImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    questionCommunication.viewOrganization(questionList.get(position).getOrgId());
                    System.out.println("Inside OrganizationId :" + questionList.get(position).getOrgId());
                }
            });
        } else {
            holder.organizationImage.setVisibility(View.INVISIBLE);
        }

        //view user profile on click
        holder.questionUserImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                questionCommunication.viewQuesUser(questionList.get(position).getUserId());
            }
        });

        likedList = questionList.get(position).getLikeUserList();
        dislikedList = questionList.get(position).getDislikeUserList();

        if (LikeCheck(likedList)) {
            holder.questionLikeButton.setColorFilter(Color.parseColor("#0000FF"));
            holder.questionDislikeButton.setClickable(false);
            holder.questionLikeButton.setClickable(false);

        } else if (DislikeCheck(dislikedList)) {
            holder.questionDislikeButton.setColorFilter(Color.parseColor("#FF0000"));
            holder.questionDislikeButton.setClickable(false);
            holder.questionLikeButton.setClickable(false);
        }
        else {

            holder.questionLikeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuoraRetrofitService quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
                    Call<IdResponse> call = quoraRetrofitService.doLikeQues(questionList.get(position).getQuestionId(), userId);
                    call.enqueue(new Callback<IdResponse>() {
                        @Override
                        public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
                            System.out.println("OnResponse LikeQues");
                            holder.questionLikeButton.setClickable(false);
                            holder.questionDislikeButton.setClickable(false);
                            String likeCount = (String) holder.questionLike.getText();
                            Integer likeNo = Integer.parseInt(likeCount);
                            likeNo++;
                            holder.questionLike.setText(String.valueOf(likeNo));
                            holder.questionLikeButton.setColorFilter(Color.parseColor("#0000FF"));
                        }

                        @Override
                        public void onFailure(Call<IdResponse> call, Throwable t) {
                            System.out.println("OnFailure LikeQues" + t.getMessage());
                        }
                    });
                }
            });

            holder.questionDislikeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuoraRetrofitService quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
                    Call<IdResponse> call = quoraRetrofitService.doDislikeQues(questionList.get(position).getQuestionId(), userId);
                    call.enqueue(new Callback<IdResponse>() {
                        @Override
                        public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
                            System.out.println("OnResponse DislikeQues");
                            holder.questionLikeButton.setClickable(false);
                            holder.questionDislikeButton.setClickable(false);
                            String dislikeCount = (String) holder.questionDislike.getText();
                            Integer dislikeNo = Integer.parseInt(dislikeCount);
                            dislikeNo++;
                            holder.questionDislike.setText(String.valueOf(dislikeNo));
                            holder.questionDislikeButton.setColorFilter(Color.parseColor("#FF0000"));
                        }

                        @Override
                        public void onFailure(Call<IdResponse> call, Throwable t) {
                            System.out.println("OnFailure DislikeQues" + t.getMessage());
                        }
                    });
                }
            });
        }
        holder.adView.getLayoutParams().width = 0;
        holder.adView.getLayoutParams().height = 0;

        if (position % 5 == 0 && position != 0) {
            quoraRetrofitService = RetrofitAdInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
            Call<List<Ad>> callAdList = quoraRetrofitService.getAds("Bearer " + AccessToken, 2L);
            callAdList.enqueue(new Callback<List<Ad>>() {
                @Override
                public void onResponse(Call<List<Ad>> call, Response<List<Ad>> response) {

                    if (response.body() != null) {
                        adList = response.body();
                        adCounter++;
                        if(adCounter>=adList.size()-1)
                        {
                            adCounter=0;
                        }
                        holder.adView.getLayoutParams().width = 500;
                        holder.adView.getLayoutParams().height = 400;
                        if (adList != null) {
                            Picasso.with(holder.adView.getContext()).load(adList.get(adCounter).getImageUrl()).resize(500, 400).centerCrop().into(holder.adView);
                        }
                        holder.adView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                questionCommunication.viewAds(adCounter, adList);
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

    @Override
    public int getItemCount() {
        if (questionList != null) {
            return questionList.size();
        }
        return 0;
    }


    public interface QuestionCommunication {
        void onClick(Question question);
        void viewOrganization(String organizationId);
//         void viewQuesUser(String userId);
        void viewAds(int position, List<Ad> adList);
    }


}