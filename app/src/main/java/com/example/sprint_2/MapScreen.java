package com.example.sprint_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.CountDownTimer;
import android.widget.GridView;

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
                timeLeftInMSec = l;
                adapter.notifyDataSetChanged();
                //gameMap.updatePlayerLocation("up", adapter);
            }


            //TODO: Add logic for game over later
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
}