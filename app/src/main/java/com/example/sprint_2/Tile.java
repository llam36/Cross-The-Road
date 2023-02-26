package com.example.sprint_2;

public class Tile {
    public boolean isPlayerHere;
    public String type;

    public Tile(String type) {
        this.type = type;
    }

    public String getInfo() {
        if(isPlayerHere) {
            return "Player";
        } else {
            return type;
        }
    }
}
