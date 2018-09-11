package com.intent.test.intenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtName = (EditText)findViewById(R.id.et_activityMain_name);
        final EditText edtCity = (EditText)findViewById(R.id.et_activityMain_city);
        final TextView tvNameAndCity = (TextView)findViewById(R.id.tv_activityMain_nameAndCity);
        Button btnSetOnThisPage = (Button)findViewById(R.id.button_activityMain_setOnThisPage);
        Button btnSetOnNextPage = (Button)findViewById(R.id.button_activityMain_setOnNextPage);
        Button btnShowVideoOnNextPage = (Button)findViewById(R.id.btn_activityMain_showVideoOnNextPage);
        Button btnShowAnimOnNextPage = (Button)findViewById(R.id.btn_activityMain_showAnimOnNextPage);

        btnSetOnThisPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvNameAndCity.setText(edtName.getText().toString()+" "+edtCity.getText().toString());
            }
        });

        btnSetOnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("NAME",edtName.getText().toString());
                intent.putExtra("CITY",edtCity.getText().toString());
                startActivity(intent);
            }



        });
        btnShowVideoOnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new  Intent (MainActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
        btnShowAnimOnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Animation_Activity.class);
                startActivity(intent);
            }
        });
    }
}
