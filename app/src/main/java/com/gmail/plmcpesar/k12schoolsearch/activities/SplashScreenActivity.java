package com.gmail.plmcpesar.k12schoolsearch.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmail.plmcpesar.k12schoolsearch.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread SplashScreenThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent splashscreenChangeIntent = new Intent(getApplicationContext(),OnboardingScreenActivity.class);
                    startActivity(splashscreenChangeIntent);
                    finish();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        SplashScreenThread.start();
    }
}
