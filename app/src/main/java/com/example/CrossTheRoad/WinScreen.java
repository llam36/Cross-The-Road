package com.example.CrossTheRoad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WinScreen extends AppCompatActivity {
    private Button exitButton;
    private Button restartButton;

    private TextView totalScoreLabel;
    private TextView message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_screen);
        exitButton = (Button) findViewById(R.id.exitTwo);
        restartButton = (Button) findViewById(R.id.restartTwo);
        message = (TextView) findViewById(R.id.winText);
        message.setText("    congrats you won!!");
        totalScoreLabel = (TextView) findViewById(R.id.totalScoreLabel);
        int totalScore = getIntent().getIntExtra("score", 0);
        totalScoreLabel.setText(String.format("Score: " + totalScore));
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send = new Intent(WinScreen.this, ConfigScreen.class);
                startActivity(send);
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);
            }
        });

    }
}

