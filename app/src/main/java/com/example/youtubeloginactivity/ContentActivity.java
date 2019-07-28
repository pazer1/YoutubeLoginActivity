package com.example.youtubeloginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        EditText idText = findViewById(R.id.idText);
        EditText passwordText = findViewById(R.id.passwordText);
        TextView welcomeMessage = findViewById(R.id.welcome_text);
    }
}
