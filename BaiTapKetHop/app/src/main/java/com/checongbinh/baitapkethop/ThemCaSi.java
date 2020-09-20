package com.checongbinh.baitapkethop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.checongbinh.baitapkethop.DTO.CaSi;
import com.checongbinh.baitapkethop.Database.CreateDatabase;

/**
 * Created by Nhox on 1/14/2016.
 */
public class ThemCaSi extends AppCompatActivity implements View.OnClickListener {

    Button btnThemCaSi,btnThoatCaSi;
    EditText edTenCaSi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themcasi);

        btnThemCaSi = (Button) findViewById(R.id.btnThemCaSi);
        btnThoatCaSi = (Button) findViewById(R.id.btnThoatCaSi);
        edTenCaSi = (EditText) findViewById(R.id.edTencasi);

        btnThemCaSi.setOnClickListener(this);
        btnThoatCaSi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnThemCaSi:
                CreateDatabase database = new CreateDatabase(ThemCaSi.this);

                CaSi caSi = new CaSi();
                caSi.setTencasi(edTenCaSi.getText().toString());

                long result = database.ThemCaSi(caSi);
                if(result !=0){
                    Toast.makeText(ThemCaSi.this,"Thêm thành công ! ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ThemCaSi.this,"Thêm thất bại ! ", Toast.LENGTH_SHORT).show();
                }

                ;break;

            case R.id.btnThoatCaSi:
                finish();
                ;break;
        }
    }
}
