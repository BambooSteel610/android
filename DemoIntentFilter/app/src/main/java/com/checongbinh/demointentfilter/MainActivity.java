package com.checongbinh.demointentfilter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    ImageView imHinhAnh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imHinhAnh = (ImageView) findViewById(R.id.imHinhAnh);
        Bundle bHinhAnh = getIntent().getExtras();
        if(bHinhAnh !=null){
            imHinhAnh.setImageURI((android.net.Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM));
        }


    }


}
