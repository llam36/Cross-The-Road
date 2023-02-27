package com.example.sprint_2;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PranatiJunitTest {

    private Map gameMap;

    @Before
    public void setUp() {
        gameMap = new Map("Easy");
    }
    @Test
    public void updatePosUpTest() {
        int y = gameMap.getCurrentPlayerY();
        gameMap.updatePlayerLocationOnly("up");
        assertTrue(y-1 == gameMap.getCurrentPlayerY());
    }
    @Test
    public void updatePosDownTest() {
        gameMap.updatePlayerLocationOnly("up");
        int y = gameMap.getCurrentPlayerY();
        gameMap.updatePlayerLocationOnly("down");
        assertTrue(y+1 == gameMap.getCurrentPlayerY());
    }
}
