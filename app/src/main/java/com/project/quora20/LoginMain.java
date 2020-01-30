package com.project.quora20;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import com.project.quora20.retrofit.RetrofitClientInstance;
import java.util.Random;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginMain extends AppCompatActivity {
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginMain.this, Register.class);
                startActivity(registerIntent);
            }

        });

        Button loginButton = findViewById(R.id.login);
        sp = getSharedPreferences("LoginData", MODE_PRIVATE);
        String check = sp.getString("LoginCheck", "false");
        if (check.equals("false")) {
            if (!sp.getBoolean("LogInData", false)) {
                loginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        InputMethodManager inputManager = (InputMethodManager)
                                getSystemService(Context.INPUT_METHOD_SERVICE);

                        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                                InputMethodManager.HIDE_NOT_ALWAYS);
                        EditText user = findViewById(R.id.userName);
                        EditText pass = findViewById(R.id.password);
                        final String user1 = String.valueOf(user.getText());
                        final String pw = String.valueOf(pass.getText());
                        if (user1.length() == 0 || pw.length() == 0) {
                            Toast.makeText(getApplicationContext(), "Enter Login Details", Toast.LENGTH_SHORT).show();
                        } /*else {
                            registerUser.setEmail(user1);
                            registerUser.setPassword(pw);
                            GetProductsService getProductsService = RetrofitClientInstance.getRetrofitInstance().create(GetProductsService.class);
                            Call<AccessTokenDTO> call = getProductsService.loginUser(registerUser);
                            call.enqueue(new Callback<AccessTokenDTO>() {
                                @Override
                                public void onResponse(Call<AccessTokenDTO> call, Response<AccessTokenDTO> response) {
                                    accessTokenDTO = response.body();
                                    sp = getSharedPreferences("LoginData", MODE_PRIVATE);
                                    if(accessTokenDTO!=null) {
                                        if (accessTokenDTO.getCheck()) {
                                            System.out.println(accessTokenDTO.getCheck() + "CHECK");
                                            System.out.println("LOGIN DONE");
                                            String userId = accessTokenDTO.getUserId();
                                            SharedPreferences.Editor editor = sp.edit();
                                            editor.putString("UserId", userId).apply();
                                            String email = registerUser.getEmail();
                                            editor.putString("Email", email).apply();
                                            editor.putString("LoginCheck", "true").apply();
                                            editor.commit();
                                            Intent loginIntent = new Intent(LoginMain.this, MainActivity.class);
                                            loginIntent.putExtra("GuestUserId", cartValue);
                                            System.out.println("OnFailure CUSTOM LOGIN Success");
                                            startActivity(loginIntent);
                                            finish();
                                        } else {
                                            Snackbar snackbar = Snackbar.make(findViewById(R.id.login_layout), "Invalid Login Details", Snackbar.LENGTH_LONG);
                                            snackbar.show();
                                            System.out.println("OnResponse CUSTOM LOGIN PW MISMATCH" + accessTokenDTO.getCheck());
                                        }
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),"No AccessToken Received from Backend!",Toast.LENGTH_LONG).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<AccessTokenDTO> call, Throwable t) {
                                    Snackbar snackbar = Snackbar.make(findViewById(R.id.login_layout),
                                            t.getMessage(), Snackbar.LENGTH_LONG);
                                    snackbar.show();
                                    System.out.println("OnFailure CUSTOM LOGIN" + t.getMessage());
                                }
                            });
                        }*/
                    }
                });
            } else {
                Intent SignIntent = new Intent(LoginMain.this, MainActivity.class);
                startActivity(SignIntent);
                finish();
            }
        } else {
            Intent LoggedIn = new Intent(LoginMain.this, MainActivity.class);
            startActivity(LoggedIn);
        }
        //SKIP LOGIN
        Button skipSignIn = findViewById(R.id.skip);
        skipSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skipSignInIntent = new Intent(LoginMain.this, MainActivity.class);
                int max = Integer.MAX_VALUE;
                int min = 0;
                Random random = new Random();
                int randomNumber = random.nextInt(max - min) + min;
                String guestUserId = String.valueOf(randomNumber);
                System.out.println(guestUserId + "LOGIN GUEST USERID");
                sp = getSharedPreferences("LoginData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("UserId", guestUserId).apply();
                editor.putString("LoginCheck", "false").apply();
                editor.putString("User", "Guest").apply();
                editor.commit();
                startActivity(skipSignInIntent);
            }
        });


    }
}
