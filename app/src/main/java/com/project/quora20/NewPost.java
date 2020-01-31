package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.project.quora20.dto.NewPostRequestDTO;
import com.project.quora20.dto.IdResponse;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewPost extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText questionBody;
    private NewPostRequestDTO newPostRequestDTO=new NewPostRequestDTO();
    private Button postButton;
    private EditText taggedPeople;
    private Spinner spinner;
    private static final String[] paths = {"Fiction Literature", "Non-Fiction Literature", "Poetry Literature","Short-stories Literature","Clothing Lifestyle","Footwear Lifestyle","Watches Lifestyle","Accessories Lifestyle","Coding","Android","iOS","Bollywood Movies","Hollywood Movies","Tollywood Movies","Punjabi Movies","NorthIndian Food","SouthIndian Food","Italian Food","Chinese","Football","Cricket","Badminton","Tennis"};
    private String categoryChoice;
    private String categoryId;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        sharedPreferences=getSharedPreferences("LoginData",MODE_PRIVATE);
        final String userId=sharedPreferences.getString("UserId","");
        final String orgId="";

        spinner = (Spinner)findViewById(R.id.category_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.category_paths,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        postButton=findViewById(R.id.new_postButton);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionBody=findViewById(R.id.new_questionBody);
                String question= String.valueOf(questionBody.getText());

                taggedPeople=findViewById(R.id.new_taggedpeople);
                String questionTags=String.valueOf(taggedPeople.getText());
                List<String>tagPeopleList=new ArrayList<>();
                tagPeopleList.add(questionTags);

                spinner = (Spinner)findViewById(R.id.category_spinner);
                categoryChoice=spinner.getSelectedItem().toString();
                newPostRequestDTO.setQuestionBody(question);
                newPostRequestDTO.setUserId(userId);
                newPostRequestDTO.setCategoryId(categoryChoice);
                newPostRequestDTO.setPersonsTag(tagPeopleList);

                if(!orgId.equals("")) {
                    newPostRequestDTO.setOrgId(orgId);
                }

                QuoraRetrofitService quoraRetrofitService= RetrofitClientInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
                Call<IdResponse> call=quoraRetrofitService.createNewPost(newPostRequestDTO);
                call.enqueue(new Callback<IdResponse>() {
                    @Override
                    public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
//                        if(response.code()==200){
                            Toast.makeText(getApplicationContext(),"New Post Created",Toast.LENGTH_SHORT).show();
                            Intent backToHome=new Intent(NewPost.this,MainActivity.class);
                            startActivity(backToHome);
                            finish();

//                        }
                    }
                    @Override
                    public void onFailure(Call<IdResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                        System.out.println("OnFailure NewPost:"+t.getMessage());
                    }
                });
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                categoryChoice="Fiction";
                categoryId="1";
//                Toast.makeText(getApplicationContext(),"Sports Selected",Toast.LENGTH_SHORT).show();
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                categoryChoice="Non-Fiction";
                categoryId="2";
//                Toast.makeText(getApplicationContext(),"Technology Selected",Toast.LENGTH_SHORT).show();
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                categoryChoice="Poetry";
                categoryId="3";
//                Toast.makeText(getApplicationContext(),"Lifestyle Selected",Toast.LENGTH_SHORT).show();
                // Whatever you want to happen when the thrid item gets selected
                break;
            case 3:
                categoryChoice="Short-stories";
                categoryId="4";
//                Toast.makeText(getApplicationContext(),"Food Selected",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                categoryChoice="Clothing";
                categoryId="5";
//                Toast.makeText(getApplicationContext(),"Movies Selected",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                categoryChoice="Footwear";
                categoryId="6";
                break;
            case 6:
                categoryChoice="Watches";
                categoryId="7";
//                Toast.makeText(getApplicationContext(),"Food Selected",Toast.LENGTH_SHORT).show();
                break;
            case 7:
                categoryChoice="Accessories";
                categoryId="8";
//                Toast.makeText(getApplicationContext(),"Movies Selected",Toast.LENGTH_SHORT).show();
                break;
            case 8:
                categoryChoice="Coding";
                categoryId="9";
                break;
            case 9:
                categoryChoice="Android";
                categoryId="10";
//                Toast.makeText(getApplicationContext(),"Food Selected",Toast.LENGTH_SHORT).show();
                break;
            case 10:
                categoryChoice="iOS";
                categoryId="11";
//                Toast.makeText(getApplicationContext(),"Movies Selected",Toast.LENGTH_SHORT).show();
                break;
            case 11:
                categoryChoice="Bollywood";
                categoryId="12";
                break;
            case 12:
                categoryChoice="Hollywood";
                categoryId="13";
//                Toast.makeText(getApplicationContext(),"Food Selected",Toast.LENGTH_SHORT).show();
                break;
            case 13:
                categoryChoice="Tollywood";
                categoryId="14";
//                Toast.makeText(getApplicationContext(),"Movies Selected",Toast.LENGTH_SHORT).show();
                break;
            case 14:
                categoryChoice="Punjabi";
                categoryId="15";
                break;
            case 15:
                categoryChoice="NorthIndian";
                categoryId="16";
//                Toast.makeText(getApplicationContext(),"Food Selected",Toast.LENGTH_SHORT).show();
                break;
            case 16:
                categoryChoice="SouthIndian";
                categoryId="17";
//                Toast.makeText(getApplicationContext(),"Movies Selected",Toast.LENGTH_SHORT).show();
                break;
            case 17:
                categoryChoice="Italian";
                categoryId="18";
                break;
            case 18:
                categoryChoice="Chinese";
                categoryId="19";
//                Toast.makeText(getApplicationContext(),"Food Selected",Toast.LENGTH_SHORT).show();
                break;
            case 19:
                categoryChoice="Football";
                categoryId="20";
//                Toast.makeText(getApplicationContext(),"Movies Selected",Toast.LENGTH_SHORT).show();
                break;
            case 20:
                categoryChoice="Cricket";
                categoryId="21";
                break;
            case 21:
                categoryChoice="Badminton";
                categoryId="22";
//                Toast.makeText(getApplicationContext(),"Food Selected",Toast.LENGTH_SHORT).show();
                break;
            case 22:
                categoryChoice="Tennis";
                categoryId="23";
//                Toast.makeText(getApplicationContext(),"Movies Selected",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}
