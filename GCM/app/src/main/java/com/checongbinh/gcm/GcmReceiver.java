package com.checongbinh.gcm;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

/**
 * Created by Nhox on 1/19/2016.
 */
public class GcmReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"sdlkfjlskjf",Toast.LENGTH_SHORT).show();
    }
}
