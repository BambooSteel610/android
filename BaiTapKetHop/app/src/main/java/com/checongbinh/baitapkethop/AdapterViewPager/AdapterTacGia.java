package com.checongbinh.baitapkethop.AdapterViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.checongbinh.baitapkethop.DTO.TacGia;
import com.checongbinh.baitapkethop.R;

import java.util.List;

/**
 * Created by Nhox on 1/14/2016.
 */
public class AdapterTacGia extends ArrayAdapter<TacGia> {

    Context context;
    int resource;
    List<TacGia> object;
    ViewHolder viewHolder;

    public class ViewHolder {
        TextView txtTenTacGia;
    }

    public AdapterTacGia(Context context, int resource, List<TacGia> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.object = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource,parent,false);

            viewHolder.txtTenTacGia = (TextView) view.findViewById(R.id.txtTenTacGia);

            view.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) view.getTag();

        TacGia tacGia = object.get(position);
        viewHolder.txtTenTacGia.setText(tacGia.getTentacgia());
        viewHolder.txtTenTacGia.setTag(tacGia.getTacgia());

        return view;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource,parent,false);

            viewHolder.txtTenTacGia = (TextView) view.findViewById(R.id.txtTenTacGia);

            view.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) view.getTag();

        TacGia tacGia = object.get(position);
        viewHolder.txtTenTacGia.setText(tacGia.getTentacgia());
        viewHolder.txtTenTacGia.setTag(tacGia.getTacgia());

        return view;
    }
}
