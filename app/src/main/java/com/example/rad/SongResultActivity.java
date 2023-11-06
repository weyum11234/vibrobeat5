package com.example.rad;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SongResultActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtSong;
    private Button btnSearch;
    private ImageButton btnSwitch;
    public void onCreate(Bundle sis){
        super.onCreate(sis);
        setContentView(R.layout.song_result_activity);

        //hiding action bar
        getSupportActionBar().hide();

        //get editText
        txtSong = findViewById(R.id.song_result_edittext_search);

        //get button
        btnSearch = findViewById(R.id.song_result_button_submit);
        btnSearch.setOnClickListener(this);

        btnSwitch = findViewById(R.id.song_result_button_switch);
        btnSwitch.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.song_result_button_submit) {
            String song = txtSong.getText().toString();
        }
        else if (v.getId() == R.id.song_result_button_switch) {
            startActivity(new Intent(this, DeviceManagerActivity.class));
        }
    }


}
