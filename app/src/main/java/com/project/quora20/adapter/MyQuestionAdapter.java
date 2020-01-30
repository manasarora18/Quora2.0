package com.project.quora20.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.quora20.R;

import java.util.List;

public class MyQuestionAdapter extends RecyclerView.Adapter<MyQuestionAdapter.MyQuestionViewHolder> {

    private List<Integer> demoList;

    public static class MyQuestionViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyQuestionViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.que_userQuestionText);
        }
    }

    public MyQuestionAdapter(List<Integer> myList) {
        demoList = myList;
    }


    @NonNull
    @Override
    public MyQuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_recycler_items, parent, false);
        MyQuestionViewHolder myQuestionViewHolder = new MyQuestionViewHolder(view);
        return myQuestionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyQuestionViewHolder holder, int position) {
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

