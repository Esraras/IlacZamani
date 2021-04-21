package com.example.projedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.huawei.hms.hwid.I;

public class Repeat extends AppCompatActivity {

    private Switch sw1, sw2, sw3, sw4, sw5, sw6, sw7;
    private Button close;

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

        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_repeat);
        Switch sb = new Switch(this);
        sb.setTextOff("OFF");
        sb.setTextOn("ON");
        sb.setChecked(true);
        layout.addView(sb);

        close = (Button) findViewById(R.id.bt_cl) ;
        close.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                String str1, str2, str3, str4, str5, str6, str7;
                switch (v.getId()) {
                    case R.id.swP: {
                        if (sw1.isChecked());
                        break;
                    }
                    case R.id.swS: {
                        if (sw2.isChecked());
                        break;
                    }
                    case R.id.swC: {
                        if (sw3.isChecked());
                        break;
                    }
                    case R.id.swPs: {
                        if (sw4.isChecked());
                        break;
                    }
                    case R.id.swCm: {
                        if (sw5.isChecked());
                        break;
                    }
                    case R.id.swCmr: {
                        if (sw6.isChecked());
                        break;
                    }
                    case R.id.swPz: {
                        if (sw7.isChecked());
                        break;
                    }
                }
                Intent intent = new Intent(getApplicationContext(), MedicineAdd.class);
                startActivity(intent);
            }
        });
    }
}