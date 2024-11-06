package com.example.sqliteloginapp;
import com.example.sqliteloginapp.DataBaseHelper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button loginButton, registerButton;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Ensure this matches your XML layout

        db = new DataBaseHelper(this);
        username = findViewById(R.id.loginUsername); // Check if this ID is correct in activity_login.xml
        password = findViewById(R.id.loginPassword); // Check if this ID is correct in activity_login.xml
        loginButton = findViewById(R.id.loginButton); // Check if this ID is correct in activity_login.xml


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (db.checkUsernamePassword(user, pass)) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        // Redirect to another activity if login is successful
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class); // Ensure MainActivity exists
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class); // Ensure RegistrationActivity exists
                startActivity(intent);
            }
        });
    }
}
