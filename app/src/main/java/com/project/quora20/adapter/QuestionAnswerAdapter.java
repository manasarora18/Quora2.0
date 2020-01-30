package com.project.quora20.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.quora20.R;

import java.util.List;

public class QuestionAnswerAdapter extends RecyclerView.Adapter<QuestionAnswerAdapter.QuestionAnswerViewHolder> {

    private List<Integer> demoList;

    public static class QuestionAnswerViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public QuestionAnswerViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.qa_answerText);
        }
    }

    public QuestionAnswerAdapter(List<Integer> myList) {
        demoList = myList;
    }


    @NonNull
    @Override
    public QuestionAnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_layout, parent, false);
        QuestionAnswerViewHolder questionAnswerViewHolder = new QuestionAnswerViewHolder(view);
        return questionAnswerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAnswerViewHolder holder, int position) {
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
