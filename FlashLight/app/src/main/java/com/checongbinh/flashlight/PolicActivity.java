package com.checongbinh.flashlight;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Nhox on 10/22/2015.
 */
public class PolicActivity extends Activity {
    ToggleButton tgPolic;
    Timer timer;
    Handler handler;
    Boolean checkToogle = false;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_polic);

        tgPolic = (ToggleButton) findViewById(R.id.tgPolic);

        mediaPlayer = MediaPlayer.create(PolicActivity.this,R.raw.music_polic);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if(!checkToogle){
                    checkToogle = true;
                }else{
                    checkToogle = false;
                }

                tgPolic.setChecked(checkToogle);
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000,1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }
}
