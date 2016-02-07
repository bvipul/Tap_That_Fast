package com.example.sunny.tapthatfast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by admin on 03-02-2016.
 */
public class MainGame extends Activity {

    public Intent mainGame;
    public EditText uone,utwo;
    String one,two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game_layout);
        uone = (EditText) findViewById(R.id.user_name_1_edit_text);
        utwo =(EditText) findViewById(R.id.user_name_2_edit_text);


    }

    public void gameScreen(View view) {
        one = String.valueOf(uone.getText());
        two = String.valueOf(utwo.getText());
        mainGame = new Intent(this,MainGameScreen.class);
        mainGame.putExtra("uone",one);
        mainGame.putExtra("utwo",two);
        startActivity(mainGame);

    }
}
