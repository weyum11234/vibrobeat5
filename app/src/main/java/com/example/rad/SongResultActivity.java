package com.example.rad;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.Scanner;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStreamReader;
import java.net.*;

public class SongResultActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtSong;
    private Button btnSubmit;
    private ImageButton btnSwitch;
    public void onCreate(Bundle sis){
        super.onCreate(sis);
        setContentView(R.layout.song_result_activity);

        //hiding action bar
        getSupportActionBar().hide();

        //get edittext
        txtSong = findViewById(R.id.song_result_edittext_search);

        //get button
        btnSubmit = findViewById(R.id.song_result_button_submit);
        btnSubmit.setOnClickListener(this);

        btnSwitch = findViewById(R.id.song_result_button_switch);
        btnSwitch.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.song_result_button_submit) {
            String song = txtSong.getText().toString();

            try {
                URL url = new URL("http://10.18.194.108:5000/getbpm?song=" + song);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                int status = con.getResponseCode();
                if (status != 200) {
                    Toast.makeText(this, "Could not fetch results. Please try again.", Toast.LENGTH_SHORT).show();
                }
                else {
                    String inline = "";
                    Scanner scanner = new Scanner(url.openStream());

                    while (scanner.hasNext()) {
                        inline += scanner.nextLine();
                    }
                    scanner.close();

                    int bpm = Integer.parseInt(inline);

                    //TODO successfully retrieves bpm, need to now send to ESP8266
                }
            }
            catch (Exception e) {
                Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.song_result_button_switch) {
            startActivity(new Intent(this, DeviceManagerActivity.class));
        }
    }


}
