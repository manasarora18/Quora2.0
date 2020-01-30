package com.project.quora20.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.quora20.R;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder> {

    private List<Integer> demoList;

    public static class CommentsViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public CommentsViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.comment_commentTextView);
        }
    }

    public CommentsAdapter(List<Integer> myList) {
        demoList = myList;
    }


    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_layout, parent, false);
        CommentsViewHolder commentsViewHolder = new CommentsViewHolder(view);
        return commentsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, int position) {
        int index = demoList.get(position);
        holder.textView.setText(String.valueOf(index));
    }

    @Override
    public int getItemCount() {
        if (demoList != null)
            return demoList.size();

        return 0;
    }

}
