package com.checongbinh.democambienanhsang;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor lightSensor;
    TextView txtHienThi;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHienThi = (TextView) findViewById(R.id.txtHienTHi);
        layout = (RelativeLayout) findViewById(R.id.viewMain);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(lightSensor == null){
            Toast.makeText(this,"Thiết bị không hỗ trợ cảm biến ánh sáng !",Toast.LENGTH_SHORT).show();
        }else{
            sensorManager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        lightSensor = event.sensor;
        if(lightSensor.getType() == Sensor.TYPE_LIGHT){
            txtHienThi.setText(event.values[0]+"");
            if (event.values[0] > 10000){
                layout.setBackgroundResource(R.drawable.maudo);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
