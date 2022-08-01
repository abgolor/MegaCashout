package com.example.megacashout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button start = findViewById(R.id.startBtn);
        start.setOnClickListener(v -> {
        	Intent startIntent = new Intent(this, HomeActivity.class);
        	startActivity(startIntent);
        });
    }
}
