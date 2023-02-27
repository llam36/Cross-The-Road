package com.example.sprint_2;

import java.io.Serializable;

public class Player implements Serializable {
    private String level;
    private int lives;
    private String name;
    private int imageOption;
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
        this.level = level;
        this.name = name;
        this.imageOption = imageOption;
    }

    public String getLevel() {
        return level;
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

    public void imageOption(int imageOption) {
        this.imageOption = imageOption;
    }

    public int getNumLife() {
        return lives;
    }

}
