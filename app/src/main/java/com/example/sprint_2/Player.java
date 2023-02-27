package com.example.sprint_2;

import java.io.Serializable;

public class Player implements Serializable {
    private String level;
    private int lives;
    private String name;
    private int imageOption;

    public Player() {
        this.level = "";
        this.lives = 0;
        this.name = "";
        this.imageOption = 0;
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
        this.level = level;
        this.name = name;
        this.imageOption = imageOption;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
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

    public int getNumLife() {
        return lives;
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
