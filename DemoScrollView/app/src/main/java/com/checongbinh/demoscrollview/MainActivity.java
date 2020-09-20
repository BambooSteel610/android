package com.checongbinh.demoscrollview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements ViewTreeObserver.OnScrollChangedListener{
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (ScrollView) findViewById(R.id.scrollView);

        scrollView.getViewTreeObserver().addOnScrollChangedListener(this);


    }

    @Override
    public void onScrollChanged() {
        Toast.makeText(MainActivity.this,"Bạn đã scroll",Toast.LENGTH_SHORT).show();
    }
}
