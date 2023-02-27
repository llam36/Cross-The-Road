package com.example.sprint_2;

public class GoalTile extends Lane {
    @Override
    public String getType() {
        return "GoalTile";
    }

    public GoalTile() {
        tiles = new Tile[8];
        for (int i = 0; i < 8; i++) {
            tiles[i] = new Tile("GoalTile");
        }
    }
}
