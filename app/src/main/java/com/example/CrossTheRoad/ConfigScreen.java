package com.example.CrossTheRoad;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ConfigScreen extends AppCompatActivity {

    // Difficulty Level
    private RadioButton radioButtonEasy;
    private RadioButton radioButtonMedium;
    private RadioButton radioButtonHard;


    // Character
    private RadioButton radioButtonCat;
    private RadioButton radioButtonTiger;
    private RadioButton radioButtonWolf;


    // Flow Control
    private Button buttonContinue;

    //variable
    private String name = "";
    private String level = "";
    private int imageOption;

    private Player player = new Player();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen);

        radioButtonEasy = (RadioButton) findViewById(R.id.rButtonEasy);
        radioButtonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = "Easy";
            }
        });

        radioButtonMedium = (RadioButton) findViewById(R.id.rButtonMedium);
        radioButtonMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = "Medium";
            }
        });

        radioButtonHard = (RadioButton) findViewById(R.id.rButtonHard);
        radioButtonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = "Hard";
            }
        });

        radioButtonCat = (RadioButton) findViewById(R.id.rButtonChicken);
        radioButtonCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageOption = R.drawable.chicken;
                System.out.println(R.drawable.chicken);
            }
        });

        radioButtonTiger = (RadioButton) findViewById(R.id.rButtonDuck);
        radioButtonTiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageOption = R.drawable.duck;
                System.out.println(R.drawable.duck);
            }
        });

        radioButtonWolf = (RadioButton) findViewById(R.id.rButtonRabbit);
        radioButtonWolf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageOption = R.drawable.rabbit;
                System.out.println(R.drawable.rabbit);
            }
        });
        Dialog dialog = new Dialog(this);
        buttonContinue = (Button) findViewById(R.id.buttonContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameText  = (EditText) findViewById(R.id.textName);
                name = nameText.getText().toString();
                if (player.isNullName(name) || player.isEmptyStringName(name)
                        || player.isWhiteSpaceOnlyName(name)) {
                    dialog.createDialog("Please answer your name!");
                } else if (level.equals("")) {
                    dialog.createDialog("Please choose your level!");
                } else if (imageOption == 0) {
                    dialog.createDialog("Please choose your image!");
                } else {
                    String message = "You have created a character " + name + " with level "
                            + level + " and image " + imageOption;
                    AlertDialog confirmDialog = dialog.createDialog(message, "Confirmation");
                    confirmDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Okay",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface arg0, int arg1) {
                                    Intent send = new Intent(ConfigScreen.this, GameScreen.class);
                                    player = new Player(level, name, imageOption);
                                    send.putExtra("player", player);
                                    send.putExtra("level", level);
                                    startActivity(send);
                                }
                            });

                    
                }
            }

        });
    }
}