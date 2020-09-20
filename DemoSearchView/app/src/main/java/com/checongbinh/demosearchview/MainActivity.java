package com.checongbinh.demosearchview;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;
import android.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    Toolbar toolbar;
    ShareActionProvider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_menu, menu);
        MenuItem searchview = menu.findItem(R.id.itSearchView);
        MenuItem itemProvider = menu.findItem(R.id.itProvider);

        SearchView searchView = (SearchView) searchview.getActionView();
        searchView.setOnQueryTextListener(MainActivity.this);

        provider = (ShareActionProvider) itemProvider.getActionProvider();

//        provider = (ShareActionProvider) MenuItemCompat.getActionProvider(itemProvider);
//
//        provider.setOnShareTargetSelectedListener(new ShareActionProvider.OnShareTargetSelectedListener() {
//            @Override
//            public boolean onShareTargetSelected(ShareActionProvider source, Intent intent) {
//                Intent sintent = new Intent(Intent.ACTION_SEND);
//                sintent.setType("text/plain");
//                sintent.putExtra(Intent.EXTRA_TEXT,"Hello !");
//                provider.setShareIntent(intent);
//                return false;
//            }
//        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();
        switch (id){
            case R.id.itThem:
                Toast.makeText(MainActivity.this,"Bạn đã click vào Menu : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                ;break;

            case R.id.itXoa:
                Toast.makeText(MainActivity.this,"Bạn đã click vào Menu : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                ;break;

            case R.id.itSua:
                Toast.makeText(MainActivity.this,"Bạn đã click vào Menu : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                ;break;

            case R.id.itSearchView:
                Toast.makeText(MainActivity.this,"Bạn đã click vào Menu : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                ;break;

            case R.id.itProvider:

                ;break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
        return false;
    }
}
