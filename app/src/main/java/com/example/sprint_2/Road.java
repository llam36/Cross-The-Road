package com.example.sprint_2;
import java.util.ArrayList;

public class Road extends Lane {
    private int laneLength = 8;
    private int posY;
    private String difficulty;

    private int vehicleType;

    //1: bike; 2:car; 3:truck

    private ArrayList<Obstacle> obstacleList;
    public Road(int posY, String difficulty, int vehicleType) {
        this.vehicleType = vehicleType;
        this.difficulty = difficulty;
        this.posY = posY;
        tiles = new Tile[8];
        for (int i = 0; i < 8; i++) {
            tiles[i] = new Tile("Road");
        }

        //setting velocity based on difficulty
        int vModifier;
        if (difficulty.equals("Easy")) {
            vModifier = 300;
        } else if (difficulty.equals("Medium")) {
            vModifier = 0;
        } else {
            vModifier = -300;
        }

        obstacleList = new ArrayList<Obstacle>();

        if (vehicleType == 1) {
            obstacleList.add(new Obstacle(0, posY, R.drawable.car, 1000 + vModifier, 1));
            obstacleList.add(new Obstacle(5, posY, R.drawable.car, 1000 + vModifier, 1));
        } else if (vehicleType == 2) {
            obstacleList.add(new Obstacle(0, posY, R.drawable.truck_head,
                    1500 + vModifier, -1));
            obstacleList.add(new Obstacle(1, posY, R.drawable.truck_tail, 1500 + vModifier, -1));

            obstacleList.add(new Obstacle(4, posY, R.drawable.truck_head, 1500 + vModifier, -1));
            obstacleList.add(new Obstacle(5, posY, R.drawable.truck_tail, 1500 + vModifier, -1));

        } else if (vehicleType == 3) {
            obstacleList.add(new Obstacle(0, posY, R.drawable.moto, 500 + vModifier, -1));
            obstacleList.add(new Obstacle(2, posY, R.drawable.moto, 500 + vModifier, -1));
            obstacleList.add(new Obstacle(6, posY, R.drawable.moto, 500 + vModifier, -1));
        }
    }
    @Override
    public String getType() {
        return "Road";
    }

    public int[] getVehiclesPos() {
        int[] list = new int[3];
        for (int i = 0; i <= obstacleList.size(); i++) {
            Obstacle currentObstacle = obstacleList.get(i);
            list[i] = currentObstacle.getPos();
        }
        return list;
    }

    public ArrayList<Obstacle> getVehicles() {
        return obstacleList;
    }

    public String getVehicleType() {
        if (vehicleType == 1) {
            return "car";
        } else if (vehicleType == 2) {
            return "truck";
        } else {
            return "motorcycle";
        }
    }
}
