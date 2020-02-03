package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.project.quora20.dto.logindtos.CoAuthRegisterRequest;
import com.project.quora20.dto.logindtos.RegisterResponse;
import com.project.quora20.retrofit.QuoraRetrofitService;
import com.project.quora20.retrofit.RetrofitLoginService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    private EditText registerUsername;
    private EditText registerEmail;
    private EditText registerPassword;
    private EditText registerConfirmPassword;
    private CoAuthRegisterRequest coAuthRequestDTO=new CoAuthRegisterRequest();
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button signUp=findViewById(R.id.register_button);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                registerUsername = findViewById(R.id.register_username);
                String userName = registerUsername.getText().toString();

                registerEmail = findViewById(R.id.register_email);
                String email = registerEmail.getText().toString();

                registerPassword = findViewById(R.id.register_password);
                String password = registerPassword.getText().toString();

                registerConfirmPassword = findViewById(R.id.register_confirmpassword);
                String confirmPassword = registerConfirmPassword.getText().toString();

                boolean nullFlag = true;
                Boolean passwordCheckFail = true;
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (userName != null && email != null && password != null && confirmPassword != null && email.matches(emailPattern)) {
                    nullFlag = false;
                    if (confirmPassword.equals(password)) {
                        passwordCheckFail = false;
                        coAuthRequestDTO.setEmail(email);
                        coAuthRequestDTO.setPassword(password);
                        coAuthRequestDTO.setName(userName);
                        message="Registered";

                    } else {
                        passwordCheckFail=true;
                        message = "Confirm Password Failed";
                        Toast.makeText(getApplicationContext(), "Registered!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    nullFlag=true;
                    message = "Enter all fields appropriately!";
                }

               if(!nullFlag && !passwordCheckFail){
                    QuoraRetrofitService quoraRetrofitService = RetrofitLoginService.getRetrofitInstance().create(QuoraRetrofitService.class);
                    Call<RegisterResponse> call= quoraRetrofitService.addUser(coAuthRequestDTO);
                    call.enqueue(new Callback<RegisterResponse>() {
                        @Override
                        public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                            if (response.code()==400 || response.body().getMessage().equals("Email address already in use.")) {
                                System.out.println("InRESPONSE:");
                                Toast.makeText(getApplicationContext(), "Already Registered, Please Login!", Toast.LENGTH_SHORT).show();
                                System.out.println("ALREADY REGISTERED");
                                message="ALREADY REGISTERED";
                                Intent loginNow= new Intent(Register.this,LoginMain.class);
                                startActivity(loginNow);
                                finish();
                            }
                            else {
                                System.out.println("CODE:"+response.code());
                                System.out.println("REGISTERED");
                                Toast.makeText(getApplicationContext(), "Registered!", Toast.LENGTH_SHORT).show();
                                message="Registered Successfully!";
                                Intent loginNow= new Intent(Register.this,LoginMain.class);
                                startActivity(loginNow);
                                finish();
                            }
                            System.out.println("OnResponse Register");
                        }
                        @Override
                        public void onFailure(Call<RegisterResponse> call, Throwable t) {
                            System.out.println("OnFailure Register"+t.getMessage());
                        }
                    });
                }
                Snackbar snackbar = Snackbar.make(findViewById(R.id.register_layout),
                        message, Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });
    }
}

