package com.checongbinh.demointentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Nhox on 11/16/2015.
 */
public class DemoIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public DemoIntentService() {
        super("My IntentService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this){
            int dem = 0;
            while (dem < 20){
                try {
                    wait(1000);
                    Log.d("DemIntentService","" + dem);
                    dem++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"IntentService đã dừng",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
