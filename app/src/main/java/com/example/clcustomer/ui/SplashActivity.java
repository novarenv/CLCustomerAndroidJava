package com.example.clcustomer.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.clcustomer.R;
import com.example.clcustomer.ui.main.MainActivity;

import org.jetbrains.annotations.Nullable;
public class SplashActivity extends Activity {
    private Handler handler;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.splash_screen);
        this.handler = new Handler();
        Handler handler = this.handler;

        handler.postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 2000L);
    }
}
