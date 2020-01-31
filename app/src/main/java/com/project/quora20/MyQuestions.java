package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.quora20.adapter.MyQuestionAdapter;
import com.project.quora20.entity.Question;

import java.util.ArrayList;
import java.util.List;

public class MyQuestions extends AppCompatActivity {

    private RecyclerView userRecyclerView;
    private RecyclerView.Adapter userAdapter;
    private RecyclerView.LayoutManager userQuestionLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_questions);

        userRecyclerView = findViewById(R.id.que_QuestionRecycler);
        userQuestionLayoutManager = new LinearLayoutManager(this);
        viewQuestions();

    }
    void viewQuestions() {
        List<Question> list = new ArrayList<>();

        userRecyclerView.setLayoutManager(userQuestionLayoutManager);
        userRecyclerView.setHasFixedSize(true);
        userAdapter = new MyQuestionAdapter(list);
        userRecyclerView.setAdapter(userAdapter);


    }

}
