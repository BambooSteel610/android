package com.checongbinh.flashlight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Nhox on 10/19/2015.
 */
public class MenuActivity extends Activity implements View.OnClickListener{
    ImageButton btnLight, btnNeon, btnWarring, btnTraffic, btnPolic, btnFlashCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);

        btnLight = (ImageButton) findViewById(R.id.btnLight);
        btnNeon = (ImageButton) findViewById(R.id.btnNeon);
        btnWarring = (ImageButton) findViewById(R.id.btnWarring);
        btnTraffic = (ImageButton) findViewById(R.id.btnTraffic);
        btnPolic = (ImageButton) findViewById(R.id.btnPolic);
        btnFlashCamera = (ImageButton) findViewById(R.id.btnFlashLight);

        btnLight.setOnClickListener(this);
        btnNeon.setOnClickListener(this);
        btnWarring.setOnClickListener(this);
        btnTraffic.setOnClickListener(this);
        btnPolic.setOnClickListener(this);
        btnFlashCamera.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnLight :
                Intent iMoLightActivity = new Intent(MenuActivity.this,LightActivity.class);
                startActivity(iMoLightActivity);break;

            case  R.id.btnNeon :
                Intent iMoNeonActivity = new Intent(MenuActivity.this,NeonActivity.class);
                startActivity(iMoNeonActivity);break;

            case R.id.btnWarring :
                Intent iMoWarringActivity = new Intent(MenuActivity.this,WarringActivity.class);
                startActivity(iMoWarringActivity);break;

            case R.id.btnTraffic :
                Intent iMoTrafficActivity = new Intent(MenuActivity.this,TrafficActivity.class);
                startActivity(iMoTrafficActivity);break;

            case R.id.btnPolic :
                Intent iMoPolicActivity = new Intent(MenuActivity.this,PolicActivity.class);
                startActivity(iMoPolicActivity);break;

            case R.id.btnFlashLight :
                Intent iMoFlashCameraActivity = new Intent(MenuActivity.this,FlashCameraActivity.class);
                startActivity(iMoFlashCameraActivity);break;
        }

    }
}
