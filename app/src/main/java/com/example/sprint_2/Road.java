package com.example.sprint_2;

public class Road extends Lane {
    public Road() {
        tiles = new Tile[8];
        for (int i = 0; i < 8; i++) {
            tiles[i] = new Tile("Road");
        }
    }
    @Override
    public String getType() {
        return "Road";
    }
}
