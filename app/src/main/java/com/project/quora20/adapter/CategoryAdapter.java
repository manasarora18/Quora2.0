package com.project.quora20.adapter;

import android.graphics.Color;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Question> questionList;
    private String userId;
    private QuestionCommunication questionCommunication;
    List<String>likedList=new ArrayList<>();
    List<String>dislikedList=new ArrayList<>();

    public CategoryAdapter(List<Question>questionList,QuestionCommunication questionCommunication,String userId){
        this.questionList=questionList;
        this.questionCommunication=questionCommunication;
        this.userId=userId;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView questionBody;
        TextView questionLike;
        TextView questionDislike;
        ImageView questionUserImage;
        TextView questionTimeStamp;
        ImageButton questionLikeButton;
        ImageButton questionDislikeButton;
        Button viewMoreAnswers;

        public CategoryViewHolder(View view){
            super(view);
            this.questionBody = view.findViewById(R.id.cat_userQuestionText);
            this.questionDislike = view.findViewById(R.id.cat_quesdislikesCount);
            this.questionLike = view.findViewById(R.id.cat_queslikesCount);
            this.questionUserImage = view.findViewById(R.id.cat_quesUserImage);
            this.questionTimeStamp = view.findViewById(R.id.cat_questionTimeStamp);
            this.questionLikeButton = view.findViewById(R.id.cat_queslikeButton);
            this.questionDislikeButton = view.findViewById(R.id.cat_quesdislikeButton);
            this.viewMoreAnswers = view.findViewById(R.id.cat_viewMoreAnswersButton);
        }
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cat_recycler_items,parent,false);
        return new CategoryViewHolder(view);
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
    public void onBindViewHolder(@NonNull final CategoryViewHolder holder, final int position) {
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

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        String date=formatter.format(questionList.get(position).getDate());
        System.out.println("Date ="+date);

        holder.questionTimeStamp.setText(date);

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
        } else {
            holder.questionLikeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuoraRetrofitService quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
                    Call<IdResponse> call = quoraRetrofitService.doLikeQues(questionList.get(position).getQuestionId(), userId);
                    call.enqueue(new Callback<IdResponse>() {
                        @Override
                        public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
                            System.out.println("OnResponse CategoryLikeQues");
                            holder.questionLikeButton.setClickable(false);
                            holder.questionDislikeButton.setClickable(false);
                            String likeCount = (String) holder.questionLike.getText();
                            Integer likeNo = Integer.parseInt(likeCount);
                            likeNo++;
                            holder.questionLike.setText(String.valueOf(likeNo));
                            holder.questionLikeButton.setColorFilter(Color.parseColor("#0000FF"));
//                            likedList.add(userId);
                        }

                        @Override
                        public void onFailure(Call<IdResponse> call, Throwable t) {
                            System.out.println("OnFailure CategoryLikeQues" + t.getMessage());
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
                            System.out.println("OnResponse CategoryDislikeQues");
                            holder.questionLikeButton.setClickable(false);
                            holder.questionDislikeButton.setClickable(false);
                            String dislikeCount = (String) holder.questionDislike.getText();
                            Integer dislikeNo = Integer.parseInt(dislikeCount);
                            dislikeNo++;
                            holder.questionDislike.setText(String.valueOf(dislikeNo));
                            holder.questionDislikeButton.setColorFilter(Color.parseColor("#FF0000"));
//                            dislikedList.add(userId);
                        }

                        @Override
                        public void onFailure(Call<IdResponse> call, Throwable t) {
                            System.out.println("OnFailure CategoryDislikeQues" + t.getMessage());
                        }
                    });
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (questionList!=null){
            return questionList.size();
        }
        return 0;
    }

    public interface QuestionCommunication{
        void onClick(Question question);
    }
}
