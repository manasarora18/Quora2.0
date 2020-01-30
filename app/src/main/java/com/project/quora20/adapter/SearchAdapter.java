package com.project.quora20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.quora20.R;
import com.project.quora20.entity.Question;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    List<Question> questionSearchList;
    private Context context;
    private QuestionCommunication questionCommunication;

    public SearchAdapter(List<Question>questionSearchList, QuestionCommunication questionCommunication){
        this.questionSearchList=questionSearchList;
        this.questionCommunication=questionCommunication;
    }
    public class SearchViewHolder extends RecyclerView.ViewHolder{
        TextView questionBody;

        public SearchViewHolder(View view){
            super(view);
            this.questionBody=view.findViewById(R.id.questionBody);
        }
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
//        View view=layoutInflater.inflate(R.layout.search_recycler_items,parent,false);
//        return new SearchViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, final int position) {
        holder.questionBody.getRootView() .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question=questionSearchList.get(position);
                if(question!=null) {
                   questionCommunication.onClick(questionSearchList.get(position));
                }
                System.out.println("NULL IN SEARCH");
            }
        });
        holder.questionBody.setText(questionSearchList.get(position).getQuestionBody());

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
