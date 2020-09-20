package com.checongbinh.demosharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edHoTen, edEmail;
    SharedPreferences sharedPreferences;
    Button btnLuu, btnLayDuLieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edHoTen = (EditText) findViewById(R.id.edHoTen);
        edEmail = (EditText) findViewById(R.id.edEmail);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        btnLayDuLieu = (Button) findViewById(R.id.btnLayDuLieu);

        sharedPreferences = getSharedPreferences("thongtinnguoidung", Context.MODE_PRIVATE);

        btnLuu.setOnClickListener(this);
        edHoTen.setText(sharedPreferences.getString("hoten",""));
        edEmail.setText(sharedPreferences.getString("email",""));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLuu :
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String hoten = edHoTen.getText().toString();
                String email = edEmail.getText().toString();

                editor.putString("hoten",hoten);
                editor.putString("email",email);

                editor.commit();

                ;break;


        }
    }
}
