package com.example.sprint_2;

public class Road extends Lane {
    private int posY;
    Vehicle[] vehicle;
    public Road(int posY) {
        this.posY = posY;
        tiles = new Tile[8];
        for (int i = 0; i < 8; i++) {
            tiles[i] = new Tile("Road");
        }

        //Randomize position X for vehicle


        vehicle = new Vehicle()




    }
    @Override
    public String getType() {
        return "Road";
    }
}
