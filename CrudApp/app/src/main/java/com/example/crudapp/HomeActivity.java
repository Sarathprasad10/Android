package com.example.crudapp;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    Button create,update,delete,read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        create=findViewById(R.id.Create);
        update=findViewById(R.id.Update);
        delete=findViewById(R.id.Delete);
        read=findViewById(R.id.Read);
        create.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Create.class);
            startActivity(intent);
        });
        update.setOnClickListener(v->{
            Intent intent =new Intent(HomeActivity.this, UpdateActivity.class);
            startActivity(intent);
        });
        delete.setOnClickListener(v ->{
            Intent intent=new Intent(HomeActivity.this, DeleteActivity.class);
            startActivity(intent);
        });
        read.setOnClickListener(v ->{
            Intent intent=new Intent(HomeActivity.this, ReadActivity.class);
            startActivity(intent);
        });
    }
}