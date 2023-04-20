package com.example.CrossTheRoad;

public abstract class Lane {
    protected Tile[] tiles;

    public Tile getTile(int x) {
        return tiles[x];
    }

    public abstract String getType();

    public abstract String getVehicleType();

}

