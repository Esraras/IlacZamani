package com.example.projedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Properties extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout name;
    TextInputLayout age;
    TextInputLayout weight;
    TextInputLayout height;
    Button add;
    RadioGroup radioGroup;
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

        if (ifs() == true ){

            Intent intent = new Intent(getApplicationContext(), Sounds.class);
            startActivity(intent);

            Toast.makeText(this, "Kişi başarıyla eklendi.", Toast.LENGTH_SHORT).show();

        }else
            Toast.makeText(this, "Lütfen bilgilerinizi eksiksiz ve doğru doldurunuz.", Toast.LENGTH_SHORT).show();
    }

    public boolean ifs(){

        radioGroup = findViewById(R.id.gender);
        int selectedID = radioGroup.getCheckedRadioButtonId();
        add = findViewById(selectedID);

        String ed_text = age.getEditText().getText().toString().trim();
        if (isNumeric(ed_text)) {

        }else
            return false;
        String ed_text1 = weight.getEditText().getText().toString().trim();
        if (isNumeric(ed_text1)) {

        }else
            return false;
        String ed_text2 = height.getEditText().getText().toString().trim();
        if (isNumeric(ed_text2)) {

        }else
            return false;
        if (isValidName(name.getEditText().getText().toString())) {

        }else
            return false;
        return true;
    }

    private static boolean isNumeric(String strNum){
        if (strNum == null)
            return true;
        try{
            double d = Double.parseDouble(strNum);
            }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    private static boolean isValidName(String name){
        return name.length() >= 3 && name.length() <= 20;
    }
}