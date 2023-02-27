package com.example.sprint_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.GridView;

public class MapScreen extends AppCompatActivity {
    private String name;
    private String level;
    private int imageOption;

    private Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_screen);

        GridView gvLanesMap = findViewById(R.id.idGVLanesMap);

        player = (Player) getIntent().getSerializableExtra("player");
        imageOption = player.getImageOption();
        level = player.getLevel();

        Map gameMap = new Map(level);

        Tile[] mapAdapterArray = createMapAdapterArray(gameMap);

        MapDisplayAdapter adapter = new MapDisplayAdapter(this, mapAdapterArray, gameMap, imageOption);
        SwipeListener swipeDetection = new SwipeListener(gvLanesMap, gameMap, adapter);

        gvLanesMap.setAdapter(adapter);

    }
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