package com.project.quora20.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.quora20.R;
import java.util.List;

public class MyProfileAdapter extends RecyclerView.Adapter<MyProfileAdapter.MyProfileViewHolder> {

    List<Integer> list;

    public static class MyProfileViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public MyProfileViewHolder(View view)
        {
            super(view);
           // textView=view.findViewById(R.id.userQuestionText);
        }
    }

    public MyProfileAdapter(List<Integer> myList)
    {
        list=myList;
    }

    @NonNull
    @Override
    public MyProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.question_recycler_items,parent,false);
        MyProfileViewHolder myProfileViewHolder=new MyProfileViewHolder(view);
        return myProfileViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyProfileViewHolder holder, int position) {
        int index=list.get(position);
        holder.textView.setText(String.valueOf(index));

    }

    @Override
    public int getItemCount() {
        if(list!=null)
            return list.size();
        return 0;
    }
}
