package com.example.sprint_2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LongJunitMapScreen {
    private Map gameMap;

    @Before
    public void setUp() {
        gameMap = new Map("Easy");
    }

    @Test
    public void checkPlayerOffLeftScreen() {
        gameMap.setCurrentPlayerX(0);
        gameMap.updatePlayerLocationOnly("left");
        assertEquals(0, gameMap.getCurrentPlayerX());
    }
    @Test
    public void checkPlayerOffRightScreen() {
        gameMap.setCurrentPlayerX(7);
        gameMap.updatePlayerLocationOnly("right");
        assertEquals(7, gameMap.getCurrentPlayerX());
    }

    @Test
    public void checkPlayerOffTopScreen() {
        gameMap.setCurrentPlayerY(0);
        gameMap.updatePlayerLocationOnly("up");
        assertEquals(0, gameMap.getCurrentPlayerY());
    }

    @Test
    public void checkPlayerOffBottomScreen() {
        gameMap.setCurrentPlayerY(9);
        gameMap.updatePlayerLocationOnly("down");
        assertEquals(9, gameMap.getCurrentPlayerY());
    }
}