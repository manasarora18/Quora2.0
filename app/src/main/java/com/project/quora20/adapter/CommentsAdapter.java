package com.project.quora20.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.quora20.R;
import com.project.quora20.dto.CommentListDto;

import org.w3c.dom.Text;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder> {

    private CommentListDto commentListDto;
    ICommentCommunication iCommentCommunication;
    boolean nestedCommentFlag;
    public static class CommentsViewHolder extends RecyclerView.ViewHolder {
        public TextView commentText;
        public TextView addCommentText;
        public ImageButton sendCommentButton;
       // public ImageButton childComments;
        public ImageButton viewChildCommentButton;
        public RecyclerView nestedCommentsRecycler;

        public CommentsViewHolder(View view) {
            super(view);
            commentText=view.findViewById(R.id.comment_commentTextView);//view comment

            addCommentText=view.findViewById(R.id.comment_addComment);//add new comment text
            sendCommentButton=view.findViewById(R.id.comment_sendCommentButton);
            viewChildCommentButton=view.findViewById(R.id.comment_childCommentsButton);
            nestedCommentsRecycler=view.findViewById(R.id.nested_commentList);
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
    public void onBindViewHolder(@NonNull final CommentsViewHolder holder, final int position) {
        //holder.nestedCommentsRecycler.getLayoutParams().width=0;
        //holder.nestedCommentsRecycler.getLayoutParams().height=0;

        System.out.println(commentListDto.getCommentList().get(position).getCommentBody());
        holder.commentText.setText(commentListDto.getCommentList().get(position).getCommentBody());
        //String answerId=commentListDto.getCommentList().get(position).getAnswerId();
        //iCommentCommunication.viewCommentsByAnswerId(answerId);

        holder.viewChildCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Inside child comment...");
                //Toast toast=Toast.makeText()
                //boolean flag=commentListDto.getCommentList().get(position).isExpanded();
                if(nestedCommentFlag)
                {
                    iCommentCommunication.viewNestedComments(position);

                    //holder.nestedCommentsRecycler.getLayoutParams().width=0;
                    holder.nestedCommentsRecycler.getLayoutParams().height=0;
                    nestedCommentFlag=false;
                }
                else {
                    holder.nestedCommentsRecycler.getLayoutParams().height = 400;
                    holder.nestedCommentsRecycler.getLayoutParams().width = 400;
                    nestedCommentFlag=true;
                }



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
        void viewNestedComments(int position);
    }


}
