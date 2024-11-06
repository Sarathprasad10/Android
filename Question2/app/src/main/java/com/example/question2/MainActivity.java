package com.example.question2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText subject1, subject2, subject3;
    Button calculateBtn;
    TextView sumText, averageText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        subject1 = findViewById(R.id.subject1);
        subject2 = findViewById(R.id.subject2);
        subject3 = findViewById(R.id.subject3);
        calculateBtn = findViewById(R.id.calculateBtn);
        sumText = findViewById(R.id.sumText);
        averageText = findViewById(R.id.averageText);

        calculateBtn.setOnClickListener(new view.OnClickListener);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}