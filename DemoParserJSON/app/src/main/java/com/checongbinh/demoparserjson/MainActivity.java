package com.checongbinh.demoparserjson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edDiaChi;
    Button btnLayDuLieu;
    String duongdan="https://maps.googleapis.com/maps/api/geocode/json?address=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edDiaChi = (EditText) findViewById(R.id.edDiaChi);
        btnLayDuLieu = (Button) findViewById(R.id.btnLayDuLieu);

        btnLayDuLieu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String duongdanmoi = duongdan + edDiaChi.getText().toString();
        String duongdanchinhxac = duongdanmoi.replace(" ","%20");

        DownLoadDuLieuJSON downLoadDuLieuJSON = new DownLoadDuLieuJSON();

        downLoadDuLieuJSON.execute(duongdanchinhxac);

    }

    public class DownLoadDuLieuJSON extends AsyncTask<String,Void,String>{
        StringBuilder dulieu;
        @Override
        protected String doInBackground(String... params) {

            try {
                URL url = new URL(params[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String dong = "";
                dulieu = new StringBuilder();

                while ((dong = bufferedReader.readLine()) != null){
                    dulieu.append(dong);
                }

                bufferedReader.close();
                reader.close();
                inputStream.close();
                httpURLConnection.disconnect();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return dulieu.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            ParserDuLieuJSON parserDuLieuJSON = new ParserDuLieuJSON(s);
            parserDuLieuJSON.LayLoaiDuLieu();
        }
    }
}
