package com.example.dbhandler;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class regester extends AppCompatActivity {

    private EditText editName, editUsername, editPassword;
    private Db dbHandler;
    private static final String TAG = "DB_CHECK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_regester);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editName = findViewById(R.id.editTextName);
        editUsername = findViewById(R.id.editTextUsername);
        editPassword = findViewById(R.id.editTextPassword);

        dbHandler = new Db(this);
    }

    public void adduser(View v) {
        String name = editName.getText().toString();
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_LONG).show();
        } else {
            dbHandler.addNewUser(name, username, password);

            // Debugging: Check if the user is added to the database
            Cursor cursor = dbHandler.getAllUsers();
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        int nameIndex = cursor.getColumnIndex("name");
                        int usernameIndex = cursor.getColumnIndex("username");
                        int passwordIndex = cursor.getColumnIndex("password");

                        String dbName = cursor.getString(nameIndex);
                        String dbUsername = cursor.getString(usernameIndex);
                        String dbPassword = cursor.getString(passwordIndex);

                        Log.d(TAG, "Name: " + dbName + ", Username: " + dbUsername + ", Password: " + dbPassword);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }

            Toast.makeText(this, "NEW USER ADDED", Toast.LENGTH_LONG).show();

            editName.setText("");
            editUsername.setText("");
            editPassword.setText("");
        }
    }


    public void goBack(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
