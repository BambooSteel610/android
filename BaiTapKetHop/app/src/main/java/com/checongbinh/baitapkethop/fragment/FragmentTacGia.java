package com.checongbinh.baitapkethop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.checongbinh.baitapkethop.DTO.TacGia;
import com.checongbinh.baitapkethop.Database.CreateDatabase;
import com.checongbinh.baitapkethop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nhox on 1/14/2016.
 */
public class FragmentTacGia extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tacgia,container,false);
        ListView listView = (ListView) view.findViewById(R.id.listTacGia);

        List<String> list = new ArrayList<String>();

        CreateDatabase database = new CreateDatabase(getContext());
        List<TacGia> tacGias = database.LayDanhSachTacGia();
        for (int i=0; i<tacGias.size();i++){
            list.add(tacGias.get(i).getTentacgia());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        return view;
    }
}
