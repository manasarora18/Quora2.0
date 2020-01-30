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
import com.project.quora20.entity.Answer;

import java.util.List;

public class QuestionAnswerAdapter extends RecyclerView.Adapter<QuestionAnswerAdapter.QuestionAnswerViewHolder> {

    private List<Answer>answerList;
    AnswerCommunication answerCommunication;

    public QuestionAnswerAdapter(List<Answer> answerList, AnswerCommunication answerCommunication) {
        this.answerList = answerList;
        this.answerCommunication=answerCommunication;
    }

    public static class QuestionAnswerViewHolder extends RecyclerView.ViewHolder {
        public TextView answerBody;
        TextView answerLike;
        TextView answerDislike;
        ImageView answerUserImage;
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

    @Override
    public void onBindViewHolder(@NonNull final QuestionAnswerViewHolder holder,final int position) {
        holder.viewCommentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerCommunication.onClick(answerList.get(position));
            }
        });

        holder.answerBody.setText(answerList.get(position).getAnswerBody());
        holder.answerLike.setText(String.valueOf(answerList.get(position).getLikeCount()));
        holder.answerDislike.setText(String.valueOf(answerList.get(position).getDislikeCount()));
        holder.answerLikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.answerLikeButton.setClickable(false);
                holder.answerDislikeButton.setClickable(false);
                String likeCount = (String) holder.answerLike.getText();
                Integer likeNo = Integer.parseInt(likeCount);
                likeNo++;
                holder.answerLike.setText(String.valueOf(likeNo));
            }
        });
        holder.answerDislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.answerLikeButton.setClickable(false);
                holder.answerDislikeButton.setClickable(false);
                String dislikeCount = (String) holder.answerDislike.getText();
                Integer dislikeNo = Integer.parseInt(dislikeCount);
                dislikeNo++;
                holder.answerDislike.setText(String.valueOf(dislikeNo));
            }
        });
//        holder.answerTimeStamp.setText(answerList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        if (answerList != null)
            return answerList.size();

        return 0;
    }

    public interface AnswerCommunication{
        void onClick(Answer answer);
    }


}
