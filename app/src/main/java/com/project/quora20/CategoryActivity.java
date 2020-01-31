package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.project.quora20.entity.Question;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {
    private Integer categoryId;
    private RecyclerView categoryRecyclerView;
    private RecyclerView.Adapter categoryAdapter;
    GridLayoutManager gridLayoutManager;
    private RecyclerView.LayoutManager categoryQuestionLayoutManager;
    List<Question>questionList;
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
        Call<List<Question>>call=quoraRetrofitService.getCategoryQuestions(String.valueOf(categoryId));
        call.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                if(response.code()==200){
                    questionList=response.body();
                    generateDataList(questionList);
                }
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {

            }
        });
        viewQuestions();
    }

    private void generateDataList(List<Question> questionList) {
        categoryQuestionLayoutManager=new LinearLayoutManager(this);
//        categoryAdapter=new CategoryAdapter(CategoryActivity.this,questionList,CategoryActivity.this);
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
