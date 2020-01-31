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
import com.project.quora20.entity.Answer;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAnswers extends AppCompatActivity implements MyAnswerAdapter.IAnswerCommunicator {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager myAnswerLayoutManager;
    List<Answer> answerList;

    QuoraRetrofitService quoraRetrofitService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_answers);

        recyclerView = findViewById(R.id.ans_myAnswersRecycler);
        myAnswerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myAnswerLayoutManager);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onClick(Answer answer) {

    }

    @Override
    public void viewOrganization() {

    }
}
