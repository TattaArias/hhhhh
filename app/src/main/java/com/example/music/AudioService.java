package com.example.music;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
public class AudioService extends Service {
    private MediaPlayer player;
    public Integer NoCanción =1 ;

    public AudioService() {
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO write your own code
        reproducir();
        nextOnClick();

        //player.setLooping(true);
        // start the player
        //player.start();

        Toast.makeText(this, "Service Started :) ", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stopping the player when service is destroyed
        player.stop();
        Toast.makeText(this, " :( Service Stopped!!!", Toast.LENGTH_LONG).show();
    }
    public void previousOnClick (View view){
        NoCanción = NoCanción - 1 ;
        if(NoCanción == 0) {
            NoCanción = 3 ;
        }
    }
    public void nextOnClick (){
        NoCanción = NoCanción + 1 ;
        if(NoCanción == 4) {
            NoCanción = 1;
        }
    }

    public void reproducir(){
        if(NoCanción == 1) {
            player = MediaPlayer.create(this, R.raw.cancion1);
        }else if(NoCanción == 2) {
            player = MediaPlayer.create(this, R.raw.cancion2);
        }else if(NoCanción == 3) {
            player = MediaPlayer.create(this, R.raw.cancion3);
        }
        player.start();
    }
}