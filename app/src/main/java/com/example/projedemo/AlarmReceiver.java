package com.example.projedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("TAG", "oley");

        String getYourString = intent.getExtras().getString("extra");
        Log.e("what is the key?", getYourString);

        Intent service_intent = new Intent(context, RingtonePlayingService.class);
        service_intent.putExtra("extra", getYourString);

        context.startService(service_intent);
    }
}
