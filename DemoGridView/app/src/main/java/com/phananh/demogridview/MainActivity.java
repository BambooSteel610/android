package com.phananh.demogridview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


import com.parse.Parse;
import com.parse.ParseObject;

import java.util.ArrayList;

import Adapter.CustomBaseAdapter;


public class MainActivity extends AppCompatActivity {
    GridView gridView;
    int [] danhSachHinhAnh = {R.drawable.thitheo,R.drawable.thitvit,
            R.drawable.raucu,R.drawable.thitbo,R.drawable.dauphu,
            R.drawable.thitga,R.drawable.haisankhac,R.drawable.trung};
    String [] kytu={"Thịt Heo","Thịt Vịt","Rau Củ","Thịt Bò","Đậu phụ","Thịt Gà","Hải sản","Trứng"};
    String [] id={"Heo","Vit","Rau","Bo","Dau","Ga","HS","Trung"};
    ArrayList<DanhMuc> dsDanhMuc;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();





    }

    private void addEvents() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,DanhSachMonAnActivity.class);
                intent.putExtra("DanhMuc", dsDanhMuc.get(position));
                startActivity(intent);
            }
        });
    }



    private void addControls() {
        gridView = (GridView) findViewById(R.id.gvHinhAnh);
        CustomBaseAdapter adapter = new CustomBaseAdapter(this,R.layout.custom_layout_gridview,getData());
        adapter.notifyDataSetChanged();
        gridView.setAdapter(adapter);

        toolbar= (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
    }

    private ArrayList<DanhMuc> getData()
    {
        dsDanhMuc =new ArrayList<>();
        for(int i=0;i<danhSachHinhAnh.length;i++)
        {
            DanhMuc danhMuc =new DanhMuc(id[i],danhSachHinhAnh[i],kytu[i]);
            dsDanhMuc.add(danhMuc);
        }
        return dsDanhMuc;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.itThongtin)
        {
            Toast.makeText(MainActivity.this,"Phan Anh",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
