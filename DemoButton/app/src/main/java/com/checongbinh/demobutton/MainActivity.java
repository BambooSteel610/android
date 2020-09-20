package com.checongbinh.demobutton;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{
    Button btnXuatThongBao, btnXinChao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnXuatThongBao = (Button) findViewById(R.id.btnThongBao);
        btnXinChao = (Button) findViewById(R.id.btnXinChao);

        btnXuatThongBao.setOnClickListener(this);
        btnXinChao.setOnClickListener(this);

//        btnXuatThongBao.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"Xin chào các bạn đây là button xuất thông báo !",Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//        btnXinChao.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"Xin chào các bạn đây là button xin chào !",Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnThongBao :
                Toast.makeText(MainActivity.this,"Xin chào các bạn đây là button xuất thông báo !",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnXinChao :
                Toast.makeText(MainActivity.this,"Xin chào các bạn đây là button xin chào!",Toast.LENGTH_LONG).show();
        }
    }

//    public void XuatThongBao(View v){
//        //String getID = String.valueOf(v.getId()); // Lấy ID của button gọi hàm xuất thông báo
//        switch (v.getId()){
//            case R.id.btnThongBao :
//                Toast.makeText(MainActivity.this,"Xin chào các bạn đây là button xuất thông báo !",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.btnXinChao :
//                Toast.makeText(MainActivity.this,"Xin chào các bạn đây là button xin chào!",Toast.LENGTH_LONG).show();
//        }
////        Button btnXuatThongBao = (Button) v;
////        String getTextButton = btnXuatThongBao.getText().toString();
////        Toast.makeText(MainActivity.this,"Xin chào các bạn !" + getTextButton,Toast.LENGTH_LONG).show();
//    }

}
