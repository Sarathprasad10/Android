package com.example.temperature;

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

    EditText Far;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Far = findViewById(R.id.fah);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(v -> {
            String Far_s = Far.getText().toString();
            if (!Far_s.isEmpty()) {
                double far = Double.parseDouble(Far_s);

                // Send the Fahrenheit value to ResultActivity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("farn", far); // Using the correct key
                startActivity(intent);
            }
        });
    }
}
