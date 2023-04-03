package com.example.sprint_2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LongJunitMapScreen {
    private Player player;
    private Map map;

    @Before
    public void setUp() {
        player = new Player("Hard","MyName",0);
        map = new Map("Hard", player);
    }

    @Test
    public void checkPlayerOffLeftScreen() {
        player.setPosX(0);
        player.updatePlayerLocation("left");
        assertEquals(0, player.getPosX());
    }
    @Test
    public void checkPlayerOffRightScreen() {
        player.setPosX(7);
        player.updatePlayerLocation("right");
        assertEquals(7, player.getPosX());
    }

    @Test
    public void checkPlayerOffTopScreen() {
        player.setPosY(0);
        player.updatePlayerLocation("up");
        assertEquals(0, player.getPosY());
    }

    @Test
    public void checkPlayerOffBottomScreen() {
        player.setPosY(9);
        player.updatePlayerLocation("down");
        assertEquals(9, player.getPosY());
    }

    @Test
    public void checkScoreUpNotFirstTimeOnTile() {
        int score = map.getPlayer().getScore() + 1;
        map.getPlayer().updateScore(map, "up");
        map.getPlayer().updateScore(map, "down");
        map.getPlayer().updateScore(map, "up");
        assertEquals(score, map.getPlayer().getScore());
    }
    @Test
    public void checkScorePassCar() {
        //move player to car lane to test score update
        while (!map.getLanes()[map.getPlayer().getPosY()].getVehicleType().equals("car")) {
            map.getPlayer().updatePlayerLocation("up");
        }
        int score = player.getScore() + 2;
        map.getPlayer().updateScore(map, "up");
        assertEquals(score, player.getScore());
    }
    @Test
    public void checkLivesMoveUpCollision() {
        map.getPlayer().updatePlayerLocation("up");
        Road road = (Road) map.getLanes()[map.getPlayer().getPosY()];
        boolean collided = false;
        int lives = map.getPlayer().getLives();
        //wait for vehicle collision
        while (!collided) {
            ArrayList<Vehicle> vehicleList = road.getVehicles();
            for (int j = 0; j < vehicleList.size(); j++) {
                if (vehicleList.get(j).getPos() == map.getPlayer().getPos()) {
                    collided = true;
                    map.getPlayer().resetLocationScore();
                }
            }
        }
        assertEquals(lives - 1, map.getPlayer().getLives());
    }

    @Test
    public void checkLivesMoveDownCollision() {
        map.getPlayer().updatePlayerLocation("up");
        map.getPlayer().updatePlayerLocation("up");
        map.getPlayer().updatePlayerLocation("down");
        Road road = (Road) map.getLanes()[map.getPlayer().getPosY()];
        boolean collided = false;
        int lives = map.getPlayer().getLives();
        //wait for vehicle collision
        while (!collided) {
            ArrayList<Vehicle> vehicleList = road.getVehicles();
            for (int j = 0; j < vehicleList.size(); j++) {
                if (vehicleList.get(j).getPos() == map.getPlayer().getPos()) {
                    collided = true;
                    map.getPlayer().resetLocationScore();
                }
            }
        }
        assertEquals(lives - 1, map.getPlayer().getLives());
    }
}