package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.quora20.adapter.MyAnswerAdapter;
import com.project.quora20.entity.Answer;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;

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
    public String updateLikes(String answerId) {

        quoraRetrofitService= RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);

        Call<String> callAnswer=quoraRetrofitService.likeAnswer("123");
        callAnswer.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                adapter = new MyAnswerAdapter(answerList,MyAnswers.this);
                recyclerView.setAdapter(adapter);
                System.out.println("Inside OnResponse Answer");

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                System.out.println("Inside OnFailure Answer");

            }
        });
        return "123";
    }

    @Override
    public String updateDislikes(String answerId)
    {
       /* Call<String> callAnswer=quoraRetrofitService.dislikeAnswer("123");
        callAnswer.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                adapter = new MyAnswerAdapter(answerList,MyAnswers.this);
                recyclerView.setAdapter(adapter);
                System.out.println("Inside OnResponse Answer");

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                System.out.println("Inside OnFailure Answer");

            }
        });*/

        return "123";
    }

}
