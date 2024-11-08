package com.example.crudapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DeleteActivity extends AppCompatActivity {

    DbHelper DbHelper;
    EditText item_name;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DbHelper=new DbHelper(this);
        btn=findViewById(R.id.Deletebutton);
        item_name=findViewById(R.id.DeleteItemName);
        btn.setOnClickListener(v -> {
            String item =item_name.getText().toString().trim();

            if(item.isEmpty())
            {
                Toast.makeText(DeleteActivity.this, "PLEASE FILL ALL THE FIELDS", Toast.LENGTH_LONG).show();
            }

            Boolean result= DbHelper.deleteItem(item);
            if(result)
            {
                Toast.makeText(DeleteActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(DeleteActivity.this, "Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}