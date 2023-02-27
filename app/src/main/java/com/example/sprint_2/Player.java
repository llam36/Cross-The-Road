package com.example.sprint_2;

public class Player {
    private int lives;
    private String name;
    private int pathToImage;
    public Player(String level, String name, int pathToImage) {
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
        this.pathToImage = pathToImage;
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

    public int getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(int pathToImage) {
        this.pathToImage = pathToImage;
    }
}
