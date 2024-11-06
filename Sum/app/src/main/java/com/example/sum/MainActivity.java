package com.example.sum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText text1,text2;
    Button btn;
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
        text1=findViewById(R.id.One);
        text2=findViewById(R.id.Two);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(v -> {
            String num1=text1.getText().toString();
            String num2=text2.getText().toString();
            if(!num1.isEmpty() && !num2.isEmpty())
            {
                int no1=Integer.parseInt(num1);
                int no2=Integer.parseInt(num2);
                int avg =(no1+no2)/2;

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("average",avg);
                startActivity(intent);


            }


        });
    }
}