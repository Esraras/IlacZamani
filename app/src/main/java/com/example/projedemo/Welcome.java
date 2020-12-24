package com.example.projedemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.huawei.agconnect.auth.AGConnectAuth;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    Button out, add;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        out =  (Button) findViewById(R.id.bt_out);
        add =  (Button) findViewById(R.id.bt_add);
    }

    @Override
    public void onClick(View v) {

    }
}

