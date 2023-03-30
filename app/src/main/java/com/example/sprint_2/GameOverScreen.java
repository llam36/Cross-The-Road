package com.example.sprint_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOverScreen extends AppCompatActivity {
    private Button exitButton;
    private Button restartButton;

    private TextView totalScoreLabel;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover_screen);
        exitButton = (Button) findViewById(R.id.exit);
        restartButton = (Button) findViewById(R.id.restart);
        totalScoreLabel = (TextView) findViewById(R.id.totalScoreLabel);
        String score = String.valueOf(player.getScore());
        totalScoreLabel.setText(score);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send = new Intent(GameOverScreen.this, ConfigScreen.class);
                startActivity(send);
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }
}