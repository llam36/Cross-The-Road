package com.example.sprint_2;

public class River extends Lane{
    public Tile[] tiles;

    public River() {
        tiles = new Tile[10];
        for (int i=0; i<10; i++) {
            tiles[i] = new Tile("River");
        }
    }
}
