package com.project.quora20.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.quora20.R;
import com.project.quora20.ViewComments;
import com.project.quora20.dto.IdResponse;
import com.project.quora20.entity.Answer;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;

import java.text.SimpleDateFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAnswerAdapter extends RecyclerView.Adapter<MyAnswerAdapter.MyAnswerViewHolder> {

    private List<Answer> answerList;
    public IAnswerCommunicator iAnswerCommunicator;
    String userId;

    public MyAnswerAdapter(List<Answer> answerList, IAnswerCommunicator iAnswerCommunicator,String userId) {
        this.answerList = answerList;
        this.iAnswerCommunicator=iAnswerCommunicator;
        this.userId=userId;
    }

    public static class MyAnswerViewHolder extends RecyclerView.ViewHolder {
        private TextView answerBody;
        private ImageButton answerViewComments;
        private ImageButton answerLikeButton;
        private ImageButton answerDislikeButton;
        private TextView answerLikeCount;
        private TextView answerDislikeCount;
        private TextView answerTimestamp;
        private ImageView organisationImage;

        public MyAnswerViewHolder(View view) {
            super(view);
            answerBody = view.findViewById(R.id.ans_userAnswerText);
            answerViewComments = view.findViewById(R.id.ans_viewCommentsButton);
            answerLikeButton=view.findViewById(R.id.ans_likeButton);
            answerDislikeButton=view.findViewById(R.id.ans_dislikeButton);
            answerLikeCount=view.findViewById(R.id.ans_likesCount);
            answerDislikeCount=view.findViewById(R.id.ans_dislikesCount);
            answerTimestamp = view.findViewById(R.id.ans_answerTimeStamp);
            organisationImage=view.findViewById(R.id.ans_organisationImage);
        }
    }

    @NonNull
    @Override
    public MyAnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_recycler_items, parent, false);
        MyAnswerViewHolder myAnswerViewHolder = new MyAnswerViewHolder(view);
        return myAnswerViewHolder;
    }

    //LIKE CHECK
    private boolean LikeCheck(List<String>likedList){
        boolean likedFlag=false;
        for(String x:likedList){
            if(x.equals(userId)){
                likedFlag=true;
            }
        }
        return (likedFlag);
    }

    //DISLIKE CHECK
    private boolean DislikeCheck(List<String>dislikedList){
        boolean dislikedFlag=false;
        for(String x:dislikedList){
            if(x.equals(userId)){
                dislikedFlag=true;
            }
        }
        return dislikedFlag;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final MyAnswerViewHolder holder, final int position) {
        holder.answerViewComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iAnswerCommunicator.onClick(answerList.get(position));
            }
        });

        holder.answerBody.setText(answerList.get(position).getAnswerList().get(position).getAnswerBody());
        holder.answerLikeCount.setText(String.valueOf(answerList.get(position).getAnswerList().get(position).getLikeCount()));
        holder.answerDislikeCount.setText(String.valueOf(answerList.get(position).getAnswerList().get(position).getDislikeCount()));

        //Parse Date to String
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        String date=formatter.format(answerList.get(position).getAnswerList().get(position).getDate());
        System.out.println("Date ="+date);


        holder.answerTimestamp.setText(date);
        holder.organisationImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iAnswerCommunicator.viewOrganization();
            }
        });

        List<String>likedList=answerList.get(position).getAnswerList().get(position).getLikeUserList();
        List<String>dislikedList=answerList.get(position).getAnswerList().get(position).getDislikeUserList();

        if(LikeCheck(likedList)){
            holder.answerLikeButton.setBackgroundColor(R.color.blue);
            holder.answerDislikeButton.setClickable(false);
            holder.answerLikeButton.setClickable(false);

        }
        else if(DislikeCheck(dislikedList)){
            holder.answerDislikeButton.setBackgroundColor(R.color.red);
            holder.answerDislikeButton.setClickable(false);
            holder.answerLikeButton.setClickable(false);
        }
        else {
            holder.answerLikeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuoraRetrofitService quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
                    Call<IdResponse> call = quoraRetrofitService.doLikeQues(answerList.get(position).getAnswerList().get(position).getQuestionId(), userId);
                    call.enqueue(new Callback<IdResponse>() {
                        @Override
                        public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
                            System.out.println("OnResponse LikeAns");
                            holder.answerLikeButton.setClickable(false);
                            holder.answerDislikeButton.setClickable(false);
                            String likeCount = (String) holder.answerLikeCount.getText();
                            Integer likeNo = Integer.parseInt(likeCount);
                            likeNo++;
                            holder.answerLikeCount.setText(String.valueOf(likeNo));
                            holder.answerLikeButton.setBackgroundColor(R.color.blue);
                        }

                        @Override
                        public void onFailure(Call<IdResponse> call, Throwable t) {
                            System.out.println("OnFailure LikeAns" + t.getMessage());
                        }
                    });
                }
            });
            holder.answerDislikeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuoraRetrofitService quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
                    Call<IdResponse> call = quoraRetrofitService.doDislikeQues(answerList.get(position).getAnswerList().get(position).getQuestionId(), userId);
                    call.enqueue(new Callback<IdResponse>() {
                        @Override
                        public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
                            System.out.println("OnResponse DislikeAns");
                            holder.answerLikeButton.setClickable(false);
                            holder.answerDislikeButton.setClickable(false);
                            String dislikeCount = (String) holder.answerDislikeCount.getText();
                            Integer dislikeNo = Integer.parseInt(dislikeCount);
                            dislikeNo++;
                            holder.answerDislikeCount.setText(String.valueOf(dislikeNo));
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
            return answerList.size();

        return 0;
    }

    public interface IAnswerCommunicator {
        void onClick(Answer answer);
        void viewOrganization();
    }

}
