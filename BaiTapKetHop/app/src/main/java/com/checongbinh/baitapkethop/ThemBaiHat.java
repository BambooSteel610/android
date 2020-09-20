package com.checongbinh.baitapkethop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.checongbinh.baitapkethop.AdapterViewPager.AdapterCaSi;
import com.checongbinh.baitapkethop.AdapterViewPager.AdapterSoVol;
import com.checongbinh.baitapkethop.AdapterViewPager.AdapterTacGia;
import com.checongbinh.baitapkethop.DTO.BaiHat;
import com.checongbinh.baitapkethop.DTO.CaSi;
import com.checongbinh.baitapkethop.DTO.ChiTietBaiHat;
import com.checongbinh.baitapkethop.DTO.SoVol;
import com.checongbinh.baitapkethop.DTO.TacGia;
import com.checongbinh.baitapkethop.Database.CreateDatabase;

import java.util.List;

/**
 * Created by Nhox on 1/14/2016.
 */
public class ThemBaiHat extends AppCompatActivity implements View.OnClickListener {

    Spinner spTacGia,spSoVol,spCaSi;
    EditText edTenBaiHat,edLoiBaiHat;
    Button btnThemBaiHat,btnThoatBaiHat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_thembaihat);

        spCaSi = (Spinner) findViewById(R.id.spinCaSi);
        spSoVol = (Spinner) findViewById(R.id.spinSoVol);
        spTacGia = (Spinner) findViewById(R.id.spinTacGia);
        edLoiBaiHat = (EditText) findViewById(R.id.edLoiBaiHat);
        edTenBaiHat = (EditText) findViewById(R.id.edTenBaiHat);
        btnThemBaiHat = (Button) findViewById(R.id.btnThemBaiHat);
        btnThoatBaiHat = (Button) findViewById(R.id.btnThoatBaiHat);

        CreateDatabase database = new CreateDatabase(this);
        List<TacGia> tacGiaList = database.LayDanhSachTacGia();
        List<CaSi> caSiList = database.LayDanhSachCaSi();
        List<SoVol> soVols = database.LayDanhSachVol();

        AdapterTacGia adapterTacGia = new AdapterTacGia(this,R.layout.layout_adapter_tacgia,tacGiaList);
        spTacGia.setAdapter(adapterTacGia);

        AdapterCaSi adapterCaSi = new AdapterCaSi(this,R.layout.layout_adapter_tacgia,caSiList);
        spCaSi.setAdapter(adapterCaSi);

        AdapterSoVol adapterSoVol = new AdapterSoVol(this,R.layout.layout_adapter_tacgia,soVols);
        spSoVol.setAdapter(adapterSoVol);

//        spSoVol.setOnItemSelectedListener(this);
//        spCaSi.setOnItemSelectedListener(this);
//        spTacGia.setOnItemSelectedListener(this);

        btnThemBaiHat.setOnClickListener(this);
        btnThoatBaiHat.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.btnThemBaiHat:
                CreateDatabase database = new CreateDatabase(ThemBaiHat.this);

                BaiHat baiHat = new BaiHat();
                baiHat.setTenbaihat(edTenBaiHat.getText().toString());

                ChiTietBaiHat chiTietBaiHat = new ChiTietBaiHat();
                chiTietBaiHat.setLoibaihat(edLoiBaiHat.getText().toString());

                TextView txtIdCaSi = (TextView) spCaSi.getSelectedView().findViewById(R.id.txtTenTacGia);
                int maCaSi = (int) txtIdCaSi.getTag();
                chiTietBaiHat.setMacasi(maCaSi);

                TextView txtIdTacGia = (TextView) spTacGia.getSelectedView().findViewById(R.id.txtTenTacGia);
                int maTacGia = (int) txtIdTacGia.getTag();
                chiTietBaiHat.setMatacgia(maTacGia);

                TextView txtIdSoVol = (TextView) spSoVol.getSelectedView().findViewById(R.id.txtTenTacGia);
                int maVol = (int) txtIdSoVol.getTag();
                chiTietBaiHat.setMavol(maVol);

                long result = database.ThemBaiHat(baiHat,chiTietBaiHat);
                if(result !=0 ){
                    Toast.makeText(ThemBaiHat.this,"Thêm thành công !", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ThemBaiHat.this,"Thêm thất bại !", Toast.LENGTH_SHORT).show();
                }
                ;break;

            case R.id.btnThoatBaiHat:

                ;break;
        }
    }


}
