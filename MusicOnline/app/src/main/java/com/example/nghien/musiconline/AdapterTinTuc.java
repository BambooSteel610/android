package com.example.nghien.musiconline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nhox on 12/25/2015.
 */
public class AdapterTinTuc extends BaseAdapter {

    Context context;
    int layout;
    List<BaiViet> dsBaiViet;

    public class ViewHolder{
        TextView txtTieuDe,txtNgayDang,txtMoTa, txtLink;
       // ImageView hinhTinTuc;
    }

    public AdapterTinTuc(Context context,int layout, List<BaiViet> dsBaiViet){
        this.context = context;
        this.layout = layout;
        this.dsBaiViet = dsBaiViet;
    }

    @Override
    public int getCount() {
        return dsBaiViet.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,parent,false);

            ViewHolder holder = new ViewHolder();
            holder.txtTieuDe= (TextView) view.findViewById(R.id.txtTieuDe);
            holder.txtMoTa = (TextView) view.findViewById(R.id.txtNoiDung);
            holder.txtNgayDang = (TextView) view.findViewById(R.id.txtNgayDang);
            holder.txtLink = (TextView) view.findViewById(R.id.txtLink);

          //  holder.hinhTinTuc = (ImageView) view.findViewById(R.id.hinhDaiDien);

            view.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) view.getTag();



        holder.txtTieuDe.setText(dsBaiViet.get(position).getTitle());

        holder.txtMoTa.setText(dsBaiViet.get(position).getDescription());
        holder.txtNgayDang.setText(dsBaiViet.get(position).getDescription());
        holder.txtLink.setText(dsBaiViet.get(position).getLink());
        return view;

      //  String duongdan = dsBaiViet.get(position).getImage();
//        DownloadHinhAnh downloadHinhAnh = new DownloadHinhAnh();
//        downloadHinhAnh.execute(duongdan);
//        try {
//            holder.hinhTinTuc.setImageBitmap(downloadHinhAnh.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


    }

//    public class DownloadHinhAnh extends AsyncTask<String,Void,Bitmap>{
//        Bitmap hinhanhdownload;
//        @Override
//        protected Bitmap doInBackground(String... params) {
//
//            try {
//                URL url = new URL(params[0]);
//                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//                httpURLConnection.connect();
//
//                InputStream inputStream = httpURLConnection.getInputStream();
//                hinhanhdownload = BitmapFactory.decodeStream(inputStream);
//
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return hinhanhdownload;
//        }
//    }

}
