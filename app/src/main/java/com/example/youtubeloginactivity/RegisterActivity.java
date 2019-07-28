package com.example.youtubeloginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText idText,idPassword,idName,idAge;
    Button regstrtBtn;

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
        regstrtBtn = findViewById(R.id.register_btn);
    }
}
