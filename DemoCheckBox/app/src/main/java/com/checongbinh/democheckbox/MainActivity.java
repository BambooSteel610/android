package com.checongbinh.democheckbox;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
;


public class MainActivity extends Activity implements View.OnClickListener{
    CheckBox chAndroid, chIOS, chWindowPhone;
    Button btnDongY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chAndroid = (CheckBox) findViewById(R.id.chAndroid);
        chIOS = (CheckBox) findViewById(R.id.chIOS);
        chWindowPhone = (CheckBox) findViewById(R.id.chWindowPhone);
        btnDongY = (Button) findViewById(R.id.btnDongY);

        btnDongY.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String thongbao = "";
        if(chAndroid.isChecked()){
           thongbao += chAndroid.getText();
        }

        if(chIOS.isChecked()){
            thongbao += " , " + chIOS.getText();
        }

        if(chWindowPhone.isChecked()){
            thongbao += " , " + chWindowPhone.getText();
        }

        Toast.makeText(this,"Ngôn ngữ mình thích nhất là : " + thongbao,Toast.LENGTH_SHORT).show();
    }
}
