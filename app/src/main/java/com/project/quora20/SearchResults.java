package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.quora20.adapter.SearchAdapter;
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
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
