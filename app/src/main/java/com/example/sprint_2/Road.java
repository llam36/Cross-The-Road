package com.example.sprint_2;

public class Road extends Lane{
    public Tile[] tiles;

    public Road() {
        tiles = new Tile[10];
        for (int i=0; i<10; i++) {
            tiles[i] = new Tile("Road");
        }
    }
    @Override
    public String getType() {
        return "road";
    }
}
