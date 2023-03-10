package com.example.sprint_2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyJunit {

    private Player player;

    @Before
    public void setUp() {
        player = new Player();
    }
    @Test
    public void updatePosLeftTest() {
        int x = player.getCurrentPlayerX();
        player.updatePlayerLocation("left");
        assertTrue(x-1 == player.getCurrentPlayerX());
    }
    @Test
    public void updatePosRightTest() {
        int x = player.getCurrentPlayerX();
        player.updatePlayerLocation("right");
        assertTrue(x+1 == player.getCurrentPlayerX());
    }
}