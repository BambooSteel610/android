package com.checongbinh.demolistview;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {
    ListView listView, listAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        listAndroid = (ListView) findViewById(R.id.listAndroid);

        String dulieu[] = {"ListView","GridView","Apdater"};

        List<NhanVien> list = new ArrayList<NhanVien>();
        NhanVien nv = new NhanVien();
        nv.setTenNV("Chế Công Bình");

        list.add(nv);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dulieu);
        ArrayAdapter<NhanVien> arrayAdapter = new ArrayAdapter<NhanVien>(this,android.R.layout.simple_list_item_1,list);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        listAndroid.setAdapter(arrayAdapter);

    }

}
