package com.example.projedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Sounds extends AppCompatActivity {

    private Switch sw1, sw2, sw3, sw4, sw5;
    private Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);

        sw1 = (Switch) findViewById(R.id.sw11);
        sw2 = (Switch) findViewById(R.id.sw22);
        sw3 = (Switch) findViewById(R.id.sw33);
        sw4 = (Switch) findViewById(R.id.sw44);
        sw5 = (Switch) findViewById(R.id.sw55);

        MediaPlayer m = MediaPlayer.create(this, R.raw.annoying);
        MediaPlayer m1 = MediaPlayer.create(this, R.raw.daniel_simion);
        MediaPlayer m2 = MediaPlayer.create(this, R.raw.door_bell);
        MediaPlayer m3 = MediaPlayer.create(this, R.raw.railroad_crossing_bell);
        MediaPlayer m4 = MediaPlayer.create(this, R.raw.school_bell);

        close = (Button) findViewById(R.id.bt_cl);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.sw11: {
                        if (sw1.isChecked()) m.start();else
                        break;
                    }
                    case R.id.sw22: {
                        if (sw2.isChecked()) m1.start();
                        break;
                    }
                    case R.id.sw33: {
                        if (sw3.isChecked()) m2.start();
                        break;
                    }
                    case R.id.sw44: {
                        if (sw4.isChecked()) m3.start();
                        break;
                    }
                    case R.id.sw55: {
                        if (sw5.isChecked()) m4.start();
                        break;
                    }
                    default:
                }
                Intent intent = new Intent(getApplicationContext(),MedicineAdd.class);
                startActivity(intent);
            }
        });
    }
}