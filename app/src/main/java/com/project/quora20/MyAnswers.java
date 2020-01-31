package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.quora20.adapter.MyAnswerAdapter;
import com.project.quora20.entity.Answer;
import com.project.quora20.retrofit.QuoraRetrofitService;

import java.util.List;

public class MyAnswers extends AppCompatActivity implements MyAnswerAdapter.IAnswerCommunicator {

    private RecyclerView answerRecyclerView;
    private RecyclerView.Adapter answerAdapter;
    private RecyclerView.LayoutManager myAnswerLayoutManager;
    List<Answer> answerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_answers);

        answerRecyclerView = findViewById(R.id.ans_myAnswersRecycler);
        myAnswerLayoutManager = new LinearLayoutManager(this);
        answerRecyclerView.setLayoutManager(myAnswerLayoutManager);
        answerRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void onClick(Answer answer) {

    }

    @Override
    public void viewOrganization() {

    }
}
