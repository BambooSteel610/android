package com.checongbinh.demointent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import DTO.NhanVien;

/**
 * Created by Nhox on 10/15/2015.
 */
public class MyLayout extends Activity {
    TextView tvHienThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);

        tvHienThi = (TextView) findViewById(R.id.tvHienThi);

        Intent intent = getIntent();
//        Bundle layGoiThongTin1 = intent.getBundleExtra("goithongtin1");
//        Bundle layGoiThongTin2 = intent.getBundleExtra("goithongtin2");

//        String hoten = intent.getStringExtra("hoten");
//        String sodt = intent.getStringExtra("sodt");

//        String hoten = layGoiThongTin1.getString("hoten");
//        int sodt = layGoiThongTin2.getInt("maso");
        NhanVien nhanvien = (NhanVien) getIntent().getSerializableExtra("nhanvien");

        tvHienThi.setText("Họ tên : " + nhanvien.getHoten() + " Số điện thoại : " + nhanvien.getGioiTinh());
    }
}
