package com.example.dateandtime;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import androidx.activity.EdgeToEdge;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize TextViews
        TextView TV1 = findViewById(R.id.TV1);
        TextView TV2 = findViewById(R.id.TV2);
        TextView TV3 = findViewById(R.id.TV3);
        TextView TV4 = findViewById(R.id.TV4);
        TextView TV5 = findViewById(R.id.TV5);
        TextView TV6 = findViewById(R.id.TV6);
        TextView TV7 = findViewById(R.id.TV7);
        TextView TV8 = findViewById(R.id.TV8);
        TextView TV9 = findViewById(R.id.TV9);
        TextView TV10 = findViewById(R.id.TV10);

        // Apply insets listener for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get current date
        Calendar calendar = Calendar.getInstance();

        // Format 1: Default format
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        TV1.setText(sdf1.format(calendar.getTime()));

        // Format 2: Day of week
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE", Locale.getDefault());
        TV2.setText(sdf2.format(calendar.getTime()));

        // Format 3: Month abbreviation
        SimpleDateFormat sdf3 = new SimpleDateFormat("MMM", Locale.getDefault());
        TV3.setText(sdf3.format(calendar.getTime()));

        // Format 4: Full month name
        SimpleDateFormat sdf4 = new SimpleDateFormat("MMMM", Locale.getDefault());
        TV4.setText(sdf4.format(calendar.getTime()));

        // Format 5: Year
        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy", Locale.getDefault());
        TV5.setText(sdf5.format(calendar.getTime()));

        // Format 6: Day of month
        SimpleDateFormat sdf6 = new SimpleDateFormat("dd", Locale.getDefault());
        TV6.setText(sdf6.format(calendar.getTime()));

        // Format 7: Time
        SimpleDateFormat sdf7 = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        TV7.setText(sdf7.format(calendar.getTime()));

        // Add data for TV8, TV9, TV10 if needed
    }
}
