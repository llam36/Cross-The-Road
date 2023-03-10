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
    private Player player;

    @Before
    public void setUp() {

        player = new Player();
    }

    @Test
    public void checkPlayerOffLeftScreen() {
        player.setCurrentPlayerX(0);
        player.updatePlayerLocation("left");
        assertEquals(0, player.getCurrentPlayerX());
    }
    @Test
    public void checkPlayerOffRightScreen() {
        player.setCurrentPlayerX(7);
        player.updatePlayerLocation("right");
        assertEquals(7, player.getCurrentPlayerX());
    }

    @Test
    public void checkPlayerOffTopScreen() {
        player.setCurrentPlayerY(0);
        player.updatePlayerLocation("up");
        assertEquals(0, player.getCurrentPlayerY());
    }

    @Test
    public void checkPlayerOffBottomScreen() {
        player.setCurrentPlayerY(9);
        player.updatePlayerLocation("down");
        assertEquals(9, player.getCurrentPlayerY());
    }
}