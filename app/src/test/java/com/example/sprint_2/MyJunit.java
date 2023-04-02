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
        //move player to truck lane to test score update
        while (!map.getLanes()[map.getPlayer().getPosY()].getVehicleType().equals("truck")) {
            map.getPlayer().updatePlayerLocation("up");
        }
        int score = player.getScore() + 3;
        map.getPlayer().updateScore(map, "up");
        assertEquals(score, player.getScore());
    }
    @Test
    public void checkScorePassMotocycle() {
        //move player to motorcycle lane to test score update
        while (!map.getLanes()[map.getPlayer().getPosY()].getVehicleType().equals("motorcycle")) {
            map.getPlayer().updatePlayerLocation("up");
            System.out.println("The player score is: " + player.getScore());
        }
        int score = player.getScore() + 4;
        map.getPlayer().updateScore(map, "up");
        System.out.println("The player score is: " + player.getScore());
        assertEquals(score, player.getScore());
    }
    @Test
    public void checkWaterCollisionScoreReset() {
        //move player to before river lane
        while (!map.getLanes()[map.getPlayer().getPosY()].getType().equals("River")) {
            map.getPlayer().updatePlayerLocation("up");
            player.updateScore(map, "up");
        }
        int score = player.getScore();
        player.resetLocationScore();
        assertNotEquals(score, player.getScore());
        assertEquals(0, player.getScore());
    }

    @Test
    public void checkKeepingTotalScore() {
        map.getPlayer().updatePlayerLocation("up");
        player.updateScore(map, "up");
        int score = map.getPlayer().getScore();
        map.getPlayer().resetLocationScore();
        int totalScore = map.getPlayer().getTotalScore();
        assertEquals(score, totalScore);
        assertNotEquals(totalScore, map.getPlayer().getScore());
    }

}