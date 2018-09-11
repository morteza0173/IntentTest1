package com.intent.test.intenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

public class Animation_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_);

        final Boolean[] anim = {true};
        final Boolean[] anim1 = {false};

        Button btnStart = (Button)findViewById(R.id.button_animationActivity_startAnim);
        final Button btnAnim = (Button)findViewById(R.id.button_animationActivity_btnAnim);
        Button btnback = (Button)findViewById(R.id.button_animationActivity_startAnimBack);
        final Animation animation= AnimationUtils.loadAnimation(Animation_Activity.this,R.anim.animation);
        final Animation animation1= AnimationUtils.loadAnimation(Animation_Activity.this,R.anim.animation1);
        final Animation animation2= AnimationUtils.loadAnimation(Animation_Activity.this,R.anim.animation2);
        final Animation animation3= AnimationUtils.loadAnimation(Animation_Activity.this,R.anim.animation3);
        final Button btnAnim1 = (Button)findViewById(R.id.button_animationActivity_btnAnim1);
        final Button btnAnim2 = (Button)findViewById(R.id.button_animationActivity_btnAnim2);
        final Button btnAnim3 = (Button)findViewById(R.id.button_animationActivity_btnAnim3);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (anim[0] ){


                    if(anim1[0]) {


                    }else {
                        anim1[0] = true;

                        Animation animation = new TranslateAnimation(1500, 0, 0, 0);
                        animation.setDuration(1000);
                        animation.setFillAfter(true);
                        btnAnim.startAnimation(animation);
                        btnAnim.setVisibility(View.VISIBLE);


                        Animation animation1 = new TranslateAnimation(1500, 0, 0, 0);
                        animation1.setDuration(1500);
                        animation1.setFillAfter(true);
                        btnAnim1.startAnimation(animation1);
                        btnAnim1.setVisibility(View.VISIBLE);

                        Animation animation2 = new TranslateAnimation(1500, 0, 0, 0);
                        animation2.setDuration(2000);
                        animation2.setFillAfter(true);
                        btnAnim2.startAnimation(animation2);
                        btnAnim2.setVisibility(View.VISIBLE);

                        Animation animation3 = new TranslateAnimation(1500, 0, 0, 0);
                        animation3.setDuration(2500);
                        animation3.setFillAfter(true);
                        btnAnim3.startAnimation(animation3);
                        btnAnim3.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                btnAnim3.setVisibility(View.VISIBLE);
                                anim[0] = false;


                            }
                        }, 2500);

                    }

                }
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (anim[0]) {





                }else{

                    if(anim1[0]){
                    anim1[0]= false;

                    Animation animation = new TranslateAnimation(0, -1500,0, 0);
                    animation.setDuration(1000);
                    animation.setFillAfter(true);
                    btnAnim.startAnimation(animation);
                    btnAnim.setVisibility(View.INVISIBLE);


                    Animation animation1 = new TranslateAnimation(0, -1500,0, 0);
                    animation1.setDuration(1500);
                    animation1.setFillAfter(true);
                    btnAnim1.startAnimation(animation1);
                    btnAnim1.setVisibility(View.INVISIBLE);

                    Animation animation2 = new TranslateAnimation(0, -1500,0, 0);
                    animation2.setDuration(2000);
                    animation2.setFillAfter(true);
                    btnAnim2.startAnimation(animation2);
                    btnAnim2.setVisibility(View.INVISIBLE);

                    Animation animation3 = new TranslateAnimation(0, -1500,0, 0);
                    animation3.setDuration(2500);
                    animation3.setFillAfter(true);
                    btnAnim3.startAnimation(animation3);
                    btnAnim3.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btnAnim3.setVisibility(View.INVISIBLE);
                            anim[0]= true;

                        }
                    },1500);




                }}
            }         }
    );


    btnAnim.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent= new Intent(Animation_Activity.this,ItemlistActivity.class);
            startActivity(intent);
        }
    });


    btnAnim1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent= new Intent(Animation_Activity.this,CustomViewListActivity.class);
            startActivity(intent);
        }
    });



    btnAnim2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent= new Intent(Animation_Activity.this , ShowNumberActivity.class);
            startActivity(intent);
        }
    });


    }
}
