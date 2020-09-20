package com.checongbinh.democlipdrawable;

import android.graphics.drawable.ClipDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    TextView textView;
    Button btnClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        btnClip = (Button) findViewById(R.id.button);

        btnClip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ClipDrawable clipDrawable = (ClipDrawable) textView.getBackground();
        clipDrawable.setLevel(clipDrawable.getLevel() + 1000);
    }
}
