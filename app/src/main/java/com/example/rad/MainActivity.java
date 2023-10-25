package com.example.rad;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart;

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

        //get button
        btnStart = findViewById(R.id.main_button_start);
        btnStart.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.main_button_start) {
            startActivity(new Intent(this, DeviceManagerActivity.class));
        }
    }
}
