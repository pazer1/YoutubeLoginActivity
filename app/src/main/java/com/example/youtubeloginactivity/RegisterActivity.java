package com.example.youtubeloginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText idText,idPassword,idName,idAge;
    Button registerBtn;
    String userId,userPassword,userAge,userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initComponent();
    }
    private void initComponent(){
        idText = findViewById(R.id.register_id);
        idPassword = findViewById(R.id.register_password);
        idName = findViewById(R.id.register_name);
        idAge = findViewById(R.id.register_age);
        registerBtn = findViewById(R.id.register_btn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userId = idText.getText().toString();
                userPassword = idText.getText().toString();
                userAge = idText.getText().toString();
                userName = idText.getText().toString();

                try {
                    updateUserInfo();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void updateUserInfo() throws IOException {
        String url = "http://dipdoo.dothome.co.kr/LoginTest/Register.php";
        OkHttpClient client = new OkHttpClient();



        RequestBody formBody = new FormBody.Builder()
                .add("userID",userId)
                .add("userPassword",userPassword)
                .add("userAge",userAge)
                .add("userName",userName)
                .build();

        Request request = new Request.Builder()
                .addHeader("content_length",String.valueOf(formBody.contentLength()))
                .url(url)
                .post(formBody)
                .build();

        client.newCall(request).enqueue(updateUserinfoCallback);
    }

    private Callback updateUserinfoCallback = new Callback() {
        @Override
        public void onFailure(@NotNull Call call, @NotNull IOException e) {
            Log.d("Test","Error Message : "+e.getMessage());
        }

        @Override
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            Log.d("response",response.body().string());
        }
    };
}
