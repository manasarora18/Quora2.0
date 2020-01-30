package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.quora20.adapter.MyQuestionAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyQuestions extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager myQuestionLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_questions);

        recyclerView = findViewById(R.id.que_QuestionRecycler);
        myQuestionLayoutManager = new LinearLayoutManager(this);
        viewQuestions();

    }
    void viewQuestions() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);

        recyclerView.setLayoutManager(myQuestionLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new MyQuestionAdapter(list);
        recyclerView.setAdapter(adapter);


    }

}
