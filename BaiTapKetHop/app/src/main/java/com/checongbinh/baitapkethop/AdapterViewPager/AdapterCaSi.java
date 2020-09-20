package com.checongbinh.baitapkethop.AdapterViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.checongbinh.baitapkethop.DTO.CaSi;
import com.checongbinh.baitapkethop.DTO.TacGia;
import com.checongbinh.baitapkethop.R;

import java.util.List;

/**
 * Created by Nhox on 1/14/2016.
 */
public class AdapterCaSi extends ArrayAdapter<CaSi> {

    ViewHolder viewHolder;
    Context context;
    int resource;
    List<CaSi> objects;

    public AdapterCaSi(Context context, int resource, List<CaSi> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    public class ViewHolder{
        TextView txtTenCaSi;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource,parent,false);

            viewHolder.txtTenCaSi = (TextView) view.findViewById(R.id.txtTenTacGia);

            view.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) view.getTag();

        CaSi caSi = objects.get(position);
        viewHolder.txtTenCaSi.setText(caSi.getTencasi());
        viewHolder.txtTenCaSi.setTag(caSi.getId());

        return view;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource,parent,false);

            viewHolder.txtTenCaSi = (TextView) view.findViewById(R.id.txtTenTacGia);

            view.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) view.getTag();

        CaSi caSi = objects.get(position);
        viewHolder.txtTenCaSi.setText(caSi.getTencasi());
        viewHolder.txtTenCaSi.setTag(caSi.getId());

        return view;
    }
}
