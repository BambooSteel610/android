package com.checongbinh.demobaseadapter;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.checongbinh.demobaseadapter.Adapter.CustomBaseAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    ListView listView;
    int[] hinhalbum = {R.drawable.aqua,R.drawable.aslongasyouloveme,R.drawable.images,R.drawable.nevergone,R.drawable.noname,R.drawable.aqua,R.drawable.aslongasyouloveme,R.drawable.images,R.drawable.nevergone,R.drawable.noname};
    String[] TenAlbum = {"Cháu lên ba","Con có bé bé","Hai con cua", "Vợ người ta","Hate you","Cháu lên ba","Con có bé bé","Hai con cua", "Vợ người ta","Hate you"};
    String[] NgayPhatHanh = {"12/1/1990","2/3/1985","6/12/2001","3/2/2003","5/7/2010","12/1/1990","2/3/1985","6/12/2001","3/2/2003","5/7/2010"};
    List<Album> danhsachAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        danhsachAlbum = new ArrayList<>();

        for(int i = 0; i<TenAlbum.length; i++){
            Album album = new Album();
            album.setHinhAnh(hinhalbum[i]);
            album.setTenAlbum(TenAlbum[i]);
            album.setNgayPhatHanh(NgayPhatHanh[i]);

            danhsachAlbum.add(album);
        }

        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(this,R.layout.custom_layout_list,danhsachAlbum);
        customBaseAdapter.notifyDataSetChanged();
        listView.setAdapter(customBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Vị trí : " + danhsachAlbum.get(position).getTenAlbum(),Toast.LENGTH_SHORT).show();
            }
        });

    }



}
