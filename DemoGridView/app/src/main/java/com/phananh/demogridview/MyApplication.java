package com.phananh.demogridview;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Minamino on 1/12/2016.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Parse.initialize(this, "44ra42DBUkUoFkQuXtvIjoqLV551wevzC2hUIq29", "SJzE1h8vM0EnyJqb8XTOnTuvx05WzR9kfs4lba2Y");
    }
}