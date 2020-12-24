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
import com.huawei.hms.hwid.I;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    Button out, add;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        out =  (Button) findViewById(R.id.bt_out);
        out.setOnClickListener(this);
        add =  (Button) findViewById(R.id.bt_add);
        add.setOnClickListener(this::onClickAdd);
    }

    private void onClickAdd(View view) {

        Intent intent = new Intent(getApplicationContext(), Properties.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }
}

