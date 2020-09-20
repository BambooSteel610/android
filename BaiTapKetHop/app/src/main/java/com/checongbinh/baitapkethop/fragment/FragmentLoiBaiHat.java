package com.checongbinh.baitapkethop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.checongbinh.baitapkethop.R;

/**
 * Created by Nhox on 1/14/2016.
 */
public class FragmentLoiBaiHat extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_loibaihat,container,false);
        return view;
    }
}
