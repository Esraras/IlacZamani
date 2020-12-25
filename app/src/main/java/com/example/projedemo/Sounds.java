package com.example.projedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Switch;

public class Sounds extends AppCompatActivity {

    private Switch sw1, sw2, sw3, sw4, sw5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);

        sw1 = (Switch) findViewById(R.id.sw11);
        sw2 = (Switch) findViewById(R.id.sw22);
        sw3 = (Switch) findViewById(R.id.sw33);
        sw4 = (Switch) findViewById(R.id.sw44);
        sw5 = (Switch) findViewById(R.id.sw55);
    }
}