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
        gameMap.lanes = new Lane[] {road, road, road, river, river, road, road, road, river, road};
        MapDisplayAdapter adapter = new MapDisplayAdapter(this, gameMap.lanes);
        
        GVLanesMap.setAdapter(adapter);
    }
}