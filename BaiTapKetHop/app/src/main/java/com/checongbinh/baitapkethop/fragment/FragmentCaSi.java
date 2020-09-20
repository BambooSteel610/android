package com.checongbinh.baitapkethop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.checongbinh.baitapkethop.DTO.CaSi;
import com.checongbinh.baitapkethop.DTO.TacGia;
import com.checongbinh.baitapkethop.Database.CreateDatabase;
import com.checongbinh.baitapkethop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nhox on 1/14/2016.
 */
public class FragmentCaSi extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_casi,container,false);
        ListView listView = (ListView) view.findViewById(R.id.listCaSi);
        List<String> list = new ArrayList<String>();

        CreateDatabase database = new CreateDatabase(getContext());
        List<CaSi> caSis = database.LayDanhSachCaSi();
        for (int i=0; i<caSis.size();i++){
            list.add(caSis.get(i).getTencasi());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        return view;
    }
}
