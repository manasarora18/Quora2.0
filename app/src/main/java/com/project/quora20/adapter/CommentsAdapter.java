package com.project.quora20.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.quora20.R;
import com.project.quora20.dto.CommentListDto;

import org.w3c.dom.Text;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder> {

    private CommentListDto commentListDto;
    ICommentCommunication iCommentCommunication;

    public static class CommentsViewHolder extends RecyclerView.ViewHolder {
        public TextView commentText;
        public TextView addCommentText;
        public ImageButton sendCommentButton;
       // public ImageButton childComments;
        public ImageButton viewChildCommentButton;

        public CommentsViewHolder(View view) {
            super(view);
            commentText=view.findViewById(R.id.comment_commentTextView);//view comment

            addCommentText=view.findViewById(R.id.comment_addComment);//add new comment text
            sendCommentButton=view.findViewById(R.id.comment_sendCommentButton);
            viewChildCommentButton=view.findViewById(R.id.comment_childCommentsButton);
        }
    }

    public CommentsAdapter(CommentListDto commentListDto,ICommentCommunication iCommentCommunication) {
        this.commentListDto = commentListDto;
        this.iCommentCommunication=iCommentCommunication;
    }


    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_recycler_items, parent, false);
        CommentsViewHolder commentsViewHolder = new CommentsViewHolder(view);
        return commentsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, final int position) {
        //int index = commentListDto.get(position);
        //holder.textView.setText(String.valueOf(index));
        System.out.println(commentListDto.getCommentList().get(position).getCommentBody());
        holder.commentText.setText(commentListDto.getCommentList().get(position).getCommentBody());
        //String answerId=commentListDto.getCommentList().get(position).getAnswerId();
        //iCommentCommunication.viewCommentsByAnswerId(answerId);

        holder.viewChildCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //boolean flag=commentListDto.getCommentList().get(position).isExpanded();
            }
        });



        holder.viewChildCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        if (commentListDto != null)
            return commentListDto.getCommentList().size();

        return 0;
    }

    public interface ICommentCommunication
    {
        void viewCommentsByAnswerId();
        //void addComments();
    }


}
