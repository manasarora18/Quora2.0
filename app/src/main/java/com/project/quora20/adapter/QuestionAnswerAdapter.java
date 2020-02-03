package com.project.quora20.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.quora20.R;
import com.project.quora20.dto.IdResponse;
import com.project.quora20.entity.Answer;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionAnswerAdapter extends RecyclerView.Adapter<QuestionAnswerAdapter.QuestionAnswerViewHolder> {

    private Answer answerList;
    AnswerCommunication answerCommunication;
    private String userId;
    List<String>likedList=new ArrayList<>();
    List<String>dislikedList=new ArrayList<>();


    public QuestionAnswerAdapter(Answer answerList, AnswerCommunication answerCommunication,String userId) {
        this.answerList = answerList;
        this.answerCommunication=answerCommunication;
        this.userId=userId;
    }

    public static class QuestionAnswerViewHolder extends RecyclerView.ViewHolder {
        public TextView answerBody;
        TextView answerLike;
        TextView answerDislike;
        ImageView answerUserImage;
        ImageButton answerOrganizationImage;
        TextView answerTimeStamp;
        ImageButton answerLikeButton;
        ImageButton answerDislikeButton;
        ImageButton answerReport;
        ImageButton viewCommentsButton;

        public QuestionAnswerViewHolder(View view) {
            super(view);
            this.answerBody=view.findViewById(R.id.ans_userAnswerText);
            this.answerDislike = view.findViewById(R.id.ans_dislikesCount);
            this.answerLike = view.findViewById(R.id.ans_likesCount);
            this.answerUserImage = view.findViewById(R.id.ans_userImage);
            this.answerOrganizationImage=view.findViewById(R.id.ans_organisationImage);
            this.answerTimeStamp = view.findViewById(R.id.ans_answerTimeStamp);
            this.answerLikeButton = view.findViewById(R.id.ans_likeButton);
            this.answerDislikeButton = view.findViewById(R.id.ans_dislikeButton);
            this.answerReport = view.findViewById(R.id.que_reportAnswerButton);
            this.viewCommentsButton=view.findViewById(R.id.ans_viewCommentsButton);
        }
    }

    @NonNull
    @Override
    public QuestionAnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_recycler_items, parent, false);
        QuestionAnswerViewHolder questionAnswerViewHolder = new QuestionAnswerViewHolder(view);
        return questionAnswerViewHolder;
    }

    //LIKE CHECK
    private boolean LikeCheck(List<String> likedList) {

        boolean likedFlag = false;
        if (likedList!=null) {
            likedFlag = likedList.contains(userId);
        }
        return likedFlag;
    }

    //DISLIKE CHECK
    private boolean DislikeCheck(List<String> dislikedList) {

        boolean dislikedFlag = false;
        if (dislikedList!=null) {
            dislikedFlag=dislikedList.contains(userId);
        }
        return dislikedFlag;
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionAnswerViewHolder holder,final int position) {
        holder.answerLikeButton.setColorFilter(Color.parseColor("#000000"));
        holder.answerDislikeButton.setColorFilter(Color.parseColor("#000000"));

        holder.viewCommentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerCommunication.onClick(answerList,answerList.getAnswerList().get(position).getAnswerId(),position);

            }
        });

        holder.answerBody.setText(answerList.getAnswerList().get(position).getAnswerBody());
        holder.answerLike.setText(String.valueOf(answerList.getAnswerList().get(position).getLikeCount()));
        holder.answerDislike.setText(String.valueOf(answerList.getAnswerList().get(position).getDislikeCount()));

        //Parse Date to String
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        String date=formatter.format(answerList.getAnswerList().get(position).getDate());
        System.out.println("Date ="+date);

        holder.answerTimeStamp.setText(date);

        likedList = answerList.getAnswerList().get(position).getLikeUserList();
        dislikedList = answerList.getAnswerList().get(position).getDislikeUserList();

        if (LikeCheck(likedList)) {
            holder.answerLikeButton.setColorFilter(Color.parseColor("#0000FF"));
            holder.answerDislikeButton.setClickable(false);
            holder.answerLikeButton.setClickable(false);

        } else if (DislikeCheck(dislikedList)) {
            holder.answerDislikeButton.setColorFilter(Color.parseColor("#FF0000"));
            holder.answerDislikeButton.setClickable(false);
            holder.answerLikeButton.setClickable(false);
        } else {
            holder.answerLikeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuoraRetrofitService quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
                    Call<IdResponse> call = quoraRetrofitService.doLikeAns(answerList.getAnswerList().get(position).getAnswerId(), userId);
                    call.enqueue(new Callback<IdResponse>() {
                        @Override
                        public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
                            System.out.println("OnResponse LikeAnsQA");
                            holder.answerLikeButton.setClickable(false);
                            holder.answerDislikeButton.setClickable(false);
                            String likeCount = (String) holder.answerLike.getText();
                            Integer likeNo = Integer.parseInt(likeCount);
                            likeNo++;
                            holder.answerLike.setText(String.valueOf(likeNo));
                            holder.answerLikeButton.setColorFilter(Color.parseColor("#0000FF"));
                        }

                        @Override
                        public void onFailure(Call<IdResponse> call, Throwable t) {
                            System.out.println("OnFailure LikeAnsQA:" + t.getMessage());
                        }
                    });
                }
            });
            holder.answerDislikeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuoraRetrofitService quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
                    Call<IdResponse> call = quoraRetrofitService.doDislikeAns(answerList.getAnswerList().get(position).getAnswerId(), userId);
                    call.enqueue(new Callback<IdResponse>() {
                        @Override
                        public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
                            System.out.println("OnRespone DislikeAnsQA");
                            holder.answerLikeButton.setClickable(false);
                            holder.answerDislikeButton.setClickable(false);
                            String dislikeCount = (String) holder.answerDislike.getText();
                            Integer dislikeNo = Integer.parseInt(dislikeCount);
                            dislikeNo++;
                            holder.answerDislike.setText(String.valueOf(dislikeNo));
                            holder.answerDislikeButton.setColorFilter(Color.parseColor("#FF0000"));
                        }

                        @Override
                        public void onFailure(Call<IdResponse> call, Throwable t) {
                            System.out.println("OnFailure DislikeAns" + t.getMessage());
                        }
                    });
                }
            });


        }
    }

    @Override
    public int getItemCount() {
        if (answerList != null)
            return answerList.getAnswerList().size();

        return 0;
    }

    public interface AnswerCommunication{
        void onClick(Answer answer,String answerId,int position);
    }


}
