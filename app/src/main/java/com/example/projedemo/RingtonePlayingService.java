package com.example.projedemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.security.Provider;
import java.util.List;
import java.util.Map;

public class RingtonePlayingService extends Service {

    MediaPlayer song;
    int startId;
    Boolean isRunning;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String state = intent.getExtras().getString("extra");

        Log.e("Ringtone state : extra", state);

        switch (state) {
            case "on":
                startId = 1;
                break;
            case "off":
                startId = 0;
                break;
            default:
                startId = 0;
                break;
        }

        isRunning = false;
        if (!this.isRunning && startId == 1) {

            song = MediaPlayer.create(this, R.raw.daniel_simion);
            song.start();

            this.isRunning = true;
            this.startId = 0;

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Intent intentAdd = new Intent(this.getApplicationContext(), MedicineAdd.class);

            PendingIntent pendingIntentAdd = PendingIntent.getActivity(this, 0, intentAdd, 0);

            Notification notification = new Notification.Builder(this)
                    .setContentTitle("Alarm kapatılıyor")
                    .setContentText("DOKUN")
                    .setContentIntent(pendingIntentAdd)
                    .setAutoCancel(true)
                    .build();

            notificationManager.notify(0, notification);


        }else if (this.isRunning && startId == 0){

            song.stop();
            song.reset();
            this.isRunning = false;
            this.startId = 0;

        }else if (!this.isRunning && startId == 0){

            this.isRunning =false;
            this.startId = 0;

        }else if (this.isRunning && startId == 1){

            this.isRunning = true;
            this.startId = 1;

        }else{
            this.isRunning = false;
            this.startId = 0;
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.e("on destroy called", "dada");

        super.onDestroy();
        this.isRunning = false;
    }


}
