package com.example.crudapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Create extends AppCompatActivity {

    DbHelper DbHelper;
    EditText itemName,qnty;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DbHelper = new  DbHelper(this);
        itemName = findViewById(R.id.item);
        qnty = findViewById(R.id.qnty);
        btn = findViewById(R.id.createbtn);
        btn.setOnClickListener(v -> {
            String item = itemName.getText().toString().trim();
            String quantity =qnty.getText().toString().trim();

            if(item.isEmpty() || quantity.isEmpty()){

                Toast.makeText(Create.this, "PLEASE FILL ALL THE FIELDS", Toast.LENGTH_LONG).show();
            }
            try {
                int quant = Integer.parseInt(quantity);

                // Create the item in the database
                if (DbHelper.createItem(item, quant)) {
                    Toast.makeText(Create.this, "Item created successfully!", Toast.LENGTH_LONG).show();
                    finish();  // Finish this activity and go back to the previous one
                } else {
                    Toast.makeText(Create.this, "Failed to create item. Try again.", Toast.LENGTH_LONG).show();
                }
            } catch (NumberFormatException e) {
                // Handle the case where the quantity is not a valid number
                Toast.makeText(Create.this, "Please enter a valid number for quantity", Toast.LENGTH_LONG).show();
            }

        });
    }
}