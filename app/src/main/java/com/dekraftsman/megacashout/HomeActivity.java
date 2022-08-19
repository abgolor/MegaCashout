package com.dekraftsman.megacashout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;

public class HomeActivity extends AppCompatActivity {


    private Button goAdminLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        goAdminLogin = findViewById(R.id.go_admin_login);
        
        Button fiveOdds = findViewById(R.id.fiveBtn);
        fiveOdds.setOnClickListener(v -> {
            Intent startIntent = new Intent(HomeActivity.this, FiveActivity.class);
            startActivity(startIntent);
        });

        Button tenOdds = findViewById(R.id.tenBtn);
        tenOdds.setOnClickListener(v -> {
            Intent startIntent = new Intent(HomeActivity.this, TenActivity.class);
            startActivity(startIntent);
        });

        Button vipOdds = findViewById(R.id.vipBtn);
        vipOdds.setOnClickListener(v -> {
            Intent startIntent = new Intent(HomeActivity.this, VipActivity.class);
            startActivity(startIntent);
        });

        goAdminLogin.setOnClickListener(v -> {
            Intent adminLogin = new Intent(getApplicationContext(), AdminLoginActivity.class);
            startActivity(adminLogin);
        });
    }
}
