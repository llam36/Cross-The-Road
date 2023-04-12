package com.example.sprint_2;

import java.util.ArrayList;

public class River extends Lane {
    private int laneLength = 8;
    private int posY;

    private String difficulty;

    private int type;
    // types of log 1: longer but slower log, 2: short but faster log


    private ArrayList<Log> logList;
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

        logList = new ArrayList<Log>();
        if (type == 1) {
            logList.add(new Log(1, posY, R.drawable.car, 900 + vModifier, -1));
            logList.add(new Log(3, posY, R.drawable.car, 900 + vModifier, -1));
            logList.add(new Log(6, posY, R.drawable.car, 900 + vModifier, -1));
        } else if (type == 2){
            logList.add(new Log(0, posY, R.drawable.car, 1200 + vModifier, 1));
            logList.add(new Log(1, posY, R.drawable.car, 1200 + vModifier, 1));
            logList.add(new Log(4, posY, R.drawable.car, 1200 + vModifier, 1));
            logList.add(new Log(5, posY, R.drawable.car, 1200 + vModifier, 1));
        } else {
            logList.add(new Log(1, posY, R.drawable.car, 600 + vModifier, -1));
            logList.add(new Log(4, posY, R.drawable.car, 600 + vModifier, -1));
            logList.add(new Log(7, posY, R.drawable.car, 600 + vModifier, -1));
        }
    }

    @Override
    public String getType() {
        return "River";
    }

    public String getVehicleType() {
        return "null";
    }

    public ArrayList<Log> getLogs() {
        return logList;
    }
}
