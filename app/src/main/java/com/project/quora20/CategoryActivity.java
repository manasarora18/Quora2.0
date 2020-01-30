package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.project.quora20.adapter.CategoryAdapter;
import com.project.quora20.adapter.MyQuestionAdapter;
import com.project.quora20.entity.Question;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class CategoryActivity extends AppCompatActivity {
    private Integer categoryId;
    private RecyclerView categoryRecyclerView;
    private RecyclerView.Adapter categoryAdapter;
    GridLayoutManager gridLayoutManager;
    private RecyclerView.LayoutManager categoryQuestionLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Intent catIntent=getIntent();
        categoryId=catIntent.getIntExtra("categoryId",1);
        System.out.println("In Category:"+categoryId);

//        categoryRecyclerView=findViewById(R.id.cat_recycler_view);
//        categoryQuestionLayoutManager=new LinearLayoutManager(this);
//        categoryAdapter=new CategoryAdapter(CategoryActivity.this,list,CategoryActivity.this);
        QuoraRetrofitService quoraRetrofitService= RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
//        Call<List<Question>>call
        viewQuestions();

    }
    void viewQuestions() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);

//        recyclerView.setLayoutManager(myQuestionLayoutManager);
//        recyclerView.setHasFixedSize(true);
//        adapter = new MyQuestionAdapter(list);
//        recyclerView.setAdapter(adapter);


    }
}
