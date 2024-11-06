package com.example.temperature;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView cel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cel = findViewById(R.id.resultTextView);

        // Get the Fahrenheit value and convert to Celsius
        double far = getIntent().getDoubleExtra("farn", 0); // Use the same key
        double C = (far - 32) * 5 / 9; // Correct conversion from Fahrenheit to Celsius

        // Display the result in Celsius
        cel.setText(String.format("In Celsius: %.2f", C));
    }
}
