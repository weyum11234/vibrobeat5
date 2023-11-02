package com.example.rad;

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;

import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Track;

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
