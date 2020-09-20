package com.checongbinh.demoactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nhox on 12/3/2015.
 */
public class PopUpActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnBinhPhuong, btnSoGoc;
    EditText edNhapLieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_activity);

        edNhapLieu = (EditText) findViewById(R.id.edNhap);
        btnBinhPhuong = (Button) findViewById(R.id.btnBinhPhuong);
        btnSoGoc = (Button) findViewById(R.id.btnSoGoc);

        btnBinhPhuong.setOnClickListener(this);
        btnSoGoc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBinhPhuong:
                Intent intentdulieubinhphuong = new Intent();
                if(edNhapLieu.getText().toString().equals("")){
                    int dulieuNhap = Integer.parseInt(edNhapLieu.getText().toString());
                    int binhphuong = dulieuNhap*dulieuNhap;

                    intentdulieubinhphuong.putExtra("binhphuong",binhphuong);
                    setResult(MainActivity.SAVE_BINH_PHUONG, intentdulieubinhphuong);
                    finish();
                }else{
                    Toast.makeText(PopUpActivity.this,"Vui lòng nhập số" ,Toast.LENGTH_SHORT).show();
                }

                ;break;

            case R.id.btnSoGoc:
                if(edNhapLieu.getText().toString().equals("")){
                    Intent intentdulieugoc = new Intent();
                    intentdulieugoc.putExtra("dlgoc",Integer.parseInt(edNhapLieu.getText().toString()));
                    setResult(MainActivity.SAVE_GOC,intentdulieugoc);
                    finish();
                }else{
                    Toast.makeText(PopUpActivity.this,"Vui lòng nhập số" ,Toast.LENGTH_SHORT).show();
                }
                ;break;
        }
    }
}
