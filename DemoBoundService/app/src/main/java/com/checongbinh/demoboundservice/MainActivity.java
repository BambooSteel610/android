package com.checongbinh.demoboundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnLayDuLieu;
    DemoBoundService service;
    EditText edSoA,edSoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLayDuLieu = (Button) findViewById(R.id.btnLayDuLieu);
        edSoA = (EditText) findViewById(R.id.edSoA);
        edSoB = (EditText) findViewById(R.id.edSoB);

        btnLayDuLieu.setOnClickListener(this);

        service = new DemoBoundService();
        Intent intent = new Intent(MainActivity.this,DemoBoundService.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            DemoBoundService.LocalBinder localBinder = (DemoBoundService.LocalBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onClick(View v) {
        int soA = Integer.parseInt(edSoA.getText().toString());
        int soB = Integer.parseInt(edSoB.getText().toString());

        int Tong = service.CongHaiSo(soA,soB);

        Toast.makeText(MainActivity.this, "Tổng 2 số là : " + Tong,Toast.LENGTH_SHORT).show();
    }
}
