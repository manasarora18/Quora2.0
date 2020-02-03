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
import com.project.quora20.dto.SearchResponseQuestionDTO;
import com.project.quora20.entity.Question;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    List<SearchResponseQuestionDTO> questionSearchList;
    private String userId;
    private QuestionCommunication questionCommunication;
    List<String> likedList = new ArrayList<>();
    List<String> dislikedList = new ArrayList<>();

    public SearchAdapter(List<SearchResponseQuestionDTO>questionSearchList, QuestionCommunication questionCommunication, String userId){
        this.questionSearchList=questionSearchList;
        this.questionCommunication=questionCommunication;
        this.userId=userId;
    }
    public class SearchViewHolder extends RecyclerView.ViewHolder{
        TextView questionBody;
        ImageView questionUserImage;
        Button viewMoreAnswers;


        public SearchViewHolder(View view){
            super(view);
            this.questionBody = view.findViewById(R.id.searchq_userQuestionText);
            this.questionUserImage = view.findViewById(R.id.searchq_quesUserImage);
            this.viewMoreAnswers = view.findViewById(R.id.searchq_viewMoreAnswersButton);
        }
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.searchques_recycler_items,parent,false);
        return new SearchViewHolder(view);
    }

//    //LIKE CHECK
//    private boolean LikeCheck(List<String> likedList) {
//
//        boolean likedFlag = false;
//        if (likedList != null) {
//            likedFlag = likedList.contains(userId);
//        }
//        return likedFlag;
//    }
//
//    //DISLIKE CHECK
//    private boolean DislikeCheck(List<String> dislikedList) {
//
//        boolean dislikedFlag = false;
//        if (dislikedList != null) {
//            dislikedFlag = dislikedList.contains(userId);
//        }
//        return dislikedFlag;
//    }

    @Override
    public void onBindViewHolder(@NonNull final SearchViewHolder holder, final int position) {
//        holder.questionLikeButton.setColorFilter(Color.parseColor("#000000"));
//        holder.questionDislikeButton.setColorFilter(Color.parseColor("#000000"));

        holder.viewMoreAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question=new Question();
                question.setQuestionId(questionSearchList.get(position).getQuestionId());
                question.setQuestionBody(questionSearchList.get(position).getQuestionBody());
                questionCommunication.onClick(question);
            }
        });

        holder.questionBody.setText(questionSearchList.get(position).getQuestionBody());
//        holder.questionLike.setText(String.valueOf(questionSearchList.get(position).getLikeCount()));
//        holder.questionDislike.setText(String.valueOf(questionSearchList.get(position).getDislikeCount()));
//        holder.questionTimeStamp.setText(questionSearchList.get(position).getDate());

//        System.out.println("OrganizationId:" + questionSearchList.get(position).getOrgId());
//        if (questionSearchList.get(position).getOrgId() != null) {
//            holder.organizationImage.setVisibility(View.VISIBLE);
//
//            holder.organizationImage.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    questionCommunication.viewOrganization(questionSearchList.get(position).getOrgId());
//                    System.out.println("Inside OrganizationId :" + questionSearchList.get(position).getOrgId());
//                }
//            });
//        } else {
//            holder.organizationImage.setVisibility(View.INVISIBLE);
//        }
//        holder.questionUserImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //questionCommunication.viewQuesUser(questionList.get(position).getUserId());
//
//            }
//        });

//        likedList = questionSearchList.get(position).getLikeUserList();
//        dislikedList = questionSearchList.get(position).getDislikeUserList();


//        if (LikeCheck(likedList)) {
//            holder.questionLikeButton.setColorFilter(Color.parseColor("#0000FF"));
//            holder.questionDislikeButton.setClickable(false);
//            holder.questionLikeButton.setClickable(false);
//
//        } else if (DislikeCheck(dislikedList)) {
//            holder.questionDislikeButton.setColorFilter(Color.parseColor("#FF0000"));
//            holder.questionDislikeButton.setClickable(false);
//            holder.questionLikeButton.setClickable(false);
//        }

//            holder.questionLikeButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    QuoraRetrofitService quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
//                    Call<IdResponse> call = quoraRetrofitService.doLikeQues(questionSearchList.get(position).getQuestionId(), userId);
//                    call.enqueue(new Callback<IdResponse>() {
//                        @Override
//                        public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
//                            System.out.println("OnResponse SeachLikeQues");
//                            holder.questionLikeButton.setClickable(false);
//                            holder.questionDislikeButton.setClickable(false);
//                            String likeCount = (String) holder.questionLike.getText();
//                            Integer likeNo = Integer.parseInt(likeCount);
//                            likeNo++;
//                            holder.questionLike.setText(String.valueOf(likeNo));
//                            holder.questionLikeButton.setColorFilter(Color.parseColor("#0000FF"));
//                        }
//
//                        @Override
//                        public void onFailure(Call<IdResponse> call, Throwable t) {
//                            System.out.println("OnFailure SearchLikeQues" + t.getMessage());
//                        }
//                    });
//                }
//            });
//
//            holder.questionDislikeButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    QuoraRetrofitService quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
//                    Call<IdResponse> call = quoraRetrofitService.doDislikeQues(questionSearchList.get(position).getQuestionId(), userId);
//                    call.enqueue(new Callback<IdResponse>() {
//                        @Override
//                        public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
//                            System.out.println("OnResponse SearchDislikeQues");
//                            holder.questionLikeButton.setClickable(false);
//                            holder.questionDislikeButton.setClickable(false);
//                            String dislikeCount = (String) holder.questionDislike.getText();
//                            Integer dislikeNo = Integer.parseInt(dislikeCount);
//                            dislikeNo++;
//                            holder.questionDislike.setText(String.valueOf(dislikeNo));
//                            holder.questionDislikeButton.setColorFilter(Color.parseColor("#FF0000"));
//                        }
//
//                        @Override
//                        public void onFailure(Call<IdResponse> call, Throwable t) {
//                            System.out.println("OnFailure SearchDislikeQues" + t.getMessage());
//                        }
//                    });
//                }
//            });
    }

    @Override
    public int getItemCount() {
        if (questionSearchList != null) {
            return questionSearchList.size();
        }
        return 0;
    }

    public interface QuestionCommunication{
        void onClick(Question question);
    }
}
