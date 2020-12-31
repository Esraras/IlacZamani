package com.example.projedemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MedicineAdd extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    TimePicker timePicker;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_add);

        timePicker = (TimePicker) findViewById(R.id.tP1);
        timePicker.setIs24HourView(true);

        viewPager= findViewById(R.id.vpPager);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));

        viewPager.addOnPageChangeListener(this);
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