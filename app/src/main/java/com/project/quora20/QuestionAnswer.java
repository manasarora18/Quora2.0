package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.quora20.adapter.QuestionAnswerAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuestionAnswer extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager answerLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);
        recyclerView=findViewById(R.id.answerListRecycler);
        answerLayoutManager=new LinearLayoutManager(this);
        viewAnswers();
    }
    void viewAnswers()
    {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<10;i++)
            list.add(i);

        recyclerView.setLayoutManager(answerLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter=new QuestionAnswerAdapter(list);
        recyclerView.setAdapter(adapter);


    }
}
