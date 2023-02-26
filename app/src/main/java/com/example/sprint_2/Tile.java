package com.example.sprint_2;

public class Tile {
    private boolean isPlayerHere;
    private String type;

    public Tile(String type) {
        this.type = type;
    }

    public String getInfo() {
        if (isPlayerHere) {
            return "Player";
        } else {
            return type;
        }
    }

    public boolean isPlayerHere() {
        return isPlayerHere;
    }

    public void setPlayerHere(boolean playerHere) {
        isPlayerHere = playerHere;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
