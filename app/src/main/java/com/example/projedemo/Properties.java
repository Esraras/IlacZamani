package com.example.projedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Properties extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout name, age, weight, height;
    Button add;
    RadioButton woman, man;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties);

        name = (TextInputLayout) findViewById(R.id.til_name);
        age = (TextInputLayout) findViewById(R.id.til_age);
        weight = (TextInputLayout) findViewById(R.id.til_weight);
        height = (TextInputLayout) findViewById(R.id.til_height);

        woman = (RadioButton) findViewById(R.id.rb_woman);
        man = (RadioButton) findViewById(R.id.rb_man);

        add = (Button) findViewById(R.id.bt_add);
        add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (isValidName(name.getEditText().toString())){
            Intent intent = new Intent(getApplicationContext(), MedicineAdd.class);
            startActivity(intent);

            Toast.makeText(this, "Kişi başarıyla eklendi.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Lütfen geçerli bir ad giriniz.", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isValidName(String name){
        if (name.length() >=3 && name.length() <=20){
            return true;
        }else{
            return false;
        }

    }
}