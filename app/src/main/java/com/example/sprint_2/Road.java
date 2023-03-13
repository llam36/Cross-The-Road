package com.example.sprint_2;
import java.util.ArrayList;

public class Road extends Lane {
    private int laneLength = 8;
    private int posY;
    ArrayList<Vehicle> vehicle;
    public Road(int posY) {
        this.posY = posY;
        tiles = new Tile[8];
        for (int i = 0; i < 8; i++) {
            tiles[i] = new Tile("Road");
        }

        //Randomize position X for vehicle
        int lowerBound = 1;
        int higherBound = 3;

        int numVehicle = (int) Math.floor(Math.random()
                * (higherBound - lowerBound + 1) + lowerBound);
        vehicle = new ArrayList<Vehicle>();
        if (numVehicle == 1) {
            lowerBound = 0;
            higherBound = 7;
            int posX = (int) Math.floor(Math.random()
                * (higherBound - lowerBound + 1) + lowerBound);
            vehicle.add(new Vehicle(posX, posY, 1, 1000));
        } else if (numVehicle == 2) {
            vehicle.add(new Vehicle(1, posY, 1, 1000));
            vehicle.add(new Vehicle(5, posY, 1, 1000));
        } else if (numVehicle == 3) {
            vehicle.add(new Vehicle(0, posY, 1, 1000));
            vehicle.add(new Vehicle(3, posY, 1, 1000));
            vehicle.add(new Vehicle(6, posY, 1, 1000));
        }
    }
    @Override
    public String getType() {
        return "Road";
    }

    public int[] getVehiclesPos() {
        int[] list = new int[3];
        for(int i = 0; i <= vehicle.size(); i++) {
            Vehicle currentVehicle = vehicle.get(i);
            list[i] = currentVehicle.getPos();
        }
        return list;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicle;
    }
}
