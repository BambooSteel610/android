package com.checongbinh.demosqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.checongbinh.demosqlite.DTO.NhanVienDTO;
import com.checongbinh.demosqlite.R;

import java.util.List;

/**
 * Created by Nhox on 12/6/2015.
 */
public class CustomNhanVienAdapter extends ArrayAdapter<NhanVienDTO> {

    Context context;
    int resource;
    List<NhanVienDTO> objects;

    public CustomNhanVienAdapter(Context context, int resource ,List<NhanVienDTO> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource,parent,false);

        TextView textView = (TextView) view.findViewById(R.id.txtNhanVien);

        textView.setText(objects.get(position).getTennhanvien().toString());

        return view;
    }
}
