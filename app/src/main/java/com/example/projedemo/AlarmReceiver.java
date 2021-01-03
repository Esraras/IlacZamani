package com.example.projedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("TAG", "oley");

        Intent service_intent = new Intent(context, RingtonePlayingService.class);
        context.startService(service_intent);
    }
}
