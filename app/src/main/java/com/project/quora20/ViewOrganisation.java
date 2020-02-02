package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.quora20.entity.Organization;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitClientInstance;
import com.project.quora20.retrofit.RetrofitUsersInstance;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewOrganisation extends AppCompatActivity {

    QuoraRetrofitService quoraRetrofitService;
    //Organization organization;
    ImageView orgImage;
    TextView orgName;
    TextView orgEmail;
    TextView orgFollowers;
    TextView orgFollowing;
    TextView orgMembers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_organisation);

        viewOrganization();
    }

    void viewOrganization()
    {
        quoraRetrofitService= RetrofitUsersInstance.getRetrofitInstance().create(QuoraRetrofitService.class);
        orgName=findViewById(R.id.org_Name);
        orgEmail=findViewById(R.id.org_Email);
        orgFollowers=findViewById(R.id.org_followersCount);
        orgFollowing=findViewById(R.id.org_followingCount);
        orgMembers=findViewById(R.id.org_Members);
        orgImage=findViewById(R.id.org_ProfileImage);

        String organizationId="5e3149d91edbf851280ccf51";
        Call<Organization> callOrganization=quoraRetrofitService.viewOrganization(organizationId);
        callOrganization.enqueue(new Callback<Organization>() {
            @Override
            public void onResponse(Call<Organization> call, Response<Organization> response) {
                Organization organization=response.body();
                System.out.println("Inside OnResponse ViewOrganization");
                //orgImage.setImageResource();
                System.out.println("Object: "+organization);
                //Picasso.with(getApplicationContext()).load(organization.getOranizationImage()).centerCrop().into(orgImage);
                //Glide.
                //Picasso.with(orgImage.getContext()).load(u).into(orgImage);
                orgName.setText(organization.getOrganizationName());
                orgEmail.setText(organization.getOrganizationEmail());
                if(organization.getOrganizationFollowers()!=null) {
                    orgFollowers.setText(String.valueOf(organization.getOrganizationFollowers().size()));
                }
                else
                {
                    orgFollowers.setText("0");
                }
                if(organization.getOrganizationMembers()!=null)
                orgMembers.setText(String.valueOf(organization.getOrganizationMembers()));
                else
                    orgMembers.setText("0");


            }

            @Override
            public void onFailure(Call<Organization> call, Throwable t) {
                System.out.println("Inside OnFailure ViewOrganization:"+t.getMessage());
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }
}
