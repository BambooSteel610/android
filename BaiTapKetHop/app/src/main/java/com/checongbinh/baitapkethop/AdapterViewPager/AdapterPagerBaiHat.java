package com.checongbinh.baitapkethop.AdapterViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.checongbinh.baitapkethop.fragment.FragmentBaiHat;
import com.checongbinh.baitapkethop.fragment.FragmentCaSi;
import com.checongbinh.baitapkethop.fragment.FragmentLoiBaiHat;
import com.checongbinh.baitapkethop.fragment.FragmentTacGia;

/**
 * Created by Nhox on 1/14/2016.
 */
public class AdapterPagerBaiHat extends FragmentStatePagerAdapter {

    public AdapterPagerBaiHat(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentBaiHat baiHat = new FragmentBaiHat();
                return baiHat ;

            case 1:
                FragmentLoiBaiHat loiBaiHat = new FragmentLoiBaiHat();
                return loiBaiHat;

            case 2:
                FragmentTacGia tacGia = new FragmentTacGia();
                return tacGia;

            case 3:
                FragmentCaSi caSi = new FragmentCaSi();
                return caSi;
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
