package com.omkar.mybbshopkotlin;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.omkar.mybbshopkotlin.core.BBSuperActivity;

public class BBsplashActivity extends BBSuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(BBsplashActivity.this,BBSettingsActivity.class));
            }
        },1000);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}
