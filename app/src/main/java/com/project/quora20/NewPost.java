package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NewPost extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText questionBody;
    private Button postButton;
    private EditText taggedPeople;
    private Spinner spinner;
    private static final String[] paths = {"Sports", "Technology", "Lifestyle","Food","Movies"};
    private String categoryChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        spinner = (Spinner)findViewById(R.id.category_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.category_paths,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        postButton=findViewById(R.id.postButton);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionBody=findViewById(R.id.questionBody);
                taggedPeople=findViewById(R.id.taggedpeople);
                categoryChoice=spinner.getSelectedItem().toString();


            }
        });

//        String io=spinner.getSelectedItem().toString();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                categoryChoice="Sports";
                Toast.makeText(getApplicationContext(),"Sports Selected",Toast.LENGTH_SHORT).show();
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                categoryChoice="Technology";
                Toast.makeText(getApplicationContext(),"Technology Selected",Toast.LENGTH_SHORT).show();
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                categoryChoice="Lifestyle";
                Toast.makeText(getApplicationContext(),"Lifestyle Selected",Toast.LENGTH_SHORT).show();
                // Whatever you want to happen when the thrid item gets selected
                break;
            case 3:
                categoryChoice="Food";
                Toast.makeText(getApplicationContext(),"Food Selected",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                categoryChoice="Movies";
                Toast.makeText(getApplicationContext(),"Movies Selected",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

}
