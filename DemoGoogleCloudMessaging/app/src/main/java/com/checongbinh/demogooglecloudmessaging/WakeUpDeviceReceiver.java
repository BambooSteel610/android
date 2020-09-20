package com.checongbinh.demogooglecloudmessaging;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

/**
 * Created by Nhox on 1/20/2016.
 */
public class WakeUpDeviceReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"đã nhận được thông điệp !",Toast.LENGTH_SHORT).show();
    }
}
