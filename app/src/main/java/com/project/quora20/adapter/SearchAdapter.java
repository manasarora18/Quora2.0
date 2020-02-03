package com.project.quora20.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.quora20.R;
import com.project.quora20.dto.IdResponse;
import com.project.quora20.dto.SearchResponseQuestionDTO;
import com.project.quora20.entity.Question;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    List<SearchResponseQuestionDTO> questionSearchList;
    private String userId;
    private QuestionCommunication questionCommunication;

    public SearchAdapter(List<SearchResponseQuestionDTO>questionSearchList, QuestionCommunication questionCommunication, String userId){
        this.questionSearchList=questionSearchList;
        this.questionCommunication=questionCommunication;
        this.userId=userId;
    }
    public class SearchViewHolder extends RecyclerView.ViewHolder{
        TextView questionBody;
        ImageView questionUserImage;
        Button viewMoreAnswers;


        public SearchViewHolder(View view){
            super(view);
            this.questionBody = view.findViewById(R.id.searchq_userQuestionText);
            this.questionUserImage = view.findViewById(R.id.searchq_quesUserImage);
            this.viewMoreAnswers = view.findViewById(R.id.searchq_viewMoreAnswersButton);
        }
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.searchques_recycler_items,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchViewHolder holder, final int position) {

        holder.viewMoreAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question=new Question();
                question.setQuestionId(questionSearchList.get(position).getQuestionId());
                question.setQuestionBody(questionSearchList.get(position).getQuestionBody());
                questionCommunication.onClick(question);
            }
        });

        holder.questionBody.setText(questionSearchList.get(position).getQuestionBody());
    }

    @Override
    public int getItemCount() {
        if (questionSearchList != null) {
            return questionSearchList.size();
        }
        return 0;
    }

    public interface QuestionCommunication{
        void onClick(Question question);
    }
}
