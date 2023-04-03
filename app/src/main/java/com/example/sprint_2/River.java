package com.example.sprint_2;

import java.util.ArrayList;

public class River extends Lane {

    private ArrayList<Log> log;
    public River() {
        tiles = new Tile[8];
        for (int i = 0; i < 8; i++) {
            tiles[i] = new Tile("River");
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
        return log;
    }
}
