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
        player.setPosX(0);
        player.updatePlayerLocation("left");
        assertEquals(0, player.getPosX());
    }
    @Test
    public void checkPlayerOffRightScreen() {
        player.setPosX(7);
        player.updatePlayerLocation("right");
        assertEquals(7, player.getPosX());
    }

    @Test
    public void checkPlayerOffTopScreen() {
        player.setPosY(0);
        player.updatePlayerLocation("up");
        assertEquals(0, player.getPosY());
    }

    @Test
    public void checkPlayerOffBottomScreen() {
        player.setPosY(9);
        player.updatePlayerLocation("down");
        assertEquals(9, player.getPosY());
    }
}