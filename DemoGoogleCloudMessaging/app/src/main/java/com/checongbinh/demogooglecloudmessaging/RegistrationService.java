package com.checongbinh.demogooglecloudmessaging;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

/**
 * Created by Nhox on 1/20/2016.
 */
public class RegistrationService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public RegistrationService() {
        super("Dang Ky ID Client App");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        InstanceID instanceID = InstanceID.getInstance(this);

        try {

            String maClient = instanceID.getToken(getString(R.string.sender_id), GoogleCloudMessaging.INSTANCE_ID_SCOPE,null);
            Log.d("Mã client đã đăng ký : " , maClient);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
