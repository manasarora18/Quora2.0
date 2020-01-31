package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.project.quora20.adapter.QuestionAnswerAdapter;
import com.project.quora20.dto.AnswerDTO;
import com.project.quora20.entity.Answer;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionAnswer extends AppCompatActivity implements QuestionAnswerAdapter.AnswerCommunication {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager qa_answerLayoutManager;
    QuoraRetrofitService quoraRetrofitService;
    List<Answer> answerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);
        recyclerView = findViewById(R.id.qa_answerListRecycler);
        qa_answerLayoutManager = new LinearLayoutManager(this);
        //final LinearLayout addAnswer = findViewById(R.id.addAnswerLayout);
        //addAnswer.onFoc
        /*addAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAnswer.setOnFocusChangeListener();
            }
        });*/
        Intent intent = getIntent();
//        String QID=intent.getStringExtra("QID");
//        String OrgId=intent.getStringExtra("OrgId");
//        String QuesBody=intent.getStringExtra("QuesBody");
//        String BestAns=intent.getStringExtra("BestAns");
//        String CategoryId=intent.getStringExtra("CategoryId");
        AnswerDTO answerdto = new AnswerDTO();
        answerdto.setQuestionId(intent.getStringExtra("QID"));
        answerdto.setOrgId(intent.getStringExtra("OrgId"));


        viewAnswers(answerdto);
    }

    @Override
    public void onClick(Answer answer) {

    }

    //view All answers by a particular QuestionId
    void viewAnswers(AnswerDTO answerDTO) {
        recyclerView.setLayoutManager(qa_answerLayoutManager);
        recyclerView.setHasFixedSize(true);
        quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        Call<List<Answer>> callAnswerList = quoraRetrofitService.getAnswersByQuestionId(answerDTO.getQuestionId());
        callAnswerList.enqueue(new Callback<List<Answer>>() {
            @Override
            public void onResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                answerList=response.body();
                adapter=new QuestionAnswerAdapter(answerList,QuestionAnswer.this);
                recyclerView.setAdapter(adapter);


                System.out.println("OnResponse View Answer By Qid");
            }

            @Override
            public void onFailure(Call<List<Answer>> call, Throwable t) {
                System.out.println("OnFailure View Answer By Qid");
            }
        });

        

    }
}
