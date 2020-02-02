package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.project.quora20.adapter.QuestionAnswerAdapter;
import com.project.quora20.dto.AnswerDTO;
import com.project.quora20.dto.IdResponse;
import com.project.quora20.entity.Answer;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionAnswer extends AppCompatActivity implements QuestionAnswerAdapter.AnswerCommunication {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager qa_answerLayoutManager;
    private QuoraRetrofitService quoraRetrofitService;
    private SharedPreferences sharedPreferences;
    private Answer answerList;
    private TextView qa_questionText;
    private TextView qa_answerText;
    private ImageButton sendAnswerButton;
    private AnswerDTO answerdto = new AnswerDTO();
    String answerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);
        recyclerView = findViewById(R.id.qa_answerListRecycler);
        qa_answerLayoutManager = new LinearLayoutManager(this);

        Intent intent = getIntent();
//        String QID=intent.getStringExtra("QID");
//        String OrgId=intent.getStringExtra("OrgId");
//        String QuesBody=intent.getStringExtra("QuesBody");
//        String BestAns=intent.getStringExtra("BestAns");
//        String CategoryId=intent.getStringExtra("CategoryId");
        recyclerView.setLayoutManager(qa_answerLayoutManager);
        recyclerView.setHasFixedSize(true);

        //set answerDTO
        answerdto.setQuestionId(intent.getStringExtra("QID"));
        //answerdto.setOrgId(intent.getStringExtra("OrgId"));
        qa_questionText = findViewById(R.id.qa_questionText);
        qa_questionText.setText(intent.getStringExtra("QuesBody"));

        System.out.println("Qid: " + answerdto.getQuestionId());
        viewAnswers(answerdto.getQuestionId());

        sendAnswerButton = findViewById(R.id.qa_sendAnswerButton);
        sendAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addAnswers(answerdto);
                qa_answerText.setText("");
//                Toast toast = Toast.makeText(getApplicationContext(), "Answer posted ", Toast.LENGTH_SHORT);
//                toast.show();

                //reload the activity
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);

            }
        });
    }

    @Override
    public void onClick(Answer answer,String answerId) {
        Intent commentIntent=new Intent(QuestionAnswer.this,ViewComments.class);
        commentIntent.putExtra("AnswerId",answerId);
        //System.out.println("onclick:"+answerId);
        startActivity(commentIntent);

    }

    //view All answers by a particular QuestionId
    void addAnswers(AnswerDTO answerDTO) {


        sharedPreferences = getSharedPreferences("LoginData", MODE_PRIVATE);
        String userId = sharedPreferences.getString("UserId", "");
        answerDTO.setUserId(userId);

        qa_answerText = findViewById(R.id.qa_answerText);
        if(qa_answerText.getText().toString().trim().equals(""))
        {
            Toast toast=Toast.makeText(getApplicationContext(),"Please enter some text",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            answerDTO.setAnswerBody(qa_answerText.getText().toString());
            System.out.println("answer text:" + qa_answerText.getText().toString());
            System.out.println("answer body:" + answerDTO.getAnswerBody());

            quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
            System.out.println("Qid addAnswer: " + answerDTO);

            Call<IdResponse> callAddAnswer = quoraRetrofitService.addAnswer(answerDTO);
            callAddAnswer.enqueue(new Callback<IdResponse>() {
                @Override
                public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
                    if (response.body() != null) {
                        System.out.println("OnResponse Add Answer");
                        final String message = response.body().getId();
                        System.out.println("Message: " + message);
                    }
                }

                @Override
                public void onFailure(Call<IdResponse> call, Throwable t) {
                    System.out.println("OnFailure Add Answer" + t.getMessage());
                }
            });

        }

    }

    void viewAnswers(String questionId) {
        quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);


        Call<Answer> callAnswerList = quoraRetrofitService.getAnswersByQuestionId(questionId);
        callAnswerList.enqueue(new Callback<Answer>() {
            @Override
            public void onResponse(Call<Answer> call, Response<Answer> response) {
                answerList = response.body();
                sharedPreferences = getSharedPreferences("LoginData", MODE_PRIVATE);
                String userId = sharedPreferences.getString("UserId", "");
                System.out.println("Answer List: "+answerList);
                adapter = new QuestionAnswerAdapter(answerList, QuestionAnswer.this,userId);
                recyclerView.setAdapter(adapter);

                System.out.println("OnResponse View Answer By Qid");
            }

            @Override
            public void onFailure(Call<Answer> call, Throwable t) {
                System.out.println("OnFailure View Answer By Qid"+t.getMessage());
            }
        });

    }
}
