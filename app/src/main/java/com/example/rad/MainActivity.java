package com.example.rad;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hiding action bar
        getSupportActionBar().hide();

        //creating dynamic background
        ConstraintLayout constLayout = findViewById(R.id.main_layout);

        AnimationDrawable animDraw = (AnimationDrawable) constLayout.getBackground();
        animDraw.setEnterFadeDuration(2500);
        animDraw.setExitFadeDuration(4000);
        animDraw.start();
    }
}
