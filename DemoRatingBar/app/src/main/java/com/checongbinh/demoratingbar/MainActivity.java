package com.checongbinh.demoratingbar;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.Toast;


public class MainActivity extends Activity implements RatingBar.OnRatingBarChangeListener{
    RatingBar rdDanhGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdDanhGia = (RatingBar) findViewById(R.id.rtDanhGia);
        rdDanhGia.setOnRatingBarChangeListener(this);

    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

        Toast.makeText(this,"Bạn đã đánh giá khóa học này là : " + rating, Toast.LENGTH_SHORT).show();
    }
}
