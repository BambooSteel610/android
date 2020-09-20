package com.checongbinh.demoanim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView txtHienThi;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHienThi = (ImageView) findViewById(R.id.txtHienThi);
        btnStart = (Button) findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Animation animation =  AnimationUtils.loadAnimation(MainActivity.this,R.anim.hieuung);
//                txtHienThi.startAnimation(animation);

                AnimationSet animationSet = new AnimationSet(true);

                TranslateAnimation translateAnimation = new TranslateAnimation(0,300,0,0);
                translateAnimation.setDuration(5000);
                animationSet.addAnimation(translateAnimation);

                ScaleAnimation scaleAnimation = new ScaleAnimation(0,3,0,4);
                scaleAnimation.setDuration(5000);

                animationSet.addAnimation(scaleAnimation);
                txtHienThi.startAnimation(animationSet);
            }
        });
    }
}
