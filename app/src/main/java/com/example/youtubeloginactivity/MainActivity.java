package com.example.youtubeloginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static String url = "http://dipdoo.dothome.co.kr/LoginTest/Login.php";

    private EditText mUsernameText;
    private EditText mPasswordText;
    private Button mLoginButton;
    private Button mRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }
    private void initComponent(){
        mUsernameText = findViewById(R.id.editText);
        mPasswordText = findViewById(R.id.editText2);
        mLoginButton = findViewById(R.id.email_sign_in_button);
        mRegisterBtn = findViewById(R.id.register_btn);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLoginInfo();
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });
    }

    private void sendLoginInfo(){
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("userID",mUsernameText.getText().toString())
                .add("userPassword",mPasswordText.getText().toString())
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        okHttpClient.newCall(request).enqueue(loginCallback);
    }

    private Callback loginCallback = new Callback(){

        @Override
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            Log.d("LoginResponse",response.body().string());
        }

        @Override
        public void onFailure(@NotNull Call call, @NotNull IOException e) {

        }
    };
}
