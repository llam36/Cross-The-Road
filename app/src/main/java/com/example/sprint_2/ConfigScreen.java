package com.example.sprint_2;

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

<<<<<<< HEAD
    public static boolean isEmptyStringName(String name) {
        return name.equals("");
    }

    public static boolean isWhiteSpaceOnlyName(String name) {
        return name.trim().equals("");
    }

    public static boolean isNullName(String name) {
        return name == null;
    }
=======
    private Player player;

>>>>>>> Thanh
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
            }
        });

        radioButtonTiger = (RadioButton) findViewById(R.id.rButtonDuck);
        radioButtonTiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageOption = R.drawable.duck;
            }
        });

        radioButtonWolf = (RadioButton) findViewById(R.id.rButtonRabbit);
        radioButtonWolf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageOption = R.drawable.rabbit;
            }
        });


        //alert for name alert
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setNeutralButton("Okay", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                return;
            }
        });
        alertBuilder.setTitle("ERROR");
        alertBuilder.setCancelable(true);

        buttonContinue = (Button) findViewById(R.id.buttonContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameText  = (EditText) findViewById(R.id.textName);
                name = nameText.getText().toString();
                if (isNullName(name) || isEmptyStringName(name) || isWhiteSpaceOnlyName(name)) {
                    AlertDialog nameDialog = alertBuilder.create();
                    nameDialog.setMessage("Please answer your name!");
                    nameDialog.show();
                } else if (level.equals("")) {
                    AlertDialog levelDialog = alertBuilder.create();
                    levelDialog.setMessage("Please choose your level!");
                    levelDialog.show();
                } else if (imageOption == 0) {
                    AlertDialog imageDialog = alertBuilder.create();
                    imageDialog.setMessage("Please choose your image!");
                    imageDialog.show();
                } else {
                    AlertDialog confirmDialog = alertBuilder.create();
                    confirmDialog.setMessage("You have created a character " + name + " with level "
                            + level + " and image " + imageOption);
                    confirmDialog.setTitle("Confirmation");
                    confirmDialog.show();
                    
<<<<<<< HEAD
                    confirmDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Okay",
                            new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent send = new Intent(ConfigScreen.this, GameScreen.class);
                                send.putExtra("name", name);
                                send.putExtra("level", level);
                                send.putExtra("image", imageOption);
                                startActivity(send);
                            }
                        });
=======
                    confirmDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Okay", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Intent send = new Intent(ConfigScreen.this, GameScreen.class);
                            player = new Player(level, name, imageOption);
                            send.putExtra("player", player);
                            startActivity(send);
                        }
                    });
>>>>>>> Thanh
                    
                }
            }

        });
    }
}