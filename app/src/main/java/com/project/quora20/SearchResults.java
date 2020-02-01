package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.project.quora20.adapter.SearchAdapter;
import com.project.quora20.dto.SearchRequestDTO;
import com.project.quora20.entity.Question;

public class SearchResults extends AppCompatActivity implements SearchAdapter.QuestionCommunication {
    private RecyclerView searchRecyclerView;
    private RecyclerView.Adapter searchAdapter;

    @Override
    public void onClick(Question question) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Intent intent=getIntent();
        String query=intent.getStringExtra("searchKey");
        SearchRequestDTO searchRequestDTO=new SearchRequestDTO();
        searchRequestDTO.setSearchTerm(query);


    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
