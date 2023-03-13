package com.example.sprint_2;
import java.sql.Timestamp;

public class Vehicle {

    private final int gridHeight = 8;
    private final int laneLength = 8;
    private int imageId;
    private int posX;
    private int posY;
    private long createTime;

    //calculated the time taken to travel one block (milliseconds)
    private int velocity;

    public Vehicle(int posX, int posY, int imageId, int velocity) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.posX = posX;
        this.posY = posY;
        this.imageId = imageId;
        this.velocity = velocity;
        this.createTime = timestamp.getTime();


    }

    public int getPos() {
        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        long currentTime = currentTimeStamp.getTime();

        long delta = currentTime - createTime;
        int travelDistance = (int) delta/velocity;

        return gridHeight * posY + (posX+travelDistance)%laneLength;
    }

}
