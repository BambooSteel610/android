package com.checongbinh.baitapkethop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.checongbinh.baitapkethop.DTO.SoVol;
import com.checongbinh.baitapkethop.Database.CreateDatabase;

import static com.checongbinh.baitapkethop.R.id.btnThemTenVol;

/**
 * Created by Nhox on 1/14/2016.
 */
public class ThemSoVolActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnThemVol, btnThoatVol;
    EditText edTenVol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themvol);

        btnThemVol = (Button) findViewById(btnThemTenVol);
        btnThoatVol = (Button) findViewById(R.id.btnThoatVol);
        edTenVol = (EditText) findViewById(R.id.edTenvol);

        btnThoatVol.setOnClickListener(this);
        btnThemVol.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnThemTenVol:
                ThemVol();
                ;break;

            case R.id.btnThoatVol:
                finish();
                ;break;
        }
    }

    private void ThemVol(){
        CreateDatabase database = new CreateDatabase(ThemSoVolActivity.this);

        SoVol soVol = new SoVol();
        soVol.setTenvol(edTenVol.getText().toString());
        long result = database.ThemVol(soVol);

        if(result !=0 ){
            Toast.makeText(ThemSoVolActivity.this,"Thêm thành công !",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(ThemSoVolActivity.this,"Thêm thất bại !",Toast.LENGTH_SHORT).show();
        }
    }
}
