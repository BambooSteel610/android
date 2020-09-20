package com.checongbinh.demobaseadapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.checongbinh.demobaseadapter.Album;
import com.checongbinh.demobaseadapter.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Nhox on 10/28/2015.
 */
public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Album> albums;

    public CustomBaseAdapter(Context context,int layout, List<Album> albums){
        this.context = context;
        this.layout = layout;
        this.albums = albums;
    }

//    public CustomBaseAdapter(Context context,int layout, String[] dulieu){

//    }

    public static class ViewHolder{
        ImageView hinhAlbum;
        TextView tenAlbum,ngayPhatHanh;
    }

    @Override
    public int getCount() {
        return albums.size(); // Trả ra số item sẽ được hiển thị trong listview
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewrow = convertView;
        if(viewrow == null){
            viewrow = inflater.inflate(layout,parent,false);
            ViewHolder holder = new ViewHolder();
            holder.hinhAlbum = (ImageView) viewrow.findViewById(R.id.hinhAlbum);
            holder.tenAlbum = (TextView) viewrow.findViewById(R.id.tenAlbum);
            holder.ngayPhatHanh = (TextView) viewrow.findViewById(R.id.ngayPhatHanh);
            viewrow.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) viewrow.getTag();
        holder.hinhAlbum.setImageResource(albums.get(position).getHinhAnh());
        holder.tenAlbum.setText("Tên Album : " + albums.get(position).getTenAlbum().toString());
        holder.ngayPhatHanh.setText("Ngày phát hành : " + albums.get(position).getNgayPhatHanh().toString());

        return viewrow;
    }
}
