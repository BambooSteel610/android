package com.checongbinh.baitapkethop.AdapterViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.checongbinh.baitapkethop.DTO.CaSi;
import com.checongbinh.baitapkethop.DTO.SoVol;
import com.checongbinh.baitapkethop.R;

import java.util.List;

/**
 * Created by Nhox on 1/14/2016.
 */
public class AdapterSoVol extends ArrayAdapter<SoVol> {
    ViewHolder viewHolder;
    Context context;
    int resource;
    List<SoVol> objects;

    public class ViewHolder{
        TextView txtTenVol;
    }

    public AdapterSoVol(Context context, int resource, List<SoVol> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource,parent,false);

            viewHolder.txtTenVol = (TextView) view.findViewById(R.id.txtTenTacGia);

            view.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) view.getTag();

        SoVol soVol = objects.get(position);
        viewHolder.txtTenVol.setText(soVol.getTenvol());
        viewHolder.txtTenVol.setTag(soVol.getId());

        return view;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource,parent,false);

            viewHolder.txtTenVol = (TextView) view.findViewById(R.id.txtTenTacGia);

            view.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) view.getTag();

        SoVol soVol = objects.get(position);
        viewHolder.txtTenVol.setText(soVol.getTenvol());
        viewHolder.txtTenVol.setTag(soVol.getId());

        return view;
    }
}
