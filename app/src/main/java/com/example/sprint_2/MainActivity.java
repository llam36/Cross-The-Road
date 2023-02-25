package com.example.sprint_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView GVLanesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GVLanesMap = findViewById(R.id.idGVLanesMap);

        Map gameMap = new Map();
        Road road = new Road();
        River river = new River();
        SafeTile safeTile = new SafeTile();
        GoalTile goalTile = new GoalTile();
        gameMap.lanes = new Lane[] {goalTile, road, road, safeTile, river, river, river, safeTile, road, safeTile};
        MapDisplayAdapter adapter = new MapDisplayAdapter(this, gameMap.lanes);
        
        GVLanesMap.setAdapter(adapter);
    }
}