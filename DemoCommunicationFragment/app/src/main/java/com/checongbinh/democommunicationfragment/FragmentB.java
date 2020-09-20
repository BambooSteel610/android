package com.checongbinh.democommunicationfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Nhox on 11/21/2015.
 */
public class FragmentB extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b_layout,container,false);
        TextView textView = (TextView) view.findViewById(R.id.tvHienThi);

        Bundle bundle = getArguments();
        textView.setText(bundle.getString("dulieu").toString());
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
