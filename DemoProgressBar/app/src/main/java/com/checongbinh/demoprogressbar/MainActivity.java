package com.checongbinh.demoprogressbar;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends Activity implements View.OnClickListener{
    ProgressBar prXuLy;
    Button btnBatdau;
    Handler handler;
    int xulyhientai = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prXuLy = (ProgressBar) findViewById(R.id.prXuLy);
        btnBatdau = (Button) findViewById(R.id.btnBatdau);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                prXuLy.setProgress(msg.what + 10);
            }
        };
        btnBatdau.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (xulyhientai < 100){
                    xulyhientai = prXuLy.getProgress();
                    handler.sendEmptyMessage(xulyhientai);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        thread.start();
    }
}
