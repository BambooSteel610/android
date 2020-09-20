package com.checongbinh.flashlight;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

/**
 * Created by Nhox on 10/23/2015.
 */
public class FlashCameraActivity extends Activity implements CompoundButton.OnCheckedChangeListener {
    ToggleButton tgFlashCamera;
    Camera camera;
    Camera.Parameters parameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_flashcamera);

        tgFlashCamera = (ToggleButton) findViewById(R.id.tgFlashCamera);
        camera = Camera.open();
       parameters = camera.getParameters();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            MoFlashCamera();
        }else{
            TatFlashCamera();
        }
    }

    private void MoFlashCamera(){

        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_ON);
        camera.setParameters(parameters);
        camera.startPreview();
    }

    private void TatFlashCamera(){
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
        camera.stopPreview();
    }
}
