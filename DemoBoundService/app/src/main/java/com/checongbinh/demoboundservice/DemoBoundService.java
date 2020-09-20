package com.checongbinh.demoboundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Nhox on 11/16/2015.
 */
public class DemoBoundService extends Service {
    IBinder iBinder = new LocalBinder(); // Liên kết đến Client

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class LocalBinder extends Binder {
        LocalBinder getLocalBinder(){
            return LocalBinder.this; // Phương thức khởi tạo khi Client gọi tới các phương thức của service
        }
    }

    public String XinChao(){
        return "Xin chào các bạn !";
    }

    public int CongHaiSo(int soA, int soB){
        return soA + soB;
    }
}
