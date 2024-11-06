package com.example.mediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    public void startMedia(View v){
        Intent i = new Intent(MainActivity.this, com.example.mediaplayer.MyService.class);
        i.setAction("START");
        startService(i);
    }
    public void stopMedia(View v){
        Intent i = new Intent(MainActivity.this, MyService.class);
        stopService(i);
    }
    public void pauseMedia(View v){
        Intent i = new Intent(MainActivity.this, MyService.class);
        i.setAction("PAUSE");
        startService(i);
    }
    public void resumeMedia(View v){
        Intent i = new Intent(MainActivity.this, MyService.class);
        i.setAction("RESUME");
        startService(i);

    }
}

