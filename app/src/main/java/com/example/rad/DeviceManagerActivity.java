package com.example.rad;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DeviceManagerActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtIP;
    private Button btnConnect;

    public String ipAddress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_manager);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //hiding action bar
        getSupportActionBar().hide();

        //get edittext
        txtIP = findViewById(R.id.device_manager_edittext_IP);

        //get button
        btnConnect = findViewById(R.id.device_manager_button_connect);
        btnConnect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.device_manager_button_connect) { //getting ip address from search field
            String ip = txtIP.getText().toString();

            //checking for valid ip address
            if (isValid(ip)) {
                try {
                    //ping test
                    if (sendPingRequest(ip, v)) {
                        ipAddress = ip;
                    }
                } catch (Exception e) {
                    Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
                    throw new RuntimeException(e);
                }
            }
            else {
                Toast.makeText(this, "Please enter a valid IP address.", Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean isValid(String ip) {
        if (ip.length() < 7 || ip.length() > 15)
            return false;

        String zeroTo255
                = "(\\d{1,2}|(0|1)\\"
                + "d{2}|2[0-4]\\d|25[0-5])";
        String regex
                = zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        return matcher.matches();
    }

    private boolean sendPingRequest(String ip, View v) throws UnknownHostException, IOException {
        InetAddress addr = InetAddress.getByName(ip);
        Toast.makeText(this, "Connecting...", Toast.LENGTH_SHORT).show();
        if (addr.isReachable(5000)) {
            Toast.makeText(this, "Connected!", Toast.LENGTH_SHORT).show();
            return true;
        }
        else {
            Toast.makeText(this, "Unable to connect. Try Again.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public String getIpAddress() {
        return ipAddress;
    }
}
