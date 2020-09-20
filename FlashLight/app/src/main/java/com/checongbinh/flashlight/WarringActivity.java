package com.checongbinh.flashlight;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Nhox on 10/21/2015.
 */
public class WarringActivity extends Activity {
    ToggleButton tgWarring;
    Handler handler;
    Timer timer;
    Boolean checkWarring = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_warring);

        tgWarring = (ToggleButton) findViewById(R.id.tgWarring);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(!checkWarring){
                    checkWarring = true;
                }else{
                    checkWarring = false;
                }

                tgWarring.setChecked(checkWarring);
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000,1000);

//        tgWarring.setChecked(true);
    }
}
