package com.example.dbhandler;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private EditText edit_uname, edit_pwd;
    private Db dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Set up window insets listener
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize EditText fields with IDs from XML
        edit_uname = findViewById(R.id.editTextUsername); // Corrected ID
        edit_pwd = findViewById(R.id.editTextPassword);  // Corrected ID

        // Initialize DbHandler
        dbHandler = new Db(this);
    }

    // OnClick method for Login Button
    public void loginCheck(View v) {
        String username = edit_uname.getText().toString();
        String password = edit_pwd.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_LONG).show();
        } else {
            Boolean check = dbHandler.checkEmailPassword(username, password);

            edit_uname.setText("");
            edit_pwd.setText("");

            if (check) {
                Toast.makeText(this, "Successful Login", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, success.class);
                i.putExtra("USERNAME", username);
                startActivity(i);
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show();
            }
        }
    }
}
