package com.checongbinh.demoasynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nhox on 12/16/2015.
 */
public class DemoAsyncTask1 extends AsyncTask<Integer,Integer,String> {

    TextView txtHienThi;
    Context context;

    public DemoAsyncTask1(Context context, TextView txtHienThi){
        this.txtHienThi = txtHienThi;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        txtHienThi.setText("AsyncTask đang chạy !");
    }

    @Override
    protected String doInBackground(Integer... params) {
        int nhanthamsotruyenvao = params[0];
        for (int i = 0; i<nhanthamsotruyenvao ; i++){
            publishProgress(i);

        }
        String result = "Tham số truyền từ doinbackground";
        return result;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int giatrinhantudoin = values[0];
        txtHienThi.setText(String.valueOf(giatrinhantudoin));
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
//        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }
}
