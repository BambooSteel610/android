package com.checongbinh.gcm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDangKy = (Button) findViewById(R.id.btnDangKy);
        btnDangKy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent iDangKy = new Intent(MainActivity.this,RegistrationIntentService.class);
        startService(iDangKy);
    }
}
