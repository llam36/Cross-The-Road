package com.example.sprint_2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyJunit {

    private Map gameMap;

    @Before
    public void setUp() {
        gameMap = new Map("Easy");
    }
    @Test
    public void updatePosLeftTest() {
        int x = gameMap.getCurrentPlayerX();
        gameMap.updatePlayerLocationOnly("left");
        assertTrue(x-1 == gameMap.getCurrentPlayerX());
    }
    @Test
    public void updatePosRightTest() {
        int x = gameMap.getCurrentPlayerY();
        gameMap.updatePlayerLocationOnly("right");
        assertTrue(x+1 == gameMap.getCurrentPlayerX());
    }
}
