package com.checongbinh.demodrawermenu;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

//    String[] item = {"android","ios","windowphone"};
//    ListView listView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBar actionBar;
    NavigationView navigationView;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listView = (ListView) findViewById(R.id.listview);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item);
//        listView.setAdapter(adapter);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.open,R.string.close);
        drawerToggle.syncState();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
//        toolbar.setNavigationIcon();

        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int i = item.getItemId();
        switch (i){
            case R.id.camera:
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                FragmentCamera fragmentCamera = new FragmentCamera();
                transaction.replace(R.id.content_layout, fragmentCamera);
                transaction.commit();

                drawerLayout.closeDrawer(GravityCompat.START);
                ;break;

            case R.id.gallery:
                FragmentTransaction transaction1 = fragmentManager.beginTransaction();

                FragmentGallery fragmentGallery = new FragmentGallery();
                transaction1.replace(R.id.content_layout,fragmentGallery);
                transaction1.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                ;break;

            case R.id.slideshow:
                ;break;

            case R.id.setting:
                ;break;

            case R.id.share:
                ;break;

            case R.id.send:
                ;break;
        }
        return true;
    }
}
