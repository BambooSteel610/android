package com.checongbinh.baitapkethop;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TabHost;

import com.checongbinh.baitapkethop.AdapterViewPager.AdapterPagerBaiHat;
import com.checongbinh.baitapkethop.Database.CreateDatabase;
import com.checongbinh.baitapkethop.fragment.FragmentBaiHat;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener,ViewPager.OnPageChangeListener {
    TabHost tabHost;
    ViewPager viewPager;
    Toolbar toolbar;
    SearchView searchView;
    AdapterPagerBaiHat adapterPagerBaiHat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (TabHost) findViewById(R.id.tabhost);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        tabHost.setup();
        TabHost.TabSpec tabBaiHat = tabHost.newTabSpec("Bài Hát");
        tabBaiHat.setIndicator("Bài Hát");
        tabBaiHat.setContent(new FakeContentTab(this));

        TabHost.TabSpec tabLoiBaiHat = tabHost.newTabSpec("Lời Bài Hát");
        tabLoiBaiHat.setIndicator("Lời Bài Hát");
        tabLoiBaiHat.setContent(new FakeContentTab(this));

        TabHost.TabSpec tabTacGia = tabHost.newTabSpec("Tác Giả");
        tabTacGia.setIndicator("Tác Giả");
        tabTacGia.setContent(new FakeContentTab(this));

        TabHost.TabSpec tabCaSi = tabHost.newTabSpec("Ca Sĩ");
        tabCaSi.setIndicator("Ca sĩ");
        tabCaSi.setContent(new FakeContentTab(this));

        tabHost.addTab(tabBaiHat);
        tabHost.addTab(tabLoiBaiHat);
        tabHost.addTab(tabTacGia);
        tabHost.addTab(tabCaSi);

         adapterPagerBaiHat = new AdapterPagerBaiHat(getSupportFragmentManager());
        viewPager.setAdapter(adapterPagerBaiHat);

        tabHost.setOnTabChangedListener(this);
        viewPager.addOnPageChangeListener(this);

        CreateDatabase database = new CreateDatabase(this);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(!searchView.hasFocus()){
            searchView.requestFocus();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itThemTacGia:
                Intent intent = new Intent(MainActivity.this,ThemTacGiaActivity.class);
                startActivity(intent);
                ;break;

            case R.id.itThemCaSi:
                Intent intentCaSi = new Intent(MainActivity.this,ThemCaSi.class);
                startActivity(intentCaSi);
                ;break;

            case R.id.itThemBaiHat:
                Intent intentThemBaiHat = new Intent(MainActivity.this,ThemBaiHat.class);
                startActivity(intentThemBaiHat);
                ;break;

            case R.id.itThemVol:
                Intent intentThemVol = new Intent(MainActivity.this,ThemSoVolActivity.class);
                startActivity(intentThemVol);
        }

        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabChanged(String tabId) {
        viewPager.setCurrentItem(tabHost.getCurrentTab());
    }


    public class FakeContentTab implements TabHost.TabContentFactory{

        Context context;
        public FakeContentTab(Context context){
            this.context = context;
        }

        @Override
        public View createTabContent(String tag) {
            View view = new View(context);
            view.setMinimumHeight(0);
            view.setMinimumWidth(0);
            return view;
        }
    }

}
