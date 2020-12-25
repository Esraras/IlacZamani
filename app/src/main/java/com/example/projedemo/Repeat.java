package com.example.projedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class Repeat extends AppCompatActivity {

    private Switch sw1, sw2, sw3, sw4, sw5, sw6, sw7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat);

        sw1 = (Switch) findViewById(R.id.swP);
        sw2 = (Switch) findViewById(R.id.swS);
        sw3 = (Switch) findViewById(R.id.swC);
        sw4 = (Switch) findViewById(R.id.swPs);
        sw5 = (Switch) findViewById(R.id.swCm);
        sw6 = (Switch) findViewById(R.id.swCmr);
        sw7 = (Switch) findViewById(R.id.swPz);
/*
        ?????????????

        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_repeat);
        Switch sb = new Switch(this);
        sb.setTextOff("OFF");
        sb.setTextOn("ON");
        sb.setChecked(true);
        layout.addView(sb);

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String str1, str2, str3, str4, str5, str6, str7;
                switch () {
                    case R.id.swP: {
                        if (sw1.isChecked())
                            str1 = sw1.getTextOn().toString();
                        else
                            str1 = sw1.getTextOff().toString();
                    }
                    case R.id.swS: {
                        if (sw2.isChecked())
                            str2 = sw2.getTextOn().toString();
                        else
                            str2 = sw2.getTextOff().toString();
                    }
                    case R.id.swC: {
                        if (sw3.isChecked())
                            str3 = sw3.getTextOn().toString();
                        else
                            str3 = sw3.getTextOff().toString();
                    }
                    case R.id.swPs: {
                        if (sw4.isChecked())
                            str4 = sw4.getTextOn().toString();
                        else
                            str4 = sw4.getTextOff().toString();
                    }
                    case R.id.swCm: {
                        if (sw5.isChecked())
                            str5 = sw5.getTextOn().toString();
                        else
                            str5 = sw5.getTextOff().toString();
                    }
                    case R.id.swCmr: {
                        if (sw6.isChecked())
                            str6 = sw6.getTextOn().toString();
                        else
                            str6 = sw6.getTextOff().toString();
                    }
                    case R.id.swPz: {
                        if (sw7.isChecked())
                            str7 = sw7.getTextOn().toString();
                        else
                            str7 = sw7.getTextOff().toString();
                    }
                }
            }
        }*/
    }
}