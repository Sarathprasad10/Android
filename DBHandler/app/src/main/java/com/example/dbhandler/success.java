package com.example.dbhandler;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        TextView welcomeText = findViewById(R.id.welcomeText);
        String username = getIntent().getStringExtra("USERNAME");
        welcomeText.setText("Welcome, " + username);
    }
}
