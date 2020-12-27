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
    /*       TextInputEditText ed = (TextInputEditText) findViewById(R.id.til_age);
        String ed_text = ed.getText().toString().trim();
     if (isNumeric(ed_text)) {

            Toast.makeText(this, "dogru", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "yanlis", Toast.LENGTH_SHORT).show();
*/
        if (isValidName(name.getEditText().toString())) {
            Toast.makeText(this, "Kişi başarıyla eklendi.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Lütfen geçerli bir ad giriniz.", Toast.LENGTH_SHORT).show();
        }
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

    private boolean isValidName(String name){
        return name.length() >= 3 && name.length() <= 20;
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_man:
                if (checked)

                    break;
            case R.id.rb_woman:
                if (checked)

                     break;
        }
    }
}