package com.checongbinh.demointernalstorage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edDulieu;
    Button btnGhiDuLieu;
    FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edDulieu = (EditText) findViewById(R.id.edDuLieu);
        btnGhiDuLieu = (Button) findViewById(R.id.btnGhiDuLieu);

        btnGhiDuLieu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String dulieu = edDulieu.getText().toString();
        try {
            Log.d("Duong dan bo nho may",getFilesDir().getAbsolutePath());
            GhiDuLieu(dulieu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void GhiDuLieu (String dulieu) throws IOException {
        try {
            outputStream = openFileOutput("Dulieu.txt", Context.MODE_PRIVATE);
            outputStream.write(dulieu.getBytes());
            Toast.makeText(MainActivity.this,"Ghi dữ liệu thành công",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            outputStream.close();
        }
    }

    public void DocDuLieu(View v){
        try {
            String dulieu;
            FileInputStream fileInputStream = openFileInput("Dulieu.txt");
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuffer chuoidulieu = new StringBuffer();
            while( (dulieu = bufferedReader.readLine()) !=null){
                chuoidulieu.append(dulieu + " ");

            }

            bufferedReader.close();
            reader.close();
            fileInputStream.close();

            Toast.makeText(MainActivity.this,chuoidulieu,Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LuuFileCache(View v){
        try {
            File fileCache = new File(getCacheDir().getPath(),"LuuFileCache.txt");
//            File fileDuLieuLuuCache = File.createTempFile("FileCache",".txt",getCacheDir());
            FileWriter fileWriter = new FileWriter(fileCache);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(edDulieu.getText().toString());
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    File file;
    public void DocFileCache(View v){
//        File[] files = getCacheDir().listFiles();
//        for (int i=0; i<files.length; i++){
//            file = files[i];
//        }
        File fileCache = new File(getCacheDir().getPath() + "/LuuFileCache.txt");
        String dulieu="";
        try {
            FileReader fileReader = new FileReader(fileCache);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            while((dulieu=bufferedReader.readLine()) != null){
                stringBuffer.append(dulieu+"/n");
            }

            bufferedReader.close();
            fileReader.close();
            Toast.makeText(MainActivity.this,stringBuffer,Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean KiemTraTheNhoChiDoc(){
        String trangthai = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(trangthai)){
            return true;
        }
        return false;
    }

    private boolean KiemTraTheNhoDaGan(){
        String trangthai = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(trangthai)){
            return true;
        }

        return false;
    }

    public void GhiFileVaoTheNho(View v){

        if(KiemTraTheNhoDaGan() == false){
            //Xuat thong bao yeu cau nguoi dung gan the nhe
        }else{
            if(KiemTraTheNhoChiDoc() == true){
                //Xuat thong bao cho nguoi dung biet la the nho khong phep ghi
            }else{
                // Tạo ra folder
                File folderTheNho = new File(Environment.getExternalStorageDirectory().getPath() + "/TheNho");
                folderTheNho.mkdirs();

                File fileTheNho = new File(folderTheNho.getPath(),"FileTheNho.txt");

                try {
                    FileOutputStream outputStream = new FileOutputStream(fileTheNho);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                    bufferedOutputStream.write(edDulieu.getText().toString().getBytes());

                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    outputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void DocFileTuTheNho(View v){
        if(KiemTraTheNhoDaGan() == false){
            //Xuat thong bao yeu cau nguoi dung gan the nhe
        }else{
            if(KiemTraTheNhoChiDoc() == true){
                //Xuat thong bao cho nguoi dung biet la the nho khong phep ghi
            }else{
                File fileMuonDoc = new File(Environment.getExternalStorageDirectory().getPath()+"/TheNho","FileTheNho.txt");
                try {
                    FileInputStream inputStream = new FileInputStream(fileMuonDoc);
                    InputStreamReader reader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String dulieu = "";
                    StringBuilder builder = new StringBuilder();
                    while ((dulieu = bufferedReader.readLine()) != null){
                            builder.append(dulieu);
                    }
                    bufferedReader.close();
                    reader.close();
                    inputStream.close();
                    Toast.makeText(MainActivity.this,builder,Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void LuuHinhAnh (View v){
        Bitmap tamhinh = BitmapFactory.decodeResource(getResources(),R.drawable.itclass);
        File duongdanluuhinh = new File(Environment.getExternalStorageDirectory(),"itclass.jpg");
        try {
            FileOutputStream outputStream = new FileOutputStream(duongdanluuhinh);
            tamhinh.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CopyFile(View v){
        File filcancopy = new File(Environment.getExternalStorageDirectory(),"checongbinh.html");
        File vitricopy = new File(Environment.getExternalStorageDirectory() + "/TheNho", filcancopy.getName());

        try {
            FileInputStream inputStream = new FileInputStream(filcancopy);
            FileOutputStream outputStream = new FileOutputStream(vitricopy);

            byte[] buffer = new byte[1024];
            int dungluong;
            while((dungluong = inputStream.read(buffer)) > 0){
                outputStream.write(buffer,0,dungluong);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
