package com.example.dbhandler;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //onclick method for Register Button
    public void Register(View v)
    {
        //clicking on button Register launches RegisterActivity
        Intent i = new Intent(MainActivity.this,regester.class);
        startActivity(i);
    }

    //onclick method for Login Button
    public void Login(View v)
    {
        //clicking on button Login launches LoginActivity
        Intent i = new Intent(MainActivity.this,login.class);
        startActivity(i);
    }
}