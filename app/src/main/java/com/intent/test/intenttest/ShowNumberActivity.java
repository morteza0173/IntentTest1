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
        final boolean[] txtLoseMoneyBoolean = {true};


        View view_showNumberActivity = (View)findViewById(R.id.view_showNumberActivity_circelView);
        Button addMoney = (Button) findViewById(R.id.button_showNumberActivity_addMoney);
        Button loseMoney = (Button) findViewById(R.id.button_showNumberActivity_loseMoney);
        Animation myAnimation = AnimationUtils.loadAnimation(G.context, R.anim.animation);
        Animation myAnimation1 = AnimationUtils.loadAnimation(G.context, R.anim.animation1);
        Animation myAnimation2 = AnimationUtils.loadAnimation(G.context, R.anim.animation2);
        final TextView txtAddMoney = (TextView)findViewById(R.id.textView_showNumberActivity_txtAddMoney);
        final TextView txtLoseMoney = (TextView) findViewById(R.id.textView_showNumberActivity_txtLoseMoney);
        final EditText edtAddMoney = (EditText)findViewById(R.id.edt_showNumberActivity_edtAdd);
        final EditText edtLoseMoney = (EditText)findViewById(R.id.edt_showNumberActivity_edtLose);
        final RadioButton radioAddMoneyFrist = (RadioButton)findViewById(R.id.radioButton_showNumberActivity_radiofiristAdd);
        final RadioButton radioAddMoneySecond = (RadioButton)findViewById(R.id.radioButton_showNumberActivity_radiosecondAdd);
        final RadioButton radioLoseMoneyFirist = (RadioButton)findViewById(R.id.radioButton_showNumberActivity_radiofiristLose);
        final RadioButton radioLoseMoneySecond = (RadioButton)findViewById(R.id.radioButton_showNumberActivity_radiosecondLose);

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

        final int[] moneyNumberInt = {Integer.valueOf(moneyNumber.getText().toString())};


        addMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




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
                    moneyNumberInt[0] += Integer.valueOf(edtAddMoney.getText().toString());

                    int moneyNumberBeforChange = Integer.valueOf(moneyNumber.getText().toString());
                    ValueAnimator numberAnimation1 = ValueAnimator.ofInt(moneyNumberBeforChange, moneyNumberInt[0]);
                    numberAnimation1.setDuration(500);
                    numberAnimation1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            moneyNumber.setText(valueAnimator.getAnimatedValue().toString());
                        }
                    }); numberAnimation1.start();

                }


            }
        });

        loseMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txtLoseMoneyBoolean[0]) {
                    txtLoseMoney.setText("ذخیره مخارج");
                    radioLoseMoneyFirist.setVisibility(View.VISIBLE);
                    radioLoseMoneySecond.setVisibility(View.VISIBLE);
                    edtLoseMoney.setVisibility(View.VISIBLE);
                    txtLoseMoneyBoolean[0] =false ;

                }else {
                    txtLoseMoney.setText("افزودن مخارج");
                    radioLoseMoneyFirist.setVisibility(View.GONE);
                    radioLoseMoneySecond.setVisibility(View.GONE);
                    edtLoseMoney.setVisibility(View.GONE);
                    txtLoseMoneyBoolean[0]=true;
                    moneyNumberInt[0] -= Integer.valueOf(edtLoseMoney.getText().toString());
                    int moneyNumberBeforChange1 = Integer.valueOf(moneyNumber.getText().toString());
                    ValueAnimator numberAnimation2 = ValueAnimator.ofInt(moneyNumberBeforChange1, moneyNumberInt[0]);
                    numberAnimation2.setDuration(500);
                    numberAnimation2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator1) {
                            moneyNumber.setText(valueAnimator1.getAnimatedValue().toString());
                        }
                    });numberAnimation2.start();

                }



            }
        });



    }

}
