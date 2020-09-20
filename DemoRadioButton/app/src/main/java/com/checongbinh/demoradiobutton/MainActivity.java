package com.checongbinh.demoradiobutton;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends Activity {
    RadioGroup rgGioiTinh;
    Button btnDongY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgGioiTinh = (RadioGroup) findViewById(R.id.rgGioiTinh);
        btnDongY = (Button) findViewById(R.id.btnDongY);



    }

    public void DongY(View v){
        int id = rgGioiTinh.getCheckedRadioButtonId();

//        switch (id){
//            case R.id.rdNam :
//                ;break;
//            case R.id.rdNu :
//                ;break;
//            case R.id.rdChuaBiet :
//                ;break;
//            default:
//
//        }

        RadioButton radio = (RadioButton) findViewById(id);
        String chuoiduocchon = radio.getText().toString();

        Toast.makeText(this,"Giới tính thật của mình là : " + chuoiduocchon,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
