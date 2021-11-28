package com.example.bokap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppStartActivity extends AppCompatActivity {

    Button logout;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);

        logout = findViewById(R.id.logout);
        sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getResources().getString(R.string.prefLoginState),"logout");
                editor.apply();
                startActivity(new Intent(AppStartActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}