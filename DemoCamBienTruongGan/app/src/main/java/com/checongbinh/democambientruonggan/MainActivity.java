package com.checongbinh.democambientruonggan;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager sensorManager;
    Sensor cambientruonggan;
    TextView txtHienThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHienThi = (TextView) findViewById(R.id.txtHienThi);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        cambientruonggan = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(this,cambientruonggan,SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        float giatri = event.values[0];
        if(giatri == 0){
            txtHienThi.setText("Thiết bị ở gần lỗ tai !" );
        }else{
            txtHienThi.setText("Thiết bị ở xa lỗ tai !" );
        }
        Log.d("giatri",giatri+"");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
