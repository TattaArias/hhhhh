package com.example.music;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Integer NoCanción = 1 ;
    AudioService n = new AudioService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void startServiceOnClick (View view){
        Intent intent = new Intent(this, AudioService.class);
        startService(intent);
    }
    public void stopServiceOnClick (View view){
        Intent intent = new Intent(this, AudioService.class);
        stopService(intent);
    }

}
