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
                this.startId = 1;
                break;
            case "off":
                this.startId = 0;
                break;
            default:
                this.startId = 0;
                break;
        }
        song = MediaPlayer.create(this, R.raw.daniel_simion);

        isRunning = true;
        if (!this.isRunning && this.startId == 1) {

            song.start();

            this.isRunning = true;
            this.startId = 0;

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Intent intentAdd = new Intent(this.getApplicationContext(), MedicineAdd.class);

            PendingIntent pendingIntentAdd = PendingIntent.getActivity(this, 0, intentAdd, 0);

            Notification notification = new Notification.Builder(this)
                    .setContentTitle("Alarm çalıyor")
                    .setContentText("DOKUN")
                    .setContentIntent(pendingIntentAdd)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.hiad_play)
                    .build();

            notificationManager.notify(1, notification);


        }else if (this.isRunning && this.startId == 0){

            song.stop();
            song.reset();
            this.isRunning = false;
            this.startId = 0;

        }else if (!this.isRunning && this.startId == 0){

            this.isRunning =false;
            this.startId = 0;

        }else if (this.isRunning && this.startId == 1){

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
