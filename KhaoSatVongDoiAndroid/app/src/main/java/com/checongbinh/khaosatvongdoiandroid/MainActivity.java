package com.checongbinh.khaosatvongdoiandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("vongdoi","oncreate da chay");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("vongdoi","onstart da chay");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("vongdoi","onresume da chay");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("vongdoi","onpause da chay");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("vongdoi","onstop da chay");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("vongdoi","onrestart da chay");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("vongdoi","ondetroy da chay");
    }
}
