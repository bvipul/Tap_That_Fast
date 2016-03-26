package com.example.sunny.tapthatfast;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainGameScreen extends Activity {
    protected int i=0,j=0,a,b;
    public Button blueButton,redButton;
    final int numberOfTap=20;
    protected TextView blueTextView,redTextView;
    String sunny,vipul;
    Intent fromGameMenu;
    protected Intent winnerOfGame;
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
    public void dialogForWinner(String winner,String colr)
    {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_winner);
        TextView win = (TextView) dialog.findViewById(R.id.winnerPlaceHolder);
        win.setText(winner);
        dialog.show();

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
            dialogForWinner(vipul, "RED");
            blueButton.setText("WIN(" + i + ")");
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
            dialogForWinner(sunny,"BLUE");
            blueButton.setText("LOSE(" + i + ")");
            blueButton.setTextSize(40);
            redButton.setText("WIN(" + j + ")");
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
