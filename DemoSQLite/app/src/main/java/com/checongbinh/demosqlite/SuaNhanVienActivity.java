package com.checongbinh.demosqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.checongbinh.demosqlite.DTO.NhanVienDTO;

/**
 * Created by Nhox on 12/12/2015.
 */
public class SuaNhanVienActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edSuaNhanVien;
    Button btnQuayVe;
    NhanVienDTO nhanviensua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_suanhanvien);

        edSuaNhanVien = (EditText) findViewById(R.id.edSuaNhanVien);
        btnQuayVe = (Button) findViewById(R.id.btnQuayVe);

        nhanviensua = (NhanVienDTO) getIntent().getSerializableExtra("nhanvien");
        edSuaNhanVien.setText(nhanviensua.getTennhanvien().toString());

        btnQuayVe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nhanviensua.setTennhanvien(edSuaNhanVien.getText().toString());
        Intent dulieu = new Intent();
        dulieu.putExtra("nhanvien",nhanviensua);
        setResult(MainActivity.RESULT_CODE_SUA,dulieu);
        finish();
    }
}
