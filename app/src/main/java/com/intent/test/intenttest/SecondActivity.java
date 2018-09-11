package com.intent.test.intenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tvNameAndCity = (TextView)findViewById(R.id.tv_secondActivity_nameAndCity);
        Intent intent= getIntent();
        String name = intent.getExtras().getString("NAME");
        String city = intent.getExtras().getString("CITY");
        tvNameAndCity.setText("My name is "+name+" and my city is "+city);


        }

    }

