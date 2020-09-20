package com.checongbinh.demoanimationresource;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtHienThi;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHienThi = (TextView) findViewById(R.id.txtHienThi);
        btnStart = (Button) findViewById(R.id.btnStart);

        btnStart.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
//        AnimatorSet animationSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.demoanimation);
//        animationSet.setTarget(txtHienThi);
//        animationSet.start();

        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator thaydoitoadoX = ObjectAnimator.ofFloat(txtHienThi,"x",txtHienThi.getX(),300);
        thaydoitoadoX.setDuration(3000);

        ObjectAnimator thaydoitoadoY = ObjectAnimator.ofFloat(txtHienThi,"y",txtHienThi.getY(),800);
        thaydoitoadoY.setDuration(3000);

        animatorSet.playTogether(thaydoitoadoX,thaydoitoadoY);
        animatorSet.start();

    }
}
