package com.checongbinh.demointentimplict;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{
    Button btnGoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoi = (Button) findViewById(R.id.btnGoi);

        btnGoi.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent iGoi = new Intent();
        iGoi.setAction(Intent.ACTION_SEND);
        iGoi.putExtra(Intent.EXTRA_TEXT,"Nội dung tin nhắn gữi bỡi itclass");
        iGoi.setType("text/plain");
        startActivity(iGoi);
    }
}
