package com.phananh.demogridview;


import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import Adapter.CustomMonAnAdapter;

public class DanhSachMonAnActivity extends AppCompatActivity {
    ListView lvDanhSachMonAn;
    ArrayList<MonAn> dsMonAn;
    CustomMonAnAdapter monAnAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_mon_an);


        addControls();
        addEvents();
        Intent intent=getIntent();
        DanhMuc danhMuc= (DanhMuc) intent.getSerializableExtra("DanhMuc");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Food");
        query.whereEqualTo("ID", "Ga");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> dsMonAns, ParseException e) {
                if (e == null) {
                    for (int i=0;i<dsMonAns.size();i++)
                    {

                        ParseObject monAn=dsMonAns.get(i);

                        dsMonAn.add(new MonAn(
                                monAn.getString("ID"),
                                monAn.getString("TenMonAn"),
                                monAn.getParseFile("HinhMonAn"),
                                monAn.getString("MoTa"
                                )));


                    }
                    Log.d("kiemtra", dsMonAn.get(0).getTenMonAn());
                    monAnAdapter=new CustomMonAnAdapter(
                            DanhSachMonAnActivity.this,
                            R.layout.custom_layout_danhsachmonan,
                            dsMonAn
                    );

                    lvDanhSachMonAn.setAdapter(monAnAdapter);
                    monAnAdapter.notifyDataSetChanged();

                } else {

                }
            }
        });


    }

    private void addEvents() {

    }

    private void addControls() {


        lvDanhSachMonAn= (ListView) findViewById(R.id.lvDanhSachMonAn);
        dsMonAn=new ArrayList<MonAn>();

    }
}
