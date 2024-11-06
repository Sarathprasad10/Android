package com.example.optionsmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Toolbar toolbar = findViewById(R.id.toolbar2);
            setSupportActionBar(toolbar);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Toast.makeText(MainActivity.this, "Create a new project", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.item2) {
            Toast.makeText(MainActivity.this, "Create a new project", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.item3) {
            Toast.makeText(MainActivity.this, "Group item 1", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.item4) {
            Toast.makeText(MainActivity.this, "Group item 2", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.s1) {
            Toast.makeText(MainActivity.this, "Sub Menu item 1", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.s2) {
            Toast.makeText(MainActivity.this, "Sub Menu Item 2", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
