package com.example.sprint_2;

public class River extends Lane {
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
}
