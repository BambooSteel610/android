package com.checongbinh.demobroadcastreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GuiThongDiep(View v){
        Intent intent = new Intent();
        intent.setAction("com.checongbinh.demobroadcastreceiver.CUSTOM_BROARDCAST");
        intent.putExtra("dulieu","dữ liệu gữi từ intent");
        sendBroadcast(intent);
    }
}
