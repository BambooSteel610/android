package com.checongbinh.baitapapdungbuttoneditexttextview;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener{
    TextView vXuatThongBao;
    EditText etSoa, etSob;
    Button btnDongY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vXuatThongBao = (TextView) findViewById(R.id.vXuatThongBao);
        etSoa = (EditText) findViewById(R.id.etSoa);
        etSob = (EditText) findViewById(R.id.etSob);
        btnDongY = (Button) findViewById(R.id.btnDongY);

        btnDongY.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int iSoa = Integer.parseInt(etSoa.getText().toString());
        int iSob = Integer.parseInt(etSob.getText().toString());
        int iTong = iSoa + iSob;

        vXuatThongBao.setText(String.valueOf(iTong));
//        vXuatThongBao.setTextColor(Color.GREEN);
//        vXuatThongBao.setTextColor(Color.parseColor("#F5DCE")); nhận vào mã màu
    }
}
