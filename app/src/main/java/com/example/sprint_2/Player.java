package com.example.sprint_2;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private int score = 0;
    private ArrayList<Integer> previousLocation;
    private final int gridHeight = 8;
    private int lives;
    private String name;
    private int imageOption;
    private int posX;
    private int posY;

    public Player() {
        this("Easy", "Player", 1);
        previousLocation = new ArrayList<Integer>();

    }


    public Player(String level, String name, int imageOption) {
        previousLocation = new ArrayList<Integer>();
        switch (level) {
        case "Easy":
            this.lives = 10;
            break;
        case "Medium":
            this.lives = 8;
            break;
        case "Hard":
            this.lives = 6;
            break;
        default:
            break;
        }
        this.name = name;
        this.imageOption = imageOption;
        this.posX = 4;
        this.posY = 9;
    }

    public void updatePlayerLocation(String s) {
        if (s.equals("left") && posX > 0) {
            posX -= 1;
        } else if (s.equals("right") && posX < 7) {
            posX += 1;
        } else if (s.equals("up") && posY > 0) {
            posY -= 1;
        } else if (s.equals("down") && posY < 9) {
            posY += 1;
        }
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageOption() {
        return imageOption;
    }

    public void setImageOption(int imageOption) {
        this.imageOption = imageOption;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int currentPlayerX) {
        this.posX = currentPlayerX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPos() {
        return gridHeight * posY + posX;
    }


    public boolean isEmptyStringName(String name) {
        return name.equals("");
    }

    public boolean isWhiteSpaceOnlyName(String name) {
        return name.trim().equals("");
    }

    public boolean isNullName(String name) {
        return name == null;
    }
    public void updateScore(Map map, String s) {
        boolean firstTime = true;

        for (int i = 0; i < previousLocation.size(); i++) {
            if (previousLocation.get(i).equals(map.getPlayer().getPosY())) {
                firstTime = false;
            }
        }
        if (s.equals("up") && firstTime) {
            previousLocation.add(map.getPlayer().getPosY());
            if (map.getLanes()[map.getPlayer().getPosY()].getVehicleType().equals("car")) {
                score += 2;
            } else if (map.getLanes()
                    [map.getPlayer().getPosY()].getVehicleType().equals("truck")) {
                score += 3;
            } else if (map.getLanes()
                    [map.getPlayer().getPosY()].getVehicleType().equals("motocycle")) {
                score += 4;
            } else {
                score++;
            }
            System.out.println(score);
        }
        //Log.d("myTag", String.valueOf(score)+ " "+String.valueOf(previousLocation.size()));
    }
    public int getScore() {
        return score;
    }
}
