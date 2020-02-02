package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.project.quora20.adapter.CommentsAdapter;
import com.project.quora20.dto.CommentDTO;
import com.project.quora20.dto.CommentListDto;
import com.project.quora20.dto.IdResponse;
import com.project.quora20.entity.Comment;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewComments extends AppCompatActivity implements CommentsAdapter.ICommentCommunication {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager commentsLayoutManager;
    QuoraRetrofitService quoraRetrofitService;
    //List<Comment> commentList;
    CommentListDto commentListDto;
    private SharedPreferences sharedPreferences;
    String answerId;
    ImageButton sendCommentButton;
    TextView commentText;
    CommentDTO commentDTO = new CommentDTO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comments);
        recyclerView = findViewById(R.id.commentsRecycler);
        commentsLayoutManager = new LinearLayoutManager(this);
        //viewComments();
        Intent answerIntent = getIntent();
        answerId = answerIntent.getStringExtra("AnswerId");
        viewCommentsByAnswerId();


        sendCommentButton = findViewById(R.id.comment_sendCommentButton);
        commentDTO.setAnswerId(answerId);
        commentDTO.setUserName(null);
        commentDTO.setParentId(null);

        sendCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComments(commentDTO);
                //reload the activity
                commentText.setText("");

                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });


    }

    @Override
    public void viewCommentsByAnswerId() {


        recyclerView.setLayoutManager(commentsLayoutManager);
        recyclerView.setHasFixedSize(true);

        sharedPreferences = getSharedPreferences("LoginData", MODE_PRIVATE);
        String userId = sharedPreferences.getString("UserId", "");

        //retrieving answerId from que-ans page

        //System.out.println("AnswerId:"+answerId);

        quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        Call<CommentListDto> callCommentList = quoraRetrofitService.viewCommentsByAnswerId(answerId);
        callCommentList.enqueue(new Callback<CommentListDto>() {
            @Override
            public void onResponse(Call<CommentListDto> call, Response<CommentListDto> response) {
                commentListDto = response.body();
                adapter = new CommentsAdapter(commentListDto, ViewComments.this);
                recyclerView.setAdapter(adapter);


                System.out.println("OnResponse ViewCommentsByAnswer");
            }

            @Override
            public void onFailure(Call<CommentListDto> call, Throwable t) {
                System.out.println("OnFailure ViewCommentsByAnswer: " + t.getMessage());

            }
        });


    }


    public void addComments(CommentDTO commentDTO) {
        //CommentDTO commentDTO=new CommentDTO();
        sharedPreferences = getSharedPreferences("LoginData", MODE_PRIVATE);
        String userId = sharedPreferences.getString("UserId", "");
        quoraRetrofitService = RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);

        commentText = findViewById(R.id.comment_addComment);
        System.out.println("Comment Text:" + commentText.getText().toString());
        commentDTO.setCommentBody(commentText.getText().toString());

        commentDTO.setUserId(userId);

        Call<IdResponse> callAddComment = quoraRetrofitService.addComment(commentDTO);
        System.out.println(commentDTO);
        callAddComment.enqueue(new Callback<IdResponse>() {
            @Override
            public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
                System.out.println("OnResponse addComments: " + response.body().getId());
                Toast toast = Toast.makeText(getApplicationContext(), "Comment posted ", Toast.LENGTH_SHORT);
                toast.show();

            }

            @Override
            public void onFailure(Call<IdResponse> call, Throwable t) {
                System.out.println("OnResponse addComments:" + t.getMessage());

            }
        });

    }

}

