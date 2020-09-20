package com.checongbinh.demoappmaytinh;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener {
    Float fthamsothunhat, fthamsothuhai;
    String stoantu,sxuatmanhinh="";
    EditText etGiaTri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGiaTri = (EditText) findViewById(R.id.etKetQua);
        int[] idButton = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,
                            R.id.btncham,R.id.btnchia,R.id.btntru,R.id.btncong,R.id.btnnhan,R.id.btnDelete,R.id.btnbang};

        for(int id:idButton){
            View v = (View)findViewById(id);
            v.setOnClickListener(this);
        }
    }

    private void ToanTu(){
        fthamsothunhat = Float.parseFloat(etGiaTri.getText().toString());
        sxuatmanhinh = "0";
        etGiaTri.setText("0");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btncong :
                stoantu = "+";
                ToanTu();

                break;

            case R.id.btntru :
                stoantu = "-";
                ToanTu();
                break;

            case R.id.btnnhan :
                stoantu = "*";
                ToanTu();
                break;

            case R.id.btnchia :
                stoantu = "/";
                ToanTu();
                break;

            case R.id.btnbang :

                Float ketqua = null;
                fthamsothuhai = Float.parseFloat(etGiaTri.getText().toString());
                if(stoantu == "+"){
                    ketqua = fthamsothunhat + fthamsothuhai;
                }

                if(stoantu == "-"){
                    ketqua = fthamsothunhat - fthamsothuhai;
                }

                if(stoantu == "*"){
                    ketqua = fthamsothunhat * fthamsothuhai;
                }

                if(stoantu == "/"){
                    ketqua = fthamsothunhat / fthamsothuhai;
                }

                etGiaTri.setText(String.valueOf(ketqua));
                fthamsothunhat = 0.0f;
                fthamsothuhai = 0.0f;
                sxuatmanhinh = "0";

                break;

            default:
                if(sxuatmanhinh.equals("0")){
                    sxuatmanhinh = "";
                }
                sxuatmanhinh += ((Button)v).getText().toString();

                etGiaTri.setText(sxuatmanhinh);

        }
    }
}
