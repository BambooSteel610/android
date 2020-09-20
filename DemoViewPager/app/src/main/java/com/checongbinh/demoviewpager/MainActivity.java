package com.checongbinh.demoviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.checongbinh.demoviewpager.Adapter.ApdaterViewPager;
import com.checongbinh.demoviewpager.AnimViewPager.DepthAnimation;
import com.checongbinh.demoviewpager.Fragment.Fragment1;
import com.checongbinh.demoviewpager.Fragment.Fragment2;
import com.checongbinh.demoviewpager.Fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        fragments = new ArrayList<Fragment>();

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        ApdaterViewPager apdaterViewPager = new ApdaterViewPager(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(apdaterViewPager);

        viewPager.setPageTransformer(true,new DepthAnimation());

    }
}
