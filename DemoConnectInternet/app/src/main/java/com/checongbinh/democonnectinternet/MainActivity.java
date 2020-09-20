package com.checongbinh.democonnectinternet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Bitmap bitmap;
    InputStream inputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
    }

    private boolean KiemTraKetNoiMang(){
        ConnectivityManager connectivityManager = (ConnectivityManager) MainActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo !=null && networkInfo.isConnected()){
            return true;
        }else{
            return false;
        }

    }

    public void TaiHinhAnh(View v){
        String linkhinh = "http://dchabmztumu0g.cloudfront.net/wp-content/uploads/2013/05/jsonparsing.png";
        if(KiemTraKetNoiMang()){
            DownLoadHinhAnh downLoadHinhAnh = new DownLoadHinhAnh();
            downLoadHinhAnh.execute(linkhinh);
        }else{
            Toast.makeText(getApplicationContext(),"Vui lòng kết nối mạng !",Toast.LENGTH_SHORT);
        }

    }

    public class DownLoadHinhAnh extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"đang tải hình ảnh",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setReadTimeout(10000);
//            httpURLConnection.setConnectTimeout(10000);
//            httpURLConnection.setRequestMethod("post");
                httpURLConnection.connect();
                int status = httpURLConnection.getResponseCode();

                if(status == HttpURLConnection.HTTP_OK){
                    inputStream = httpURLConnection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);

                }

                httpURLConnection.disconnect();
                inputStream.close();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);

            imageView.setImageBitmap(result);
        }
    }

}
