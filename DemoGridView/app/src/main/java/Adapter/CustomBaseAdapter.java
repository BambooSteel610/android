package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phananh.demogridview.DanhMuc;
import com.phananh.demogridview.R;

import java.util.ArrayList;

/**
 * Created by Nhox on 11/1/2015.
 */
public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<DanhMuc> danhsachanh;

    public CustomBaseAdapter(Context context,int layout, ArrayList<DanhMuc> danhsachanh){
        this.context = context;
        this.layout = layout;
        this.danhsachanh = danhsachanh;
    }

    private class ViewHolder{
        ImageView hinhanh;
        TextView txtText;
    }

    @Override
    public int getCount() {
        return danhsachanh.size();
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
        View viewrow = convertView;
        if(viewrow == null){
            viewrow=View.inflate(context,R.layout.custom_layout_gridview,null);

            ViewHolder holder = new ViewHolder();
            holder.hinhanh = (ImageView) viewrow.findViewById(R.id.imHinhAnh);
            holder.txtText= (TextView) viewrow.findViewById(R.id.txtText);

            viewrow.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) viewrow.getTag();
        holder.hinhanh.setImageResource(danhsachanh.get(position).getHinh());
        holder.txtText.setText(danhsachanh.get(position).getTen());

        return viewrow;
    }
}
