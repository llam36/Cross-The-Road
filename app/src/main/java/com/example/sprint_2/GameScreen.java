package com.example.sprint_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameScreen extends AppCompatActivity {
    private Bundle playerInfo;
    private String name;
    private String level;
    private String imageOption;
    private TextView playerName;
    private TextView lives;
    private TextView points;
    private TextView difficulty;
    private ImageView sprite;
    private Button playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        playerInfo = getIntent().getExtras();
        name = playerInfo.getString("name");
        level = playerInfo.getString("level");
        imageOption = playerInfo.getString("image");


        playerName = (TextView) findViewById(R.id.playerName);
        playerName.setText(name);

        lives = (TextView) findViewById(R.id.startingLives);
        switch (level) {
        case "Easy":
            lives.setText("Lives: 10");
            break;
        case "Medium":
            lives.setText("Lives: 8");
            break;
        case "Hard":
            lives.setText("Lives: 6");
            break;
        default:
            break;
        }

        points = (TextView) findViewById(R.id.startingPoint);
        points.setText("Points: 0");

        difficulty = (TextView) findViewById(R.id.Difficulty);
        difficulty.setText(level);

        sprite = (ImageView) findViewById(R.id.sprite);
        switch (imageOption) {
        case "Chicken":
            sprite.setImageResource(R.drawable.chicken);
            break;
        case "Duck":
            sprite.setImageResource(R.drawable.duck);
            break;
        case "Rabbit":
            sprite.setImageResource(R.drawable.rabbit);
            break;
        default:
            break;
        }

        playBtn = (Button) findViewById(R.id.playButton);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame();
            }
        });
    }
    public void playGame() {
        Intent intent = new Intent(this, MapScreen.class);
        startActivity(intent);
    }
}