package com.checongbinh.flashlight;

import android.app.Activity;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Nhox on 10/22/2015.
 */
public class TrafficActivity extends Activity {
    ImageView imageView;
    Timer timer;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_traffic);

        imageView = (ImageView) findViewById(R.id.imTraffic);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                LevelListDrawable levelListDrawable = (LevelListDrawable) imageView.getDrawable();

                int currentLevel = levelListDrawable.getLevel();

                if(currentLevel == 0 || currentLevel == 1){
                    currentLevel++;
                }else{
                    currentLevel = 0;
                }

                imageView.setImageLevel(currentLevel);
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
}
