package com.checongbinh.demotogglebutton;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener{
    ToggleButton tgThongMinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tgThongMinh = (ToggleButton) findViewById(R.id.tgThongMinh);
        tgThongMinh.setOnCheckedChangeListener(this);


    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

//        switch (buttonView.getId()){
//            case R.id.tgThongMinh:
//                ;break;
//        }

        if(isChecked){
            Toast.makeText(this,"Bạn đã bật chế độ thông minh !",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Bạn đã tắt chế độ thông minh !",Toast.LENGTH_SHORT).show();
        }
    }
}
