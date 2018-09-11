package com.intent.test.intenttest;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class ShowNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_number);

        final boolean[] txtAddMoneyBoolean = {true};


        View view_showNumberActivity = (View)findViewById(R.id.view_showNumberActivity_circelView);
        Button addMoney = (Button) findViewById(R.id.button_showNumberActivity_addMoney);
        Button loseMoney = (Button) findViewById(R.id.button_showNumberActivity_loseMoney);
        Animation myAnimation = AnimationUtils.loadAnimation(G.context, R.anim.animation);
        Animation myAnimation1 = AnimationUtils.loadAnimation(G.context, R.anim.animation1);
        Animation myAnimation2 = AnimationUtils.loadAnimation(G.context, R.anim.animation2);
        final TextView txtAddMoney = (TextView)findViewById(R.id.textView_showNumberActivity_txtAddMoney);
        TextView txtLoseMoney = (TextView) findViewById(R.id.textView_showNumberActivity_txtLoseMoney);
        final EditText edtAddMoney = (EditText)findViewById(R.id.edt_showNumberActivity_edtAdd);
        EditText edtLoseMoney = (EditText)findViewById(R.id.edt_showNumberActivity_edtLose);
        final RadioButton radioAddMoneyFrist = (RadioButton)findViewById(R.id.radioButton_showNumberActivity_radiofiristAdd);
        final RadioButton radioAddMoneySecond = (RadioButton)findViewById(R.id.radioButton_showNumberActivity_radiosecondAdd);
        RadioButton radioLoseMoneyFirist = (RadioButton)findViewById(R.id.radioButton_showNumberActivity_radiofiristLose);
        RadioButton radioLoseMoneySecond = (RadioButton)findViewById(R.id.radioButton_showNumberActivity_radiosecondLose);

        final TextView moneyNumber = (TextView)findViewById(R.id.textView_showNumberActivity_moneyNumber);



        ValueAnimator numberAnimation = ValueAnimator.ofInt(0,1000);
        numberAnimation.setDuration(1500);
        numberAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                moneyNumber.setText(valueAnimator.getAnimatedValue().toString());

            }
        });
        numberAnimation.start();



        view_showNumberActivity.setAnimation(myAnimation);
        addMoney.setAnimation(myAnimation1);
        loseMoney.setAnimation(myAnimation1);
        txtAddMoney.setAnimation(myAnimation2);
        txtAddMoney.setVisibility(View.VISIBLE);
        txtLoseMoney.setAnimation(myAnimation2);
        txtLoseMoney.setVisibility(View.VISIBLE);

        addMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int moneyNumberInt = Integer.valueOf(moneyNumber.getText().toString());


                if(txtAddMoneyBoolean[0]){
                    txtAddMoney.setText("ذخیره درآمد ");
                    radioAddMoneyFrist.setVisibility(View.VISIBLE);
                    radioAddMoneySecond.setVisibility(View.VISIBLE);
                    edtAddMoney.setVisibility(View.VISIBLE);
                    txtAddMoneyBoolean[0] =false;

                }else {
                    txtAddMoney.setText("افزودن درآمد");
                    radioAddMoneyFrist.setVisibility(View.GONE);
                    radioAddMoneySecond.setVisibility(View.GONE);
                    edtAddMoney.setVisibility(View.GONE);
                    txtAddMoneyBoolean[0] = true;
                    moneyNumberInt += Integer.valueOf(edtAddMoney.getText().toString());
                    moneyNumber.setText(moneyNumberInt);

                }


            }
        });



    }

}
