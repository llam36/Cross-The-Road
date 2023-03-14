package com.example.sprint_2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ThanhJunit {

    private Player player;
    private String difficulty;
    private Map map;
    private ArrayList<Road> roads;


    @Before
    public void setUp() {
        difficulty = "Easy";
        player = new Player("Easy", "testName", R.drawable.chicken);
        map = new Map("Easy", player);
        roads = map.getRoad();

    }
    @Test
    public void checkPlayerLife() {
        player = new Player("Hard", "testName", R.drawable.chicken);
        assertTrue(player.getLives() == 6);
        player = new Player("Medium", "testName", R.drawable.chicken);
        assertTrue(player.getLives() == 8);
        player = new Player("Easy", "testName", R.drawable.chicken);
        assertTrue(player.getLives() == 10);
    }
    @Test
    public void checkPlayerSprite() {
        assertTrue(player.getImageOption() == R.drawable.chicken);
        player.setImageOption(R.drawable.duck);
        assertTrue(player.getImageOption() == R.drawable.duck);
        player.setImageOption(R.drawable.rabbit);
        assertTrue(player.getImageOption() == R.drawable.rabbit);
    }

    @Test
    public void checkCorrectCarOnRoad() {
        Road road1 = roads.get(0);
        String vehicleType1 = road1.getVehicleType();
        System.out.println(vehicleType1);
        assertTrue(vehicleType1.equals("car"));
        Road road2 = roads.get(1);
        String vehicleType2 = road2.getVehicleType();
        assertTrue(vehicleType2.equals("truck"));
        Road road3 = roads.get(2);
        String vehicleType3 = road3.getVehicleType();
        assertTrue(vehicleType3.equals("motorcycle"));
    }

    @Test
    public void checkVelocityBasedOnCarType() {
        Road road1 = roads.get(0);
        Vehicle vehicle = road1.getVehicles().get(0);
        assertTrue(vehicle.getVelocity() ==  1300);
        Road road2 = roads.get(1);
        Vehicle vehicle2 = road2.getVehicles().get(0);
        assertTrue(vehicle2.getVelocity() ==  1800);
        Road road3 = roads.get(2);
        Vehicle vehicle3 = road3.getVehicles().get(0);
        assertTrue(vehicle3.getVelocity() ==  800);
    }

}