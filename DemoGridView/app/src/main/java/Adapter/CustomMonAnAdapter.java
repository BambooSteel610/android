package Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.phananh.demogridview.MonAn;
import com.phananh.demogridview.R;

import java.util.List;

/**
 * Created by Minamino on 1/10/2016.
 */
public class CustomMonAnAdapter extends ArrayAdapter<MonAn> {

    Activity context;
    int resource;
    List<MonAn> objects;
    public CustomMonAnAdapter(Activity context, int resource, List<MonAn> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }
    public class ViewHolder{
        ImageView imgHinhMonAn;
        TextView tenMonAn,moTa;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       View viewrow=convertView;

        if(viewrow==null)
        {
            viewrow=View.inflate(context,R.layout.activity_danh_sach_mon_an,null);

            ViewHolder holder=new ViewHolder();
            holder.tenMonAn= (TextView) viewrow.findViewById(R.id.txtTenMonAn);
            holder.imgHinhMonAn= (ImageView) viewrow.findViewById(R.id.imgHinhMonAn);
            holder.moTa= (TextView) viewrow.findViewById(R.id.txtMoTa);

            viewrow.setTag(holder);
        }
        final ViewHolder holder= (ViewHolder) viewrow.getTag();
        MonAn monAn=getItem(position);
        Log.d("kiemtra","" + monAn.getTenMonAn());
        holder.tenMonAn.setText(monAn.getTenMonAn());
        holder.moTa.setText(monAn.getMoTa());

        monAn.getHinhMonAn().getDataInBackground(new GetDataCallback() {
            public void done(byte[] data, ParseException e) {
                if (e == null) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                    holder.imgHinhMonAn.setImageBitmap(bitmap);

                } else {
                    // something went wrong
                }
            }
        });



        return viewrow;
    }
}
