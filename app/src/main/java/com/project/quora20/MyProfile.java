package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.project.quora20.adapter.MyProfileAdapter;
import com.project.quora20.entity.User;

import java.util.ArrayList;
import java.util.List;

public class MyProfile extends AppCompatActivity {

    List<User> list;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        viewProfile();
    }

    void viewProfile()
    {
        adapter=new MyProfileAdapter(list);
    }
//    void viewQuestions()
//    {
//        List<Integer> list=new ArrayList<>();
//        for(int i=0;i<10;i++)
//            list.add(i);
//
//        recyclerView.setLayoutManager(questionLayoutManager);
//        recyclerView.setHasFixedSize(true);
//        adapter=new MyProfileAdapter(list);
//        recyclerView.setAdapter(adapter);
//    }
}
