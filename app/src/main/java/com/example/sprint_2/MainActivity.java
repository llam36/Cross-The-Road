package com.example.sprint_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridView gvLanesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvLanesMap = findViewById(R.id.idGVLanesMap);

        Map gameMap = new Map("Hard");
        Lane[] lanes = new Lane[80];
        for (int i = 0; i < gameMap.lanes.length; i++) {
            for (int j = 0; j < 8; j++) {
                lanes[8 * i + j] = gameMap.lanes[i];
            }
        }
        MapDisplayAdapter adapter = new MapDisplayAdapter(this, lanes);
        
        gvLanesMap.setAdapter(adapter);
    }
}