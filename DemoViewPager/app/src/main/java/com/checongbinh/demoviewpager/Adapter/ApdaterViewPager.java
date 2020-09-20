package com.checongbinh.demoviewpager.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Nhox on 11/23/2015.
 */
public class ApdaterViewPager extends FragmentStatePagerAdapter {
    List<Fragment> fragments;

    public ApdaterViewPager(FragmentManager fm,List<Fragment> fragments) {
        super(fm);

        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
