package com.checongbinh.demobroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Nhox on 12/16/2015.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
//        String trangcuocgoi = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
//        Toast.makeText(context,"trangcuocgoi : " + trangcuocgoi ,Toast.LENGTH_SHORT).show();
        String dulieu = intent.getStringExtra("dulieu");
        Toast.makeText(context, dulieu ,Toast.LENGTH_SHORT).show();
    }
}
