package com.example.sprint_2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PranatiJunit {

    private Player player;

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
}
