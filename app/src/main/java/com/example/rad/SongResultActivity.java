package com.example.rad;

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



    }

    public void onClick(View v) {

    }


}
