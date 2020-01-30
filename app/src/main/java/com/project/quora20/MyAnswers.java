package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.project.quora20.adapter.MyAnswerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyAnswers extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager myAnswerLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_answers);

        recyclerView = findViewById(R.id.ans_myAnswersRecycler);
        myAnswerLayoutManager = new LinearLayoutManager(this);
        viewAnswers();

    }
    void viewAnswers() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);

        recyclerView.setLayoutManager(myAnswerLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new MyAnswerAdapter(list);
        recyclerView.setAdapter(adapter);


    }

}
