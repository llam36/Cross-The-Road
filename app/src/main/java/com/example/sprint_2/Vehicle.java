package com.example.sprint_2;
import java.sql.Timestamp;

public class Vehicle {

    private final int gridHeight = 8;
    private final int laneLength = 8;
    private int imageId;
    private int posX;
    private int posY;
    private long createTime;

    private int direction;

    //calculated the time taken to travel one block (milliseconds)
    private int velocity;

    public Vehicle(int posX, int posY, int imageId, int velocity, int direction) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.posX = posX;
        this.posY = posY;
        this.imageId = imageId;
        this.velocity = velocity;
        this.createTime = timestamp.getTime();
        this.direction = direction;
    }

    public int getPos() {
        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        long currentTime = currentTimeStamp.getTime();

        long delta = currentTime - createTime;
        int travelDistance = (int) delta / velocity;

        if (direction == 1) {
            return gridHeight * posY + (posX + travelDistance) % laneLength;
        } else {
            return gridHeight * posY + (posX + 8 - travelDistance % laneLength) % laneLength;
        }

    }

    public int getImageId() {
        return imageId;
    }

}
