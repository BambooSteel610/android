package com.checongbinh.baitapkethop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.checongbinh.baitapkethop.DTO.TacGia;
import com.checongbinh.baitapkethop.Database.CreateDatabase;

/**
 * Created by Nhox on 1/14/2016.
 */
public class ThemTacGiaActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnThem,btnThoat;
    EditText edTenTacGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themtacgia);

        btnThem = (Button) findViewById(R.id.btnThemTacGia);
        btnThoat = (Button) findViewById(R.id.btnThoatTacGia);
        edTenTacGia = (EditText) findViewById(R.id.edtentacgia);

        btnThem.setOnClickListener(this);
        btnThoat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnThemTacGia :
                ThemTacGia();
                ;break;

            case R.id.btnThoatTacGia :
                finish();
                ;break;
        }
    }

    private void ThemTacGia(){
        CreateDatabase database = new CreateDatabase(ThemTacGiaActivity.this);
        TacGia tacGia = new TacGia();
        tacGia.setTentacgia(edTenTacGia.getText().toString());

        long result = database.ThemTacGia(tacGia);

        if(result != 0){
            Toast.makeText(ThemTacGiaActivity.this,"Thêm thành công !",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(ThemTacGiaActivity.this,"Thêm thất bại !",Toast.LENGTH_SHORT).show();
        }
    }
}
