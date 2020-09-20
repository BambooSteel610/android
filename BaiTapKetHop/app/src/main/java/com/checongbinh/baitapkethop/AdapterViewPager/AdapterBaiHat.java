package com.checongbinh.baitapkethop.AdapterViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.checongbinh.baitapkethop.DTO.HienThiBaiHat;
import com.checongbinh.baitapkethop.R;

import java.util.List;

/**
 * Created by Nhox on 1/14/2016.
 */
public class AdapterBaiHat extends ArrayAdapter<HienThiBaiHat> {
    Context context;
    int resource;
    List<HienThiBaiHat> objects;
    ViewHolder holder;

    public class ViewHolder{
        TextView txtMaBaiHat, txtTenBaiHat, txtLoiBaiHat;
    }

    public AdapterBaiHat(Context context, int resource, List<HienThiBaiHat> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource,null,false);
            holder.txtLoiBaiHat = (TextView) view.findViewById(R.id.txtLoiBaiHat);
            holder.txtMaBaiHat = (TextView) view.findViewById(R.id.txtMaBaiHat);
            holder.txtTenBaiHat = (TextView) view.findViewById(R.id.txtTenBaiHat);
            view.setTag(holder);
        }
        HienThiBaiHat hienThiBaiHat = objects.get(position);

        holder = (ViewHolder) view.getTag();
        holder.txtLoiBaiHat.setText(hienThiBaiHat.getLoibaihat());
        holder.txtTenBaiHat.setText(hienThiBaiHat.getTenbaihat());
        holder.txtMaBaiHat.setText(String.valueOf(hienThiBaiHat.getId()));

        return view;
    }
}
