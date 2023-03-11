package com.example.sprint_2;

import java.io.Serializable;

public class Player implements Serializable {
    private int lives;
    private String name;
    private int imageOption;
    private int currentPlayerX;
    private int currentPlayerY;

    public Player() {
        this("Easy", "Player", 1);
    }


    public Player(String level, String name, int imageOption) {
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
        this.currentPlayerX = 4;
        this.currentPlayerY = 9;
    }

    public void updatePlayerLocation(String s) {
        if (s.equals("left") && currentPlayerX > 0) {
            currentPlayerX -= 1;
        } else if (s.equals("right") && currentPlayerX < 7) {
            currentPlayerX += 1;
        } else if (s.equals("up") && currentPlayerY > 0) {
            currentPlayerY -= 1;
        } else if (s.equals("down") && currentPlayerY < 9) {
            currentPlayerY += 1;
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

    public int getCurrentPlayerX() {
        return currentPlayerX;
    }

    public void setCurrentPlayerX(int currentPlayerX) {
        this.currentPlayerX = currentPlayerX;
    }

    public int getCurrentPlayerY() {
        return currentPlayerY;
    }

    public void setCurrentPlayerY(int currentPlayerY) {
        this.currentPlayerY = currentPlayerY;
    }

    public int getCurrentPlayerPosition() {
        return 8 * currentPlayerY + currentPlayerX;
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
    
}
