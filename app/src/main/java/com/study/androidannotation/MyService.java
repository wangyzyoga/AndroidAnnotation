package com.study.androidannotation;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import org.androidannotations.annotations.EService;

@EService
public class MyService extends Service {

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("*****nate*****", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
