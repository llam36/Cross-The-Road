package com.example.sprint_2;

public class River extends Lane {
    public River() {
        tiles = new Tile[10];
        for (int i = 0; i < 10; i++) {
            tiles[i] = new Tile("River");
        }
    }
    @Override
    public String getType() {
        return "river";
    }
}
