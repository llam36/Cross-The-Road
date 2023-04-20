package com.example.CrossTheRoad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameScreen extends AppCompatActivity {
    private String name;
    private String level;
    private Player player;
    private int imageOption;
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
        player = (Player) getIntent().getSerializableExtra("player");
        name = player.getName();
        level = getIntent().getStringExtra("level");
        imageOption = player.getImageOption();


        playerName = (TextView) findViewById(R.id.playerName);
        playerName.setText(name);

        lives = (TextView) findViewById(R.id.startingLives);
        lives.setText("Lives: " + player.getLives());


        points = (TextView) findViewById(R.id.startingPoint);
        points.setText("Points: 0");

        difficulty = (TextView) findViewById(R.id.Difficulty);
        difficulty.setText(level);

        sprite = (ImageView) findViewById(R.id.sprite);
        sprite.setImageResource(imageOption);

        playBtn = (Button) findViewById(R.id.playButton);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame();
            }
        });
    }
    public void playGame() {
        Intent send = new Intent(this, MapScreen.class);
        send.putExtra("player", player);
        send.putExtra("level", level);
        startActivity(send);
    }
}