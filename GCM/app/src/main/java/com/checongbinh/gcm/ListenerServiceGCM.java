package com.checongbinh.gcm;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by Nhox on 1/19/2016.
 */
public class ListenerServiceGCM extends GcmListenerService {

    @Override
    public void onMessageReceived(String from, Bundle data) {
        super.onMessageReceived(from, data);

        String message = data.getString("abc");
        Log.d("from : ", from);
        Log.d("meassage : ",message);
    }


}
