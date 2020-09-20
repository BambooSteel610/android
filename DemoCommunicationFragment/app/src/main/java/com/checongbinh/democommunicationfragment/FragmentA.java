package com.checongbinh.democommunicationfragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Nhox on 11/21/2015.
 */
public class FragmentA extends Fragment implements View.OnClickListener {
    GiaoTiepHaiFragment giaoTiepHaiFragment;
    EditText editText;

    public interface GiaoTiepHaiFragment{
        public void GuiDuLieuChoFragmentB(String dulieu);
        // nhiều phương thức khác

    }

    // OnAttach nhận vào Activity sẽ chạy trên Android 5.0 trở lên
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            giaoTiepHaiFragment = (GiaoTiepHaiFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnArticleSelectedListener");
        }

    }

    // OnAttach nhận vào Activity sẽ chạy trên Android 5.0 trở xuống
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        giaoTiepHaiFragment = (GiaoTiepHaiFragment) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a_layout,container,false);
//        TextView tvHienThi = (TextView) getActivity().findViewById(R.id.tvAcitity);
//        tvHienThi.setText("Xin Chào");
         editText = (EditText) view.findViewById(R.id.edHoTen);
        //lấy dữ liệu từ bundle Activity
//        Bundle bundle = getArguments();
//        editText.setText(bundle.getString("xinchao").toString());

        Button btnGuiDuLieuFragmentB = (Button) view.findViewById(R.id.btnFragmentA);
        btnGuiDuLieuFragmentB.setOnClickListener(this);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        giaoTiepHaiFragment.GuiDuLieuChoFragmentB("Xin chào !");
    }
}
