package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.project.quora20.dto.CategoryUpdateRequest;
import com.project.quora20.dto.logindtos.TagsDAResponse;
import com.project.quora20.dto.RoleDTO;
import com.project.quora20.dto.RoleResponseDTO;
import com.project.quora20.dto.logindtos.TagsDARequest;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitDAInstance;
import com.project.quora20.retrofit.RetrofitLoginService;
import com.project.quora20.retrofit.RetrofitUsersInstance;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoraRegister extends AppCompatActivity {

    List<String>checkedList;
    private boolean failDA=true,failLogin=true,failQuora=true;
    private CheckBox Fiction,Non_Fiction,Poetry,Short_stories,Clothing,Footwear,Watches,Accessories,Coding,Android,iOS,Bollywood,Hollywood,Tollywood,Punjabi,NorthIndian,SouthIndian,Italian,Chinese,Football,Cricket,Badminton,Tennis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quora_register);

        Fiction= (CheckBox) findViewById(R.id.chkFiction);
        Non_Fiction= (CheckBox) findViewById(R.id.chkNonFiction);
        Poetry= (CheckBox) findViewById(R.id.chkPoetry);
        Short_stories= (CheckBox) findViewById(R.id.chkShortStories);
        Clothing= (CheckBox) findViewById(R.id.chkClothing);
        Footwear= (CheckBox) findViewById(R.id.chkFootwear);
        Watches= (CheckBox) findViewById(R.id.chkWatches);
        Accessories= (CheckBox) findViewById(R.id.chkAccessories);
        Coding= (CheckBox) findViewById(R.id.chkCoding);
        Android= (CheckBox) findViewById(R.id.chkAndroid);
        iOS= (CheckBox) findViewById(R.id.chkiOS);
        Bollywood= (CheckBox) findViewById(R.id.chkBollywood);
        Hollywood= (CheckBox) findViewById(R.id.chkHollywood);
        Tollywood= (CheckBox) findViewById(R.id.chkTollywood);
        Punjabi= (CheckBox) findViewById(R.id.chkPunjabi);
        NorthIndian= (CheckBox) findViewById(R.id.chkNorthIndian);
        SouthIndian= (CheckBox) findViewById(R.id.chkSouthIndian);
        Italian= (CheckBox) findViewById(R.id.chkItalian);
        Chinese= (CheckBox) findViewById(R.id.chkChinese);
        Football= (CheckBox) findViewById(R.id.chkFootball);
        Cricket= (CheckBox) findViewById(R.id.chkCricket);
        Badminton= (CheckBox) findViewById(R.id.chkBadminton);
        Tennis= (CheckBox) findViewById(R.id.chkTennis);

        Button submit=findViewById(R.id.quora_register_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedList=new ArrayList<>();

                if (Fiction.isChecked()){
                    checkedList.add("Fiction");}
                if (Non_Fiction.isChecked()){
                    checkedList.add("Non-Fiction");}
                if (Poetry.isChecked()){
                    checkedList.add("Poetry");}
                if (Short_stories.isChecked()){
                    checkedList.add("Short-stories");}
                if (Clothing.isChecked()){
                    checkedList.add("Clothing");}
                if (Footwear.isChecked()){
                    checkedList.add("Footwear");}
                if (Watches.isChecked()){
                    checkedList.add("Watches");}
                if (Accessories.isChecked()){
                    checkedList.add("Accessories");}
                if (Coding.isChecked()){
                    checkedList.add("Coding");}
                if (Android.isChecked()){
                    checkedList.add("Android");}
                if (iOS.isChecked()){
                    checkedList.add("iOS");}
                if (Bollywood.isChecked()){
                    checkedList.add("Bollywood");}
                if (Hollywood.isChecked()){
                    checkedList.add("Hollywood");}
                if (Tollywood.isChecked()){
                    checkedList.add("Tollywood");}
                if (Punjabi.isChecked()){
                    checkedList.add("Punjabi");}
                if (NorthIndian.isChecked()){
                    checkedList.add("NorthIndian");}
                if (SouthIndian.isChecked()){
                    checkedList.add("SouthIndian");}
                if (Italian.isChecked()){
                    checkedList.add("Italian");}
                if (Chinese.isChecked()){
                    checkedList.add("Chinese");}
                if (Football.isChecked()){
                    checkedList.add("Football");}
                if (Cricket.isChecked()){
                    checkedList.add("Cricket");}
                if (Badminton.isChecked()){
                    checkedList.add("Badminton");}
                if (Tennis.isChecked()){
                    checkedList.add("Tennis");}

                RoleDTO roleDTO=new RoleDTO();
                roleDTO.setRole("user");
                roleDTO.setChannelChannelId(2);
                SharedPreferences sharedPreferences=getSharedPreferences("LoginData",MODE_PRIVATE);
                String token=sharedPreferences.getString("AccessToken","");
                String userId=sharedPreferences.getString("UserId","");

                token="Bearer "+token;

                roleUpdateAPI(checkedList,token,roleDTO,userId);
                quoraCategoryUpdate(userId,checkedList);
                daTagsAPI(checkedList);

                if(failDA||failQuora){
                    Toast.makeText(getApplicationContext(),"Could not Connect!, Check with DA,Login,Quora",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent=new Intent(QuoraRegister.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    //Request to Quora to Update CategoryChoice of User
    private void quoraCategoryUpdate(String userId,List<String>checkedList) {
        CategoryUpdateRequest categoryUpdateRequest=new CategoryUpdateRequest();
        categoryUpdateRequest.setCategoryList(checkedList);
        QuoraRetrofitService quoraRetrofitService1= RetrofitUsersInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        Call<Boolean>call1=quoraRetrofitService1.categoryUpdate(userId,categoryUpdateRequest);
        System.out.println("OnResponse RoleUpdate");
        call1.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                System.out.println("OnResponse CategoryUpdate");
                failQuora=false;

            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println("OnFailure CategoryUpdate"+t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    //Role Update Request to LoginService
    private void roleUpdateAPI(final List<String> checkedList,String token,RoleDTO roleDTO,final String userId) {
        QuoraRetrofitService quoraRetrofitService= RetrofitLoginService.getRetrofitInstance().create(QuoraRetrofitService.class);
        Call<RoleResponseDTO> call=quoraRetrofitService.updateRole(token,roleDTO);
        call.enqueue(new Callback<RoleResponseDTO>() {
            @Override
            public void onResponse(Call<RoleResponseDTO> call, Response<RoleResponseDTO> response) {

                System.out.println("OnResponse Role Update");
                failLogin=false;
            }
            @Override
            public void onFailure(Call<RoleResponseDTO> call, Throwable t) {
                System.out.println("OnFailure RoleUpdate"+t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    //TAGS given to Data Analytics
    private void daTagsAPI(List<String>checkedList) {
        SharedPreferences sharedPreferences=getSharedPreferences("LoginData",MODE_PRIVATE);
        String userId=sharedPreferences.getString("UserId","");
        TagsDARequest tagsDARequest=new TagsDARequest();
        tagsDARequest.setAppId("quora");
        tagsDARequest.setAction("register");
        tagsDARequest.setTag(checkedList);
        tagsDARequest.setUserId(userId);
        QuoraRetrofitService quoraRetrofitService= RetrofitDAInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        Call<TagsDAResponse>call=quoraRetrofitService.tagsToDA(tagsDARequest);
        call.enqueue(new Callback<TagsDAResponse>() {
            @Override
            public void onResponse(Call<TagsDAResponse> call, Response<TagsDAResponse> response) {
                System.out.println("OnResponse RegisterDATagsCategory");
                failDA=false;
            }

            @Override
            public void onFailure(Call<TagsDAResponse> call, Throwable t) {
                System.out.println("OnFailure RegisterDATagsCategory:"+t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
