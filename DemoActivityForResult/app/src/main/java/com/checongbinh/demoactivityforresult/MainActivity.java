package com.checongbinh.demoactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnMoActivity;
    ListView listView;
    public static final int SAVE_BINH_PHUONG = 113;
    public static final int SAVE_GOC = 114;
    public static final int REQUEST_DIALOG_INPUT = 115;
    List<Integer> dulieu;
    ArrayAdapter<Integer> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoActivity = (Button) findViewById(R.id.btnMoActivity);
        listView = (ListView) findViewById(R.id.listView);

        dulieu = new ArrayList<Integer>();

        adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,dulieu);
        listView.setAdapter(adapter);

        btnMoActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,PopUpActivity.class);
        startActivityForResult(intent, REQUEST_DIALOG_INPUT);
    }

    // lỗi vì chuỗi không parse được phải là số thì mới parse được
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_DIALOG_INPUT){
            switch (resultCode){
                case SAVE_BINH_PHUONG:
                    int binhphuong = (int) data.getIntExtra("binhphuong",0); //0 là default nếu như ko có dữ liệu truyền qua
                    dulieu.add(binhphuong); // lúc nãy parse khong được do nó bắt chuyển binhphuong thành chuỗi thì mới cho parse
                    adapter.notifyDataSetChanged(); // không nhận được dữ liệu truyền qua ???
                    ;break;

                case SAVE_GOC:
                    int sogoc = data.getIntExtra("dlgoc",0);
                    dulieu.add(sogoc);
                    adapter.notifyDataSetChanged();
                    ;break;
            }

        }
    }

}
