package com.example.sprint_2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PranatiJunit {

    private Player player;
    private Map map;

    @Before
    public void setUp() {
        player = new Player();
    }
    @Test
    public void updatePosUpTest() {
        int y = player.getPosY();
        player.updatePlayerLocation("up");
        assertTrue(y-1 == player.getPosY());
    }
    @Test
    public void updatePosDownTest() {
        player.updatePlayerLocation("up");
        int y = player.getPosY();
        player.updatePlayerLocation("down");
        assertTrue(y+1 == player.getPosY());
    }


    @Test
    public void checkTheScoreLeft() {
        int x = player.getScore();
        player.updateScore(map,"left");
        assertEquals(x,player.getScore());
    }
    @Test
    public void checkTheScoreRight() {
        int x = player.getScore();
        player.updateScore(map,"right");
        assertEquals(x,player.getScore());
    }

    @Test
    public void checkThePositionAfterRiverCollision(){
        while (!map.getLanes()[map.getPlayer().getPosY()].getType().equals("River")) {
            map.getPlayer().updatePlayerLocation("up");
            player.updateScore(map, "up");
        }
        player.resetLocationScore();
        int x = 4;//initial x loc
        int y = 9;//initial y loc
        assertEquals(x,player.getPosX());
        assertEquals(y,player.getPosY());

    }

    @Test
    public void checkTheLivesAfterRiverCollision(){
        while (!map.getLanes()[map.getPlayer().getPosY()].getType().equals("River")) {
            map.getPlayer().updatePlayerLocation("up");
        }
        int lives = player.getLives();
        player.resetLocationScore();
        assertNotEquals(lives, player.getLives());
        assertEquals(lives - 1, player.getLives());
    }


}
