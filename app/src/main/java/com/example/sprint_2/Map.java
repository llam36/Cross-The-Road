package com.example.sprint_2;

public class Map {

    public Lane[] lanes;
    public int currentPlayerX;
    public int currentPlayerY;
    public String difficulty;

    //TODO: @paranit
    public void updatePlayerLocation(String s) {

    }

    public Map(String difficulty) {
        lanes = new Lane[10];

        if (difficulty.equals("Easy") || difficulty.equals("Medium")) {
            // range for safe tile
            int lowerBound = 3;
            int higherBound = 7;

            //generate the map =
            int safeTileId = (int)Math.floor(Math.random() * (higherBound - lowerBound + 1) + lowerBound);
            for (int i = 0; i < safeTileId; i++) {
                lanes[i] = new Road();
            }
            lanes[safeTileId] =  new SafeTile();
            for (int i=safeTileId; i < 10; i++) {
                lanes[i] = new River();
            }
        } else {
            // range for safe tile
            int lowerBound1=2;
            int higherBound1=4;

            int lowerBound2 = 6;
            int higherBound2 = 8;

            //generate the map =
            int safeTileId1 = (int)Math.floor(Math.random() * (higherBound1 - lowerBound1 + 1) + lowerBound1);
            int safeTileId2 = (int)Math.floor(Math.random() * (higherBound2 - lowerBound2 + 1) + lowerBound2);
            for (int i = 0; i < safeTileId1; i++) {
                lanes[i] = new Road();
            }
            lanes[safeTileId1] =  new SafeTile();
            for (int i=safeTileId1; i < safeTileId2; i++) {
                lanes[i] = new River();
            }
            lanes[safeTileId2] =  new SafeTile();
            for (int i = safeTileId2; i < 10; i++) {
                lanes[i] = new Road();
            }
        }
    }

    public String getInfo(int x, int y) {
        return lanes[y].getTile(x).getInfo();
    }

}
