package com.checongbinh.demodownloadfileintentservice;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nhox on 11/16/2015.
 */
public class DownloadFileService extends IntentService {

    private int result = Activity.RESULT_OK;
    public static final String URL = "duongdan";
    public static final String FILENAME = "tendfile";
    public static final String FILEPATH = "duongdanfile";
    public static final String RESULT = "ketqua";
    public static final String NOTIFICATION = "com.checongbinh.demodownloadfileintentservice";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public DownloadFileService() {
        super("Download File From Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String urlPath = intent.getStringExtra("duongdan");
        String fileName = intent.getStringExtra(FILENAME);
        File output = new File(Environment.getExternalStorageDirectory(),fileName);

        if(output.exists()){
            output.delete();
        }

        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            URL url = new URL(urlPath);
            inputStream = url.openConnection().getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            outputStream = new FileOutputStream(output.getPath());

            int next = -1;
            while((next = reader.read()) != -1){
                outputStream.write(next);
            }
            result = Activity.RESULT_OK;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream == null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        publishResult(output.getAbsolutePath(),result);
    }

    public void publishResult(String outputPath,int result){
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(FILEPATH,outputPath);
        intent.putExtra(RESULT,result);
        sendBroadcast(intent);
    }
}
