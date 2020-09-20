package com.checongbinh.xuatthongbaodebugandroid;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int a = 2;
        int b = 3;
        a = b;
        int tong = TinhTong(a, b);
        //Toast.makeText(this,R.string.thongbao,Toast.LENGTH_SHORT).show(); Xuất thông báo nhanh
        //Log.d("thongbao","xin chào đây là thông báo từ Log"); Xuất thông báo dạng log ( console )

    }

    public int TinhTong(int a, int b){
        return a + b;
    }

}
