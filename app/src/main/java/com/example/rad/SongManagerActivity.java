package com.example.rad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SongManagerActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtSong;
    private Button btnSearch;
    private ImageButton btnSwitch;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_manager);

        //hiding action bar
        getSupportActionBar().hide();

        //get edittext
        txtSong = findViewById(R.id.song_manager_edittext_song);

        //get button
        btnSearch = findViewById(R.id.song_manager_button_search);
        btnSearch.setOnClickListener(this);

        btnSwitch = findViewById(R.id.song_manager_button_switch);
        btnSwitch.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.song_manager_button_search) {
            String songTitle = txtSong.getText().toString();

            //TODO code for song search
        }
        else if (v.getId() == R.id.song_manager_button_switch) {
            startActivity(new Intent(this, DeviceManagerActivity.class));
        }
    }
}
