package com.example.mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;
    public MyService() {

    }
    public int onStartCommand(Intent intent,int flag,int startId){
        if (intent != null) {
            String action = intent.getAction();
            if (action != null) {
                switch (action){
                    case "START":
                        mediaPlayer=MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI);
                        mediaPlayer.setLooping(true);
                        mediaPlayer.start();
                        break;
                    case  "PAUSE":
                        if (mediaPlayer!=null && mediaPlayer.isPlaying()){
                            mediaPlayer.pause();
                        }
                        break;
                    case "RESUME":
                        if (mediaPlayer!=null && !mediaPlayer.isPlaying()){
                            mediaPlayer.start();
                        }
                        break;
                }
            }
        }

        return START_STICKY;
    }

    public void onDestroy(){
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }
}