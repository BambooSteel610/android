package com.checongbinh.demointent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import DTO.NhanVien;


public class MainActivity extends Activity implements View.OnClickListener{
    Button btnMoManHinh;
    EditText edHoTen, edSoDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoManHinh = (Button) findViewById(R.id.btnMoManHinh);
        edHoTen = (EditText) findViewById(R.id.edHoTen);
        edSoDT = (EditText) findViewById(R.id.edSoDT);

        btnMoManHinh.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        NhanVien nhanvien = new NhanVien(1,"Che Cong Binh","Nam");
        Intent iMoManHinh2 = new Intent(MainActivity.this,MyLayout.class);
//        Bundle goiThongTin = new Bundle();
//        goiThongTin.putString("hoten",edHoTen.getText().toString()); // Put dữ liệu dạng Bundle
//        goiThongTin.putString("sodt",edSoDT.getText().toString());

//        Bundle goiThongTin2 = new Bundle();
//        goiThongTin2.putInt("maso",123456);

//        iMoManHinh2.putExtra("goithongtin1",goiThongTin);
//        iMoManHinh2.putExtra("goithongtin2",goiThongTin2);
//        iMoManHinh2.putExtra("hoten",edHoTen.getText().toString()); // Put dữ liệu dạng thường
//        iMoManHinh2.putExtra("sodt",edSoDT.getText().toString());

        iMoManHinh2.putExtra("nhanvien",nhanvien);
        startActivity(iMoManHinh2);
    }
}
