package com.example.CrossTheRoad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.CountDownTimer;
import android.widget.GridView;
import android.widget.TextView;

public class MapScreen extends AppCompatActivity {
    private String name;
    private String level;
    private int imageOption;

    private Player player;
    private CountDownTimer countDownTimer;
    private long timeLeftInMSec = 9000000;

    private Map gameMap;
    private MapDisplayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_screen);

        GridView gvLanesMap = findViewById(R.id.idGVLanesMap);

        player = (Player) getIntent().getSerializableExtra("player");
        imageOption = player.getImageOption();
        level = getIntent().getStringExtra("level");

        gameMap = new Map(level, player);

        Tile[] mapAdapterArray = createMapAdapterArray(gameMap);

        adapter = new MapDisplayAdapter(this, mapAdapterArray, gameMap, imageOption);
        SwipeListener swipeDetection = new SwipeListener(gvLanesMap, gameMap, adapter);

        gvLanesMap.setAdapter(adapter);
        startTimer();
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMSec, 200) {
            @Override
            public void onTick(long l) {
                System.out.println(gameMap.needsUpdate());
                if (gameMap.needsUpdate()) {
                    timeLeftInMSec = l;
                    adapter.notifyDataSetChanged();
                    if (player.getLives() == 0) { //check player current lives
                        cancel();
                        endGame();
                    }
                    if (player.getPosY() == 0) {
                        cancel();
                        player.winGame();
                        System.out.println("Total score is: " + player.getTotalScore());
                        winGame();
                    }
                    TextView score = findViewById(R.id.score);
                    score.setText(String.format("Score: %d", gameMap.getPlayer().getScore()));
                    TextView lives = findViewById(R.id.lives);
                    lives.setText(String.format("Lives: %d", gameMap.getPlayer().getLives()));
                    TextView totalScore = findViewById(R.id.totalScore);
                    totalScore.setText(String.format("Total: %d",
                            gameMap.getPlayer().getTotalScore()));
                }
            }
            @Override
            public void onFinish() {
                System.out.println("Game over");
            }
        }.start();
    }

    // convert from a 2d array from class Map to 1d array for class MapDisplayAdapter
    public Tile[] createMapAdapterArray(Map gameMap) {
        Tile[] tiles = new Tile[80];
        for (int i = 0; i < gameMap.getLanes().length; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[8 * i + j] = gameMap.getLanes()[i].getTile(j);
            }
        }
        return tiles;
    }

    //when game over, go to GameOverScreen with player score.
    public void endGame() {
        Intent intent = new Intent(this, GameOverScreen.class);
        intent.putExtra("score", player.getTotalScore());
        startActivity(intent);
    }
    public void winGame() {
        Intent intent = new Intent(this, WinScreen.class);
        intent.putExtra("score", player.getTotalScore());
        startActivity(intent);
    }
}