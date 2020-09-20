package com.checongbinh.demogridview;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import Adapter.CustomBaseAdapter;


public class MainActivity extends Activity {
    GridView gridView;
    int[] danhSachHinhAnh = {R.drawable.aqua,R.drawable.aslongasyouloveme,R.drawable.images,R.drawable.nevergone,R.drawable.noname};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gvHinhAnh);
        CustomBaseAdapter adapter = new CustomBaseAdapter(this,R.layout.custom_layout_gridview,danhSachHinhAnh);
        adapter.notifyDataSetChanged();
        gridView.setAdapter(adapter);
    }


}
