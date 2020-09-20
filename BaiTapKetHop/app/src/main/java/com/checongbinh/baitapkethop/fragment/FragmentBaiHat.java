package com.checongbinh.baitapkethop.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.checongbinh.baitapkethop.AdapterViewPager.AdapterBaiHat;
import com.checongbinh.baitapkethop.DTO.HienThiBaiHat;
import com.checongbinh.baitapkethop.Database.CreateDatabase;
import com.checongbinh.baitapkethop.GiaoTiep;
import com.checongbinh.baitapkethop.R;

import java.util.List;

/**
 * Created by Nhox on 1/14/2016.
 */
public class FragmentBaiHat extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_baihat,container,false);
        ListView listView = (ListView) view.findViewById(R.id.listBaiHat);

        CreateDatabase database = new CreateDatabase(getContext());
        List<HienThiBaiHat> baiHatList = database.LayDanhSachBaiHat();
        AdapterBaiHat adapterBaiHat = new AdapterBaiHat(getContext(),R.layout.layout_adapter_baihat,baiHatList);
        listView.setAdapter(adapterBaiHat);
        return view;
    }

}
