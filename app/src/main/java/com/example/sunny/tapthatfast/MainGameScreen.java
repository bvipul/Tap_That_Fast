package com.example.sunny.tapthatfast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by admin on 04-02-2016.
 */
public class MainGameScreen extends Activity {
    protected int i=0,j=0,a,b;
    public Button blueButton,redButton;
    final int numberOfTap=20;
    protected TextView blueTextView,redTextView;
    String sunny,vipul;
    Intent fromGameMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_game_screen);
        blueButton = (Button) findViewById(R.id.blueButton);
        redButton = (Button) findViewById(R.id.redButton);
        a=3;
        b=40;
        blueTextView = (TextView) findViewById(R.id.blueTextView);
        redTextView = (TextView) findViewById(R.id.redTextView);
        Intent fromGame = getIntent();
        sunny = fromGame.getExtras().getString("uone");
        vipul = fromGame.getExtras().getString("utwo");
        blueTextView.setText(vipul.toUpperCase());
        redTextView.setText(sunny.toUpperCase());

        /*TimerTask countdownTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(a==1)
                        {
                        }
                        blueButton.setText(String.valueOf(a));
                        blueButton.setTextSize(b);
                        redButton.setText(String.valueOf(a));
                        redButton.setTextSize(b);
                        a--;
                        b+=20;
                    }
                });
            }
        };


        Timer countdown = new Timer();
        countdown.schedule(countdownTask, 0, 1000);*/
        /*Thread timer = new Thread(){
            public void run(){
                for(int z=0;z<3;z++)
                {
                    try{
                        sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally{
                        blueButton.setText(String.valueOf(a));
                        blueButton.setTextSize(b);
                        redButton.setText(String.valueOf(a));
                        redButton.setTextSize(b);
                        a--;
                        b+=20;
                    }
                }

            }
        };
        timer.start();*/
        countdownTimer();


    }
    public void countdownTimer()
    {
        new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {
                if((millisUntilFinished/1000)<=3) {
                    blueButton.setEnabled(false);
                    redButton.setEnabled(false);
                    blueButton.setText(String.valueOf(millisUntilFinished / 1000));
                    blueButton.setTextSize(b);
                    redButton.setText(String.valueOf(millisUntilFinished / 1000));
                    redButton.setTextSize(b);
                    a--;
                    b+=20;
                }

                //here you can have your logic to set text to edittext

            }

            @Override
            public void onFinish() {
                blueButton.setText("GO");
                redButton.setText("GO");
                blueButton.setEnabled(true);
                redButton.setEnabled(true);
            }

        }.start();
    }

    public void onClickBlueButton(View view) {
        i++;
        if(i==1)
        {
            redTextView.setText(sunny.toUpperCase());
            blueTextView.setText(vipul.toUpperCase());
        }
        blueButton.setText(String.valueOf(i));
        if(i==numberOfTap)
        {
            blueButton.setText("WIN("+i+")");
            blueButton.setTextSize(40);
            redButton.setText("LOSE(" + j + ")");
            redButton.setTextSize(40);
            blueButton.setEnabled(false);
            redButton.setEnabled(false);
        }

    }

    public void onClickRedButton(View view) {
        j++;
        redButton.setText(String.valueOf(j));
        if(j==numberOfTap)
        {
            blueButton.setText("LOSE("+i+")");
            blueButton.setTextSize(40);
            redButton.setText("WIN("+j+")");
            redButton.setTextSize(40);
            blueButton.setEnabled(false);
            redButton.setEnabled(false);
        }
    }

    public void resetFunction(View view) {
        countdownTimer();
        blueButton.setText(vipul);
        redButton.setText(sunny);
        //redButton.setText("0");
        //blueButton.setText("0");
        i=j=0;
        a=3;b=40;
        blueButton.setEnabled(true);
        redButton.setEnabled(true);
    }
}
