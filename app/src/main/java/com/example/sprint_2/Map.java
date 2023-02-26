package com.example.sprint_2;

import android.content.res.Resources;

public class Map {

    private final Lane[] lanes;
    private int currentPlayerX = 5;
    private int currentPlayerY = 5;
    private String difficulty;

    public Map(String difficulty) {
        lanes = new Lane[10];

        if (difficulty.equals("Easy") || difficulty.equals("Medium")) {
            // range for safe tile
            int lowerBound = 3;
            int higherBound = 7;

            //generate the map =
            int safeTileId = (int) Math.floor(Math.random()
                    * (higherBound - lowerBound + 1) + lowerBound);
            for (int i = 0; i < safeTileId; i++) {
                lanes[i] = new Road();
            }
            lanes[safeTileId] =  new SafeTile();
            for (int i = safeTileId + 1; i < 10; i++) {
                lanes[i] = new River();
            }
        } else {
            // range for safe tile
            int lowerBound1 = 2;
            int higherBound1 = 4;

            int lowerBound2 = 6;
            int higherBound2 = 8;

            //generate the map =
            int safeTileId1 = (int) Math.floor(Math.random()
                    * (higherBound1 - lowerBound1 + 1) + lowerBound1);
            int safeTileId2 = (int) Math.floor(Math.random()
                    * (higherBound2 - lowerBound2 + 1) + lowerBound2);
            for (int i = 0; i < safeTileId1; i++) {
                lanes[i] = new Road();
            }
            lanes[safeTileId1] =  new SafeTile();
            for (int i = safeTileId1 + 1; i < safeTileId2; i++) {
                lanes[i] = new River();
            }
            lanes[safeTileId2] =  new SafeTile();
            for (int i = safeTileId2 + 1; i < 10; i++) {
                lanes[i] = new Road();
            }
        }
    }
    public void updatePlayerLocation(String s) {
        System.out.println("The input direction: " + s);
        int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        if (currentPlayerX < screenWidth && currentPlayerX > 0) {
            if (s.equals("left")) {
                currentPlayerX -= 1;
                System.out.println(currentPlayerX);
            } else if (s.equals("right")) {
                currentPlayerX += 1;
            }
        }
        if (currentPlayerY < screenHeight && currentPlayerY > 0) {
            if (s.equals("up")) {
                currentPlayerY += 1;
            } else if (s.equals("down")) {
                currentPlayerY -= 1;
            }
        }
    }

    public int getCurrentPlayerX() {
        return currentPlayerX;
    }

    public int getCurrentPlayerY() {
        return currentPlayerY;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getInfo(int x, int y) {
        return lanes[y].getTile(x).getInfo();
    }

    public Lane[] getLanes() {
        return lanes;
    }

    public void setLanes(int i, Lane data) {
        lanes[i] = data;
    }
}
