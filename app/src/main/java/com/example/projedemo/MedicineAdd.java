package com.example.projedemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowMetrics;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
public class MedicineAdd extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    TimePicker timePicker;
    TextView textView;
    ViewPager viewPager;
    Button save, close;
    AlarmManager alarmManager;
    Context context;
    PendingIntent pendingIntent;
    Calendar calendar;
    Intent my_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_add);

        this.context = this;
        textView = (TextView) findViewById(R.id.tv_clock);

        timePicker = (TimePicker) findViewById(R.id.tP1);
        timePicker.setIs24HourView(true);

        viewPager= findViewById(R.id.vpPager);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(this);

        calendar = Calendar.getInstance();

        my_intent = new Intent(this.context, AlarmReceiver.class);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        close = (Button) findViewById(R.id.bt_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarmText("Alarm kapatıldı.");
                alarmManager.cancel(pendingIntent);

                my_intent.putExtra("extra","off");
                sendBroadcast(my_intent);
            }
        });

        save = (Button) findViewById(R.id.bt_save);
        save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                setAlarmText("Alarm kuruldu.");

                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());

                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                String hourString = String.valueOf(hour);
                String minuteString = String.valueOf(minute);

                setAlarmText("Alarm kuruldu : " + hourString + ":" + minuteString);

                my_intent.putExtra("extra","on");

                pendingIntent = PendingIntent.getBroadcast(MedicineAdd.this,0, my_intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        });
    }

    private void setAlarmText(String alarm) {
        textView.setText(alarm);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}