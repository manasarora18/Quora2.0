package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.quora20.adapter.CommentsAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewComments extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager commentsLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comments);
        recyclerView = findViewById(R.id.commentsRecycler);
        commentsLayoutManager = new LinearLayoutManager(this);
        viewComments();

    }

    void viewComments() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);

        recyclerView.setLayoutManager(commentsLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new CommentsAdapter(list);
        recyclerView.setAdapter(adapter);


    }

}

