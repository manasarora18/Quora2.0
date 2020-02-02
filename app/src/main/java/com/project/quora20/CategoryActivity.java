package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.project.quora20.adapter.CategoryAdapter;
import com.project.quora20.dto.CategoryRequestDTO;
import com.project.quora20.dto.CategoryResponseDTO;
import com.project.quora20.dto.CategoryUpdateRequest;
import com.project.quora20.entity.Question;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity implements CategoryAdapter.QuestionCommunication {
    private Integer categoryId;
    private RecyclerView categoryRecyclerView;
    private RecyclerView.Adapter categoryAdapter;
    List<Question>questionList;
    List<String> categoryList=new ArrayList<>();
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Intent catIntent=getIntent();
        categoryId=catIntent.getIntExtra("categoryId",1);

        switch (categoryId){
            case 1:
                //categoryList.clear();
                categoryList.add("Fiction");
                categoryList.add("Non-Fiction");
                categoryList.add("Poetry");
                categoryList.add("Short-stories");
                break;
            case 2:
                categoryList.clear();
                categoryList.add("Clothing");
                categoryList.add("Footwear");
                categoryList.add("Watches");
                categoryList.add("Accessories");
                break;
            case 3:
                categoryList.clear();
                categoryList.add("Coding");
                categoryList.add("Android");
                categoryList.add("iOS");
                break;
            case 4:
                categoryList.clear();
                categoryList.add("Bollywood");
                categoryList.add("Hollywood");
                categoryList.add("Tollywood");
                categoryList.add("Punjabi");
                break;
            case 5:
                categoryList.clear();
                categoryList.add("NorthIndian");
                categoryList.add("SouthIndian");
                categoryList.add("Italian");
                categoryList.add("Chinese");
                break;
            case 6:
                categoryList.clear();
                categoryList.add("Football");
                categoryList.add("Cricket");
                categoryList.add("Badminton");
                categoryList.add("Tennis");
                break;
        }

        System.out.println("In Category:"+categoryId);
        CategoryRequestDTO categoryRequestDTO=new CategoryRequestDTO();
        categoryRequestDTO.setListOfQuestionId(categoryList);

        getCategoryResultAPI(categoryRequestDTO);


    }

    private void getCategoryResultAPI(CategoryRequestDTO categoryRequestDTO){
        QuoraRetrofitService quoraRetrofitService=RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        Call<CategoryResponseDTO>call=quoraRetrofitService.getCategoryResult(categoryRequestDTO);
        call.enqueue(new Callback<CategoryResponseDTO>() {
            @Override
            public void onResponse(Call<CategoryResponseDTO> call, Response<CategoryResponseDTO> response) {
                questionList=response.body().getQuestionList();
                generateDataList(questionList);
                System.out.println("OnResponse CategoryQuestions");
            }
            @Override
            public void onFailure(Call<CategoryResponseDTO> call, Throwable t) {
                System.out.println("OnFailure CategoryQuestions:"+t.getMessage());
            }
        });
    }

    private void generateDataList(List<Question> questionList) {
        categoryRecyclerView=findViewById(R.id.cat_QuestionRecycler);
        sharedPreferences=getSharedPreferences("LoginData",MODE_PRIVATE);
        String userId=sharedPreferences.getString("UserId","");
        categoryAdapter=new CategoryAdapter(questionList,CategoryActivity.this,userId);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),1);
        categoryRecyclerView.setLayoutManager(gridLayoutManager);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(Question question) {
        Intent qaIntent=new Intent( CategoryActivity.this, QuestionAnswer.class);
        qaIntent.putExtra("QID",question.getQuestionId());
        qaIntent.putExtra("OrgId",question.getOrgId());
        qaIntent.putExtra("QuesBody",question.getQuestionBody());
        qaIntent.putExtra("BestAns",question.getBestAnswerId());
        qaIntent.putExtra("CategoryId",question.getCategoryId());
        startActivity(qaIntent);
    }
}
