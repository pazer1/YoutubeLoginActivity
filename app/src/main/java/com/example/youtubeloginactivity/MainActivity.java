package com.example.youtubeloginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

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

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });
    }
}
