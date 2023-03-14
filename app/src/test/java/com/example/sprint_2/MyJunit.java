package com.example.sprint_2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyJunit {

    private Player player;
    private Map map;

    @Before
    public void setUp() {
        player = new Player();
        map = new Map("Easy", player);
    }
    @Test
    public void updatePosLeftTest() {
        int x = player.getPosX();
        player.updatePlayerLocation("left");
        assertTrue(x-1 == player.getPosX());
    }
    @Test
    public void updatePosRightTest() {
        int x = player.getPosX();
        player.updatePlayerLocation("right");
        assertTrue(x+1 == player.getPosX());
    }
    @Test
    public void checkScorePassTruck() {
        //move player to car lane to test score update
        while (!map.getLanes()[map.getPlayer().getPosY()].getVehicleType().equals("truck")) {
            map.getPlayer().updatePlayerLocation("up");
        }
        int score = player.getScore() + 3;
        map.getPlayer().updateScore(map, "up");
        assertEquals(score, player.getScore());
    }
    @Test
    public void checkScorePassMotocycle() {
        //move player to car lane to test score update
        while (!map.getLanes()[map.getPlayer().getPosY()].getVehicleType().equals("motorcycle")) {
            map.getPlayer().updatePlayerLocation("up");
        }
        int score = player.getScore() + 4;
        map.getPlayer().updateScore(map, "up");
        assertEquals(score, player.getScore());
    }

}