package com.project.quora20.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.quora20.R;
import com.project.quora20.dto.IdResponse;
import com.project.quora20.entity.Question;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private List<Question> questionList;
    private QuestionCommunication questionCommunication;
    private String userId;



    public HomeAdapter(List<Question> questionList, QuestionCommunication questionCommunication,String userId) {
        this.questionList = questionList;
        this.questionCommunication = questionCommunication;
        this.userId=userId;

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
            this.organizationImage=view.findViewById(R.id.home_organizationImage);
        }
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.home_recycler_items, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeViewHolder holder, final int position) {


        holder.viewMoreAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionCommunication.onClick(questionList.get(position));
            }
        });

        holder.questionBody.setText(questionList.get(position).getQuestionBody());
        holder.questionLike.setText(String.valueOf(questionList.get(position).getLikeCount()));
        holder.questionDislike.setText(String.valueOf(questionList.get(position).getDislikeCount()));

        holder.questionLikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuoraRetrofitService quoraRetrofitService= RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
                Call<IdResponse>call=quoraRetrofitService.doLikeQues(questionList.get(position).getQuestionId(),userId);
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
                    }

                    @Override
                    public void onFailure(Call<IdResponse> call, Throwable t) {
                        System.out.println("OnFailure LikeQues"+t.getMessage());
                    }
                });
            }
        });

        holder.questionDislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuoraRetrofitService quoraRetrofitService= RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
                Call<IdResponse>call=quoraRetrofitService.doDislikeQues(questionList.get(position).getQuestionId(),userId);
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
                    }

                    @Override
                    public void onFailure(Call<IdResponse> call, Throwable t) {
                        System.out.println("OnFailure DislikeQues"+t.getMessage());
                    }
                });
            }
        });
        holder.questionTimeStamp.setText(questionList.get(position).getDate());

        holder.organizationImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionCommunication.viewOrganization();
            }
        });
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
        void viewOrganization();
    }
}