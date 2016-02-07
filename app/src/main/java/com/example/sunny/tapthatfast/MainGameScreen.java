package com.example.sunny.tapthatfast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        blueButton.setText(vipul);
        redButton.setText(sunny);
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
            blueButton.setEnabled(false);
            redButton.setEnabled(false);
            Toast.makeText(getApplicationContext(),vipul.toUpperCase()+" WINS",Toast.LENGTH_LONG).show();
            blueTextView.setText("YOU WiN");
            redTextView.setText("YOU LOSE");
        }

    }

    public void onClickRedButton(View view) {
        j++;
        redButton.setText(String.valueOf(j));
        if(j==numberOfTap)
        {
            blueButton.setEnabled(false);
            redButton.setEnabled(false);
            Toast.makeText(getApplicationContext(),sunny.toUpperCase()+" WINS",Toast.LENGTH_LONG).show();
            blueTextView.setText("YOU LOSE");
            redTextView.setText("YOU WIN");
        }
    }

    public void resetFunction(View view) {
        redTextView.setText("RED_SIDE");
        blueTextView.setText("BLUE_SIDE");
        blueButton.setText(vipul);
        redButton.setText(sunny);
        //redButton.setText("0");
        //blueButton.setText("0");
        i=j=0;
        blueButton.setEnabled(true);
        redButton.setEnabled(true);
    }
}
