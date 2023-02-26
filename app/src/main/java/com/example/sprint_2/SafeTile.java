package com.example.sprint_2;

public class SafeTile extends Lane {
    public Tile[] tiles;

    public SafeTile() {
        tiles = new Tile[10];
        for (int i=0; i<10; i++) {
            tiles[i] = new Tile("SafeTile");
        }
    }
    @Override
    public String getType() {
        return "safe tile";
    }
}
