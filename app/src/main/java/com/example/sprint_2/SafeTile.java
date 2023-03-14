package com.example.sprint_2;

public class SafeTile extends Lane {
    public SafeTile() {
        tiles = new Tile[8];
        for (int i = 0; i < 8; i++) {
            tiles[i] = new Tile("SafeTile");
        }
    }
    @Override
    public String getType() {
        return "SafeTile";
    }
    public String getVehicleType() {
        return "null";
    }
}
