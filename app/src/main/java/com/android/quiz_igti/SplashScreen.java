package com.android.quiz_igti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        timerRedirect();
    }

    private void timerRedirect(){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                redirectActivity();
            }
        },getSplashTimer());
    }

    private long getSplashTimer(){

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        Boolean firstLogin = sharedPreferences.getBoolean("FIRST_LOGIN_SPLASH", true);

        if(firstLogin){
            editor.putBoolean("FIRST_LOGIN_SPLASH" ,false);
            editor.commit();
            return 1000;
        }
        return 0;
    }
    private void redirectActivity(){
        Intent redirect = new Intent(this,MainActivity.class);
        startActivity(redirect);
        finish();
    }
}