package com.checongbinh.democambiengiatoc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager sensorManager;
    Sensor cambienGiaToc;
    float last_x,last_y,last_z;
    long lastTime = 0;

    FrameLayout frameLayout;
    TextView txtHienThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        txtHienThi = (TextView) findViewById(R.id.txtHienThi);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        cambienGiaToc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if(cambienGiaToc == null){
            Toast.makeText(this,"Thiết bị của bạn không hỗ trợ cảm biến gia tốc",Toast.LENGTH_SHORT).show();
        }else{
            sensorManager.registerListener(this,cambienGiaToc,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        cambienGiaToc = event.sensor;
        if(cambienGiaToc.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            long currentTime = System.currentTimeMillis();
            if((currentTime-lastTime)>100){
                long diffTime = currentTime - lastTime;
                lastTime = currentTime;

                float speed = Math.abs( x + y + z - last_x - last_y - last_z)/diffTime * 10000;

                if(speed >600){
                    randomNumber();
                    Toast.makeText(MainActivity.this,"Bạn đã lắc thiết bị",Toast.LENGTH_SHORT).show();
                }
                Log.d("kiemtra",speed + "");
                last_x = x;
                last_y = y;
                last_z = z;
            }
        }
    }

    private void randomNumber(){
        Random random = new Random();
        int giatri = random.nextInt(10) + 1;

        txtHienThi.setText(String.valueOf(giatri));

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.move_down);
        frameLayout.clearAnimation();
        frameLayout.startAnimation(animation);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
