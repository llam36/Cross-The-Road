package com.example.CrossTheRoad;

import java.util.ArrayList;

public class River extends Lane {
    private int laneLength = 8;
    private int posY;

    private String difficulty;

    private int type;
    // types of log 1: longer but slower log, 2: short but faster log


    private ArrayList<Obstacle> logList;
    public River(int posY, String difficulty, int type) {
        this.posY = posY;
        this.difficulty = difficulty;
        this.type = type;
        tiles = new Tile[8];
        for (int i = 0; i < 8; i++) {
            tiles[i] = new Tile("River");
        }

        //setting velocity based on difficulty
        int vModifier;
        if (difficulty.equals("Easy")) {
            vModifier = 300;
        } else if (difficulty.equals("Medium")) {
            vModifier = 0;
        } else {
            vModifier = -300;
        }

        logList = new ArrayList<Obstacle>();
        if (type == 1) {
            logList.add(new Obstacle(1, posY, R.drawable.car, 900 + vModifier, -1));
            logList.add(new Obstacle(3, posY, R.drawable.car, 900 + vModifier, -1));
            logList.add(new Obstacle(6, posY, R.drawable.car, 900 + vModifier, -1));
        } else if (type == 2) {
            logList.add(new Obstacle(0, posY, R.drawable.car, 1200 + vModifier, 1));
            logList.add(new Obstacle(1, posY, R.drawable.car, 1200 + vModifier, 1));
            logList.add(new Obstacle(4, posY, R.drawable.car, 1200 + vModifier, 1));
            logList.add(new Obstacle(5, posY, R.drawable.car, 1200 + vModifier, 1));
        } else {
            logList.add(new Obstacle(1, posY, R.drawable.car, 600 + vModifier, -1));
            logList.add(new Obstacle(4, posY, R.drawable.car, 600 + vModifier, -1));
            logList.add(new Obstacle(7, posY, R.drawable.car, 600 + vModifier, -1));
        }
    }

    @Override
    public String getType() {
        return "River";
    }

    public String getVehicleType() {
        return "null";
    }

    public ArrayList<Obstacle> getLogs() {
        return logList;
    }
}
