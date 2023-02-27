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
    public void checkPlayerOffScreen() {
        gameMap.setCurrentPlayerX(0);
        
    }
}