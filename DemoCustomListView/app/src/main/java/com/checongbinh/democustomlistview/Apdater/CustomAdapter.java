package com.checongbinh.democustomlistview.Apdater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.checongbinh.democustomlistview.Album;
import com.checongbinh.democustomlistview.R;

import java.util.List;

/**
 * Created by Nhox on 10/27/2015.
 */
public class CustomAdapter extends ArrayAdapter<Album> {
    Context context;
    int resource;
    List<Album> listAlbum;

    public CustomAdapter(Context context, int resource, List<Album> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.listAlbum = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowItem = inflater.inflate(resource,parent,false);

        ImageView hinhAlbum = (ImageView) rowItem.findViewById(R.id.hinhAlbum);
        TextView tenAlbum = (TextView) rowItem.findViewById(R.id.tenAlbum);
        TextView ngayPhatHanh = (TextView) rowItem.findViewById(R.id.ngayPhatHanh);

        hinhAlbum.setImageResource(listAlbum.get(position).getHinhAnh());
        tenAlbum.setText("Tên Album : " + listAlbum.get(position).getTenAlbum().toString());
        ngayPhatHanh.setText("Ngày phát hành : " + listAlbum.get(position).getNgayPhatHanh().toString());

        return rowItem;
    }
}
