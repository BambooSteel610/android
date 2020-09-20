package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.checongbinh.demogridview.R;

/**
 * Created by Nhox on 11/1/2015.
 */
public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    int layout;
    int[] danhsachanh;

    public CustomBaseAdapter(Context context,int layout, int[] danhsachanh){
        this.context = context;
        this.layout = layout;
        this.danhsachanh = danhsachanh;
    }

    private class ViewHolder{
        ImageView hinhanh;
    }

    @Override
    public int getCount() {
        return danhsachanh.length;
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
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewrow = inflater.inflate(layout,parent,false);

            ViewHolder holder = new ViewHolder();
            holder.hinhanh = (ImageView) viewrow.findViewById(R.id.imHinhAnh);

            viewrow.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) viewrow.getTag();
        holder.hinhanh.setImageResource(danhsachanh[position]);

        return viewrow;
    }
}
