package com.checongbinh.demoviewcliper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewFlipper viewFlipper;
    float toadox1,toadox2;
    ImageView imNext,imPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        imNext = (ImageView) findViewById(R.id.imNext);
        imPrev = (ImageView) findViewById(R.id.imPrev);

        viewFlipper.setInAnimation(MainActivity.this,android.R.anim.fade_in);
        viewFlipper.setOutAnimation(MainActivity.this, android.R.anim.fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);

//        viewFlipper.getDisplayedChild(); trả ra vị trí của View đang hiển thị
//        viewFlipper.setDisplayedChild(1); set vị trí View muốn hiển thị
        imNext.setOnClickListener(this);
        imPrev.setOnClickListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN :
                toadox1 = event.getX(); break;

            case MotionEvent.ACTION_UP :
                toadox2 = event.getX();
                if(toadox2 > toadox1){
                    viewFlipper.showPrevious();
                    //prev
                }else{
                    viewFlipper.showNext();
                    //next
                }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imNext:
                viewFlipper.showNext();break;
            case R.id.imPrev:
                viewFlipper.showPrevious();break;
        }
    }
}
