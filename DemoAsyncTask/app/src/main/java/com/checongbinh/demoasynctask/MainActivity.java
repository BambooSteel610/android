package com.checongbinh.demoasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    TextView txtHienThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHienThi = (TextView) findViewById(R.id.txtHienThi);

        DemoAsyncTask1 demoAsyncTask1 = new DemoAsyncTask1(this,txtHienThi);
        demoAsyncTask1.execute(10,30,40,50);

        try {
            String giatricuoicung = demoAsyncTask1.get();
            Toast.makeText(this, giatricuoicung, Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        DemoAsycnTask demoAsycnTask = new DemoAsycnTask();
//        demoAsycnTask.execute(10,30,40,50);
    }

//    public class DemoAsycnTask extends AsyncTask<Integer,Integer,String>{
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            txtHienThi.setText("AsyncTask đang chạy !");
//        }
//
//        @Override // worker thread
//        protected String doInBackground(Integer... params) {
//            int nhanthamsotruyenvao = params[1];
//            for (int i = 0; i<nhanthamsotruyenvao ; i++){
//                publishProgress(i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            String result = "Tham số truyền từ doinbackground";
//            return result;
//        }
//
//        @Override
//        protected void onProgressUpdate(Integer... values) {
//            super.onProgressUpdate(values);
//            int giatrinhantudoin = values[0];
//            txtHienThi.setText(String.valueOf(giatrinhantudoin));
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
//            Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
//        }
//    }
}
