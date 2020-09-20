package com.checongbinh.demolevellist;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity implements View.OnClickListener {
    ImageView hinhpin;
    Button btnTangLevel;
    int i = 1;
    Handler handler;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hinhpin= (ImageView) findViewById(R.id.imageView);
        btnTangLevel = (Button) findViewById(R.id.btnTangLevel);

        btnTangLevel.setOnClickListener(this);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 0){
                    if(i < 5){
                        i++;
                        hinhpin.setImageLevel(i);
                    }else{
                        i = 0;
                        hinhpin.setImageLevel(i);
                    }

                }
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
    public void onClick(View v) {

    }
}
