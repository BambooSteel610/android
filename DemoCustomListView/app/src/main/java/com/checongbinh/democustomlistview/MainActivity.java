package com.checongbinh.democustomlistview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.checongbinh.democustomlistview.Apdater.CustomAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    ListView listAlbum;
    int[] hinhalbum = {R.drawable.aqua,R.drawable.aslongasyouloveme,R.drawable.images,R.drawable.nevergone,R.drawable.noname};
    String[] TenAlbum = {"Cháu lên ba","Con có bé bé","Hai con cua", "Vợ người ta","Hate you"};
    String[] NgayPhatHanh = {"12/1/1990","2/3/1985","6/12/2001","3/2/2003","5/7/2010"};
    List<Album> danhSachAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAlbum = (ListView) findViewById(R.id.listAlbum);

        danhSachAlbum = new ArrayList<>();
        for(int i = 0; i<TenAlbum.length; i++){
            Album album = new Album();
            album.setHinhAnh(hinhalbum[i]);
            album.setTenAlbum(TenAlbum[i]);
            album.setNgayPhatHanh(NgayPhatHanh[i]);

            danhSachAlbum.add(album);
        }

        CustomAdapter adapterAlbum = new CustomAdapter(this,R.layout.custom_layout_album_listview,danhSachAlbum);
        adapterAlbum.notifyDataSetChanged();
        listAlbum.setAdapter(adapterAlbum);
    }




}
