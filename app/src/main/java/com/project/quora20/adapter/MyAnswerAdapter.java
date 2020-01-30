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

import java.util.List;

public class MyAnswerAdapter extends RecyclerView.Adapter<MyAnswerAdapter.MyAnswerViewHolder> {

    private List<Integer> demoList;

    public static class MyAnswerViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageButton viewComments;

        public MyAnswerViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.ans_userAnswerText);
            viewComments = view.findViewById(R.id.ans_viewCommentsButton);
        }
    }

    public MyAnswerAdapter(List<Integer> myList) {
        demoList = myList;
    }


    @NonNull
    @Override
    public MyAnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_layout, parent, false);
        MyAnswerViewHolder myAnswerViewHolder = new MyAnswerViewHolder(view);
        return myAnswerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAnswerViewHolder holder, int position) {
        int index = demoList.get(position);
        holder.textView.setText(String.valueOf(index));
//        holder.viewComments.getRootView().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent commentIntent = new Intent(MyAnswers.this, ViewComments.class);
//                startActivity(commentIntent);
//
//            }
//        });

    }


    @Override
    public int getItemCount() {
        if (demoList != null)
            return demoList.size();

        return 0;
    }

}
