package com.intent.test.intenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;

public class ShowNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_number);

        View view_showNumberActivity = (View)findViewById(R.id.view_showNumberActivity_circelView);
        Animation myAnimation = AnimationUtils.loadAnimation(G.context, R.anim.animation);



        view_showNumberActivity.setAnimation(myAnimation);
    }

}
