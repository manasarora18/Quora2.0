package com.project.quora20.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.quora20.MyAnswers;
import com.project.quora20.R;
import com.project.quora20.ViewComments;
import com.project.quora20.entity.Answer;

import java.util.List;

public class MyAnswerAdapter extends RecyclerView.Adapter<MyAnswerAdapter.MyAnswerViewHolder> {

    private List<Answer> demoList;
    public IAnswerCommunicator iAnswerCommunicator;

    public static class MyAnswerViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageButton viewComments;
        public ImageButton likeButton;
        public ImageButton dislikeButton;
        public TextView likeCount;
        public TextView dislikeCount;

        public MyAnswerViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.ans_userAnswerText);
            viewComments = view.findViewById(R.id.ans_viewCommentsButton);
            likeButton=view.findViewById(R.id.ans_likeButton);
            dislikeButton=view.findViewById(R.id.ans_dislikeButton);
            likeCount=view.findViewById(R.id.ans_likesCount);
            dislikeCount=view.findViewById(R.id.que_dislikesCount);

        }
    }

    public MyAnswerAdapter(List<Answer> myList, IAnswerCommunicator iAnswerCommunicator) {
        demoList = myList;
        this.iAnswerCommunicator=iAnswerCommunicator;
    }


    @NonNull
    @Override
    public MyAnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_layout, parent, false);
        MyAnswerViewHolder myAnswerViewHolder = new MyAnswerViewHolder(view);
        return myAnswerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAnswerViewHolder holder, int position) {

        final Answer answer=demoList.get(position);
        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.likeButton.setClickable(false);
                holder.dislikeButton.setClickable(false);
                int likes=answer.getLikeCount();
                likes++;
                holder.likeCount.setText(String.valueOf(likes));
                answer.setLikeCount(likes);
                iAnswerCommunicator.updateLikes(answer.getAnswerId());
            }
        });

        holder.dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.likeButton.setClickable(false);
                holder.dislikeButton.setClickable(false);
                int dislikes=answer.getDislikeCount();
                dislikes++;
                holder.dislikeCount.setText(String.valueOf(dislikes));
                answer.setDislikeCount(dislikes);
                iAnswerCommunicator.updateDislikes(answer.getAnswerId());
            }
        });

    }


    @Override
    public int getItemCount() {
        if (demoList != null)
            return demoList.size();

        return 0;
    }

    public interface IAnswerCommunicator {
        String updateLikes(String answerId);
        String updateDislikes(String answerId);
    }

}
